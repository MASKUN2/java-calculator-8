package calculator.hexagon.application;

import calculator.hexagon.domain.Calculator;
import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.PositiveNumberValidator;
import calculator.hexagon.in.StringSumCalculator;
import calculator.hexagon.out.InOutHandler;
import java.util.List;

public class StringSumCalculatorImpl implements StringSumCalculator {
    private final InOutHandler ioHandler;
    private final StringNumberSplitter splitter;
    private final NumberParser numberParser;
    private final PositiveNumberValidator positiveNumberValidator;
    private final Calculator calculator;

    private String input = "";
    private int result = 0;

    public StringSumCalculatorImpl(
            InOutHandler ioHandler,
            StringNumberSplitter splitter,
            NumberParser numberParser,
            PositiveNumberValidator positiveNumberValidator,
            Calculator calculator
    ) {
        this.ioHandler = ioHandler;
        this.splitter = splitter;
        this.numberParser = numberParser;
        this.positiveNumberValidator = positiveNumberValidator;
        this.calculator = calculator;

    }

    @Override
    public void readInput() {
        this.result = 0;
        this.input = ioHandler.readIn();
    }

    @Override
    public void sum() {
        List<String> parts = splitter.split(input);
        List<Integer> integers = parse(parts);
        validateNumber(integers);
        result = calculator.sum(integers);
    }

    @Override
    public void writeResult() {
        ioHandler.writeOut(result);
    }


    private List<Integer> parse(List<String> parts) {
        return parts.stream()
                .map(numberParser::parse)
                .toList();
    }

    private void validateNumber(List<Integer> integers) {
        for (Integer number : integers) {
            positiveNumberValidator.check(number);
        }
    }

}
