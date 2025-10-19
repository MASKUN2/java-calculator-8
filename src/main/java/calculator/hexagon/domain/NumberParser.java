package calculator.hexagon.domain;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public interface NumberParser {
    List<ParsedInteger> parse(List<SingleIntegerPart> input) throws IllegalArgumentException;
}
