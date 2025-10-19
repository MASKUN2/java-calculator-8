package calculator.hexagon.application;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.Result;
import calculator.hexagon.in.Calculator;
import calculator.hexagon.out.InOutHandler;

public class CalculatorImpl implements Calculator {
    private final InOutHandler ioHandler;
    private final StringSumProcessor processor;

    private Input input = Input.EMPTY;
    private Result result = Result.ZERO;

    public CalculatorImpl(
            InOutHandler ioHandler,
            StringSumProcessor processor
    ) {
        this.ioHandler = ioHandler;
        this.processor = processor;
    }

    @Override
    public void readInput() {
        this.result = Result.ZERO;
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
