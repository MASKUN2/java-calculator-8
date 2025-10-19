package calculator.hexagon.application;

import calculator.hexagon.in.Calculator;
import calculator.hexagon.out.InOutHandler;

public class CalculatorImpl implements Calculator {
    private final InOutHandler ioHandler;
    private final StringSumProcessor processor;

    private String input = "";
    private int result = 0;

    public CalculatorImpl(
            InOutHandler ioHandler,
            StringSumProcessor processor
    ) {
        this.ioHandler = ioHandler;
        this.processor = processor;
    }

    @Override
    public void readInput() {
        this.result = 0;
        this.input = ioHandler.readIn();
    }

    @Override
    public void sum() throws IllegalArgumentException {
        result = processor.parseAndSum(input);
    }

    @Override
    public void writeResult() {
        ioHandler.writeOut(result);
    }

}
