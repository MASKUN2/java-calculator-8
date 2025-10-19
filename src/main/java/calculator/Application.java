package calculator;

import calculator.hexagon.in.StringSumCalculator;

public class Application {
    public static void main(String[] args) {
        StringSumCalculator calculator = ApplicationConfig.stringSumCalculator();
        calculator.readInput();
        calculator.sum();
        calculator.writeResult();
    }
}
