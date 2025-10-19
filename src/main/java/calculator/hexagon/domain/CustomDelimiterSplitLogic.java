package calculator.hexagon.domain;

import static calculator.hexagon.domain.model.Delimiter.DECLARE_PREFIX;
import static calculator.hexagon.domain.model.Delimiter.DECLARE_SUFFIX;
import static calculator.hexagon.domain.model.Delimiter.DEFAULT;
import static calculator.hexagon.domain.model.Delimiter.FORBIDDEN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomDelimiterSplitLogic implements SplitLogic {

    @Override
    public List<String> split(String input) throws IllegalArgumentException {
        if (hasDeclaration(input)) {
            return splitByCustomDelimiter(input);
        }

        return defaultSplit(input);
    }

    private boolean hasDeclaration(String input) {
        return input.startsWith(DECLARE_PREFIX) && input.contains(DECLARE_SUFFIX);
    }

    private List<String> splitByCustomDelimiter(String input) {
        String delimiter = extractCustomDelimiter(input);
        check(delimiter);
        String numbersPart = trimDeclaration(input);
        return splitWithCustomDelimiter(numbersPart, delimiter);
    }

    private String extractCustomDelimiter(String declaration) {
        int startIndex = DECLARE_PREFIX.length();
        int exclusiveEndIndex = declaration.lastIndexOf(DECLARE_SUFFIX);
        return declaration.substring(startIndex, exclusiveEndIndex);
    }

    private void check(String target) {
        noEmpty(target);
        noInForbidden(target);
        noNumeric(target);

    }

    private void noEmpty(String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (빈문자열)");
        }
    }

    private void noInForbidden(String target) {
        for (String badToken : FORBIDDEN) {
            if (target.contains(badToken)) {
                throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 :" + badToken);
            }
        }
    }

    private void noNumeric(String target) {
        if (isNumeric(target)) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (숫자): " + target);
        }
    }

    private static boolean isNumeric(String target) {
        try {
            Double.parseDouble(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String trimDeclaration(String input) {
        int suffixIndex = input.lastIndexOf(DECLARE_SUFFIX);
        int exclusiveEndIndex = suffixIndex + DECLARE_SUFFIX.length();
        return input.substring(exclusiveEndIndex);
    }

    private List<String> defaultSplit(String input) {
        String regex = getRegex(DEFAULT);
        String[] parts = input.split(regex);
        return List.of(parts);
    }

    private List<String> splitWithCustomDelimiter(String input, String customDelimiter) {
        String regex = extendRegex(customDelimiter);
        String[] parts = input.split(regex);
        return List.of(parts);
    }

    private String extendRegex(String customDelimiter) {
        Set<String> extended = new HashSet<>(DEFAULT);
        extended.add(customDelimiter);
        return getRegex(extended);
    }

    private String getRegex(Set<String> delimiters) {
        List<String> escaped = delimiters.stream()
                .map(Pattern::quote)
                .toList();
        return String.join("|", escaped);
    }

}
