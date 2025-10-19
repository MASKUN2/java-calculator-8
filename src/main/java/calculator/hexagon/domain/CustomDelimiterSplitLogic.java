package calculator.hexagon.domain;

import calculator.hexagon.domain.model.SeparatedInput;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomDelimiterSplitLogic implements SplitLogic {
    private final List<String> badTokens = List.of("\n", ".");
    private final String PREFIX = "//";
    private final String SUBFIX = "\\n";
    Set<String> DEFAULT_DELIMITERS = Set.of(",", ":");

    @Override
    public List<String> split(String input) throws IllegalArgumentException {
        SeparatedInput separated = separate(input);
        Optional<String> found = extractDelimiter(separated.customDelimiterDeclaration());

        if (found.isPresent()) {
            String customDelimiter = found.get();
            check(customDelimiter);
            return splitWithCustomDelimiter(separated.stringNumbers(), customDelimiter);
        }

        return defaultSplit(separated.stringNumbers());
    }

    private SeparatedInput separate(String input) {
        if (!hasDeclaration(input)) {
            return new SeparatedInput("", input);
        }

        String declaration = extractDeclaration(input);
        String rest = input.substring(declaration.length());

        return new SeparatedInput(declaration, rest);
    }

    private Optional<String> extractDelimiter(String declaration) {
        if (!hasDeclaration(declaration)) {
            return Optional.empty();
        }

        String delimiter = extractCustomDelimiter(declaration);

        return Optional.of(delimiter);
    }

    private boolean hasDeclaration(String input) {
        return input.startsWith(PREFIX) && input.contains(SUBFIX);
    }

    private String extractDeclaration(String input) {
        int suffixIndex = input.lastIndexOf(SUBFIX);
        int exclusiveEndIndex = suffixIndex + SUBFIX.length();

        return input.substring(0, exclusiveEndIndex);
    }

    private String extractCustomDelimiter(String declaration) {
        int startIndex = PREFIX.length();
        int exclusiveEndIndex = declaration.lastIndexOf(SUBFIX);

        return declaration.substring(startIndex, exclusiveEndIndex);
    }

    private void check(String target) {
        checkEmpty(target);
        checkContainsBadToken(target);
        checkNumeric(target);

    }

    private void checkEmpty(String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (빈문자열)");
        }
    }

    private void checkContainsBadToken(String target) {
        for (String badToken : badTokens) {
            if (target.contains(badToken)) {
                throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 :" + badToken);
            }
        }
    }

    private void checkNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            return;
        }
        throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (숫자): " + target);
    }

    private List<String> defaultSplit(String input) {
        String[] parts = input.split(defaultDelimiterRegex());
        return List.of(parts);
    }

    private List<String> splitWithCustomDelimiter(String input, String customDelimiter) {
        String regex = extendCustomDelimiterRegex(customDelimiter);
        String[] parts = input.split(regex);
        return List.of(parts);
    }

    private String extendCustomDelimiterRegex(String customDelimiter) {
        Set<String> extended = new HashSet<>(DEFAULT_DELIMITERS);
        String escapedDelimiter = Pattern.quote(customDelimiter);
        extended.add(escapedDelimiter);
        return String.join("|", extended);
    }

    private String defaultDelimiterRegex() {
        return String.join("|", DEFAULT_DELIMITERS);
    }
}
