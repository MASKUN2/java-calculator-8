package calculator.hexagon.domain;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public interface IntegerParser {
    List<ParsedInteger> parse(List<SingleIntegerPart> parts) throws IllegalArgumentException;
}
