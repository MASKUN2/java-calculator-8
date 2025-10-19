package calculator.hexagon.application;

import java.util.List;

public interface StringIntegerParser {
    List<Integer> parse(List<String> parts) throws IllegalArgumentException;
}
