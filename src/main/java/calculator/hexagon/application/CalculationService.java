package calculator.hexagon.application;

import calculator.hexagon.in.StringSumCalculator;
import calculator.hexagon.out.InOutHandler;

public class CalculationService implements StringSumCalculator {
    private final InOutHandler ioHandler;
    private final StringNumberCalculator calculator;

    private String input = "";
    private int result = 0;

    public CalculationService(
            InOutHandler ioHandler,
            StringNumberCalculator calculator
    ) {
        this.ioHandler = ioHandler;
        this.calculator = calculator;
    }

    @Override
    public void readInput() {
        this.result = 0;
        this.input = ioHandler.readIn();
    }

    @Override
    public void sum() throws IllegalArgumentException {
        result = calculator.calculate(input);
    }

    @Override
    public void writeResult() {
        ioHandler.writeOut(result);
    }

}
