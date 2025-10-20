package calculator.hexagon.domain;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.Result;
import java.util.List;

public interface IntegerSumProcessor {
    Result sum(List<ParsedInteger> numbers);
}
