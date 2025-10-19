package calculator;

import calculator.hexagon.in.Calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = ApplicationConfig.calculator();
        calculator.readInput();
        calculator.sum();
        calculator.writeResult();
    }
}
