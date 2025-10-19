package calculator.hexagon.domain;

import java.util.List;

public interface NumberParser {
    List<Integer> parse(List<String> input) throws IllegalArgumentException;
}
