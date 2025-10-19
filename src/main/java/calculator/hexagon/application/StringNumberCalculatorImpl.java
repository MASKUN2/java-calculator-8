package calculator.hexagon.application;

import calculator.hexagon.domain.Calculator;
import java.util.List;

public class StringNumberCalculatorImpl implements StringNumberCalculator {
    private final StringNumberSplitter splitter;
    private final StringIntegerParser stringIntegerParser;
    private final Calculator calculator;


    public StringNumberCalculatorImpl(
            StringNumberSplitter splitter,
            StringIntegerParser stringIntegerParser,
            Calculator calculator
    ) {
        this.splitter = splitter;
        this.stringIntegerParser = stringIntegerParser;
        this.calculator = calculator;

    }

    @Override
    public int calculate(String input) throws IllegalArgumentException {
        List<String> parts = splitter.split(input);
        List<Integer> integers = stringIntegerParser.parse(parts);
        return calculator.sum(integers);
    }
}
