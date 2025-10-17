package calculator.hexagon;

import java.util.Optional;

public class CustomDelimiterDeclarer {

    private final String PREFIX = "//";
    private final String SUBFIX = "\\n";

    public Optional<String> find(String input) {
        if (!isDeclared(input)) {
            return Optional.empty();
        }

        String extracted = extract(input);
        return Optional.of(extracted);
    }

    private boolean isDeclared(String input) {
        return input.startsWith(PREFIX) && input.contains(SUBFIX);
    }

    private String extract(String input) {
        int startIndex = PREFIX.length();
        int exclusiveEndIndex = input.lastIndexOf(SUBFIX);

        return input.substring(startIndex, exclusiveEndIndex);
    }
}
