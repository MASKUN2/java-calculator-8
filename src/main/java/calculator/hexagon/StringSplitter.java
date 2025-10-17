package calculator.hexagon;

import java.util.List;

public class StringSplitter implements Splitter {

    @Override
    public List<String> defaultSplit(String input) {
        String[] parts = input.split(defaultDelimiterRegex());
        return List.of(parts);
    }

    private String defaultDelimiterRegex() {
        return String.join("|", Splitter.DEFAULT_DELIMITERS);
    }
}
