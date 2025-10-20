package calculator.hexagon.application;

import calculator.hexagon.domain.DelimiterSplitter;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.IntegerSumProcessor;
import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.Result;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public class DelimitedStringSumProcesser implements StringSumProcessor {
    private final DelimiterSplitter delimiterSplitter;
    private final IntegerParser integerParser;
    private final IntegerSumProcessor integerSumProcessor;

    public DelimitedStringSumProcesser(
            DelimiterSplitter delimiterSplitter,
            IntegerParser integerParser,
            IntegerSumProcessor integerSumProcessor
    ) {
        this.delimiterSplitter = delimiterSplitter;
        this.integerParser = integerParser;
        this.integerSumProcessor = integerSumProcessor;

    }

    @Override
    public Result parseAndSum(Input input) throws IllegalArgumentException {
        List<SingleIntegerPart> parts = delimiterSplitter.split(input);
        List<ParsedInteger> integers = integerParser.parse(parts);
        return integerSumProcessor.sum(integers);
    }
}
