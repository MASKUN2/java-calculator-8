package calculator.hexagon.domain;

import java.util.List;
import java.util.Set;

public interface Splitter {
    Set<String> DEFAULT_DELIMITERS = Set.of(",", ":");

    List<String> defaultSplit(String input);

    List<String> splitWithCustomDelimiter(String input, String customDelimiter);
}
