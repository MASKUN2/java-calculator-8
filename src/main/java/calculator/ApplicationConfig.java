package calculator;

import calculator.adaptor.IntergerResultPrinter;
import calculator.adaptor.RunInstructor;
import calculator.adaptor.StringInputReader;
import calculator.hexagon.application.StringSumCalculatorImpl;
import calculator.hexagon.domain.*;
import calculator.hexagon.provided.StringSumCalculator;

public class ApplicationConfig {

    public StringSumCalculator stringSumCalculator() {
        return new StringSumCalculatorImpl(
                new RunInstructor(),
                new StringInputReader(),
                new CustomDelimiterDeclarer(),
                new DelimiterValidator(),
                new StringSplitter(),
                new IntegerParser(),
                new PositiveIntegerValidator(),
                new IntegerCalculator(),
                new IntergerResultPrinter()
        );
    }
}
