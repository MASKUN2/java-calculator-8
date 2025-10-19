package calculator.hexagon.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class StringSplitter implements Splitter {

    @Override
    public List<String> defaultSplit(String input) {
        String[] parts = input.split(defaultDelimiterRegex());
        return List.of(parts);
    }

    @Override
    public List<String> splitWithCustomDelimiter(String input, String customDelimiter) {
        String regex = extendCustomDelimiterRegex(customDelimiter);
        String[] parts = input.split(regex);
        return List.of(parts);
    }

    private String extendCustomDelimiterRegex(String customDelimiter) {
        Set<String> extended = new HashSet<>(Splitter.DEFAULT_DELIMITERS);
        String escapedDelimiter = Pattern.quote(customDelimiter);
        extended.add(escapedDelimiter);
        return String.join("|", extended);
    }

    private String defaultDelimiterRegex() {
        return String.join("|", Splitter.DEFAULT_DELIMITERS);
    }
}
