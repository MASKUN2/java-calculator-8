package calculator.hexagon.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSplitter implements Splitter {

    @Override
    public List<String> defaultSplit(String input) {
        String[] parts = input.split(defaultDelimiterRegex());
        return List.of(parts);
    }

    @Override
    public List<String> splitWithCustomDelimiter(String input, String customDelimiter) {
        String[] parts = input.split(extendCustomDelimiterRegex(customDelimiter));
        return List.of(parts);
    }

    private String extendCustomDelimiterRegex(String customDelimiter) {
        Set<String> extended = new HashSet<>(Splitter.DEFAULT_DELIMITERS);
        extended.add(customDelimiter);
        return String.join("|", extended);
    }

    private String defaultDelimiterRegex() {
        return String.join("|", Splitter.DEFAULT_DELIMITERS);
    }
}
