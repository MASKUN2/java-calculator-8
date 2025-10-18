package calculator;

import calculator.hexagon.in.StringSumCalculator;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig config = new ApplicationConfig();
        StringSumCalculator calculator = config.stringSumCalculator();
        calculator.printWelcome();
        calculator.readInput();
        calculator.sum();
        calculator.printResult();
    }
}
