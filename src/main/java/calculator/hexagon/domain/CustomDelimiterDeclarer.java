package calculator.hexagon.domain;

import calculator.hexagon.domain.model.SeparatedInput;

import java.util.Optional;

public class CustomDelimiterDeclarer implements InputSeparator, CustomDelimiterExtractor {

    private final String PREFIX = "//";
    private final String SUBFIX = "\\n";

    @Override
    public SeparatedInput separate(String input) {
        if (!hasDeclaration(input)) {
            return new SeparatedInput("", input);
        }

        String declaration = extractDeclaration(input);
        String rest = input.substring(declaration.length());

        return new SeparatedInput(declaration, rest);
    }

    @Override
    public Optional<String> extractDelimiter(String declaration) {
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
}
