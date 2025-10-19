package calculator.hexagon.application;

import calculator.hexagon.domain.Calculator;
import calculator.hexagon.in.StringSumCalculator;
import calculator.hexagon.out.InOutHandler;
import java.util.List;

public class StringSumCalculatorImpl implements StringSumCalculator {
    private final InOutHandler ioHandler;
    private final StringNumberSplitter splitter;
    private final StringIntegerParser stringIntegerParser;
    private final Calculator calculator;

    private String input = "";
    private int result = 0;

    public StringSumCalculatorImpl(
            InOutHandler ioHandler,
            StringNumberSplitter splitter,
            StringIntegerParser stringIntegerParser,
            Calculator calculator
    ) {
        this.ioHandler = ioHandler;
        this.splitter = splitter;
        this.stringIntegerParser = stringIntegerParser;
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
        List<Integer> integers = stringIntegerParser.parse(parts);
        result = calculator.sum(integers);
    }

    @Override
    public void writeResult() {
        ioHandler.writeOut(result);
    }


}
