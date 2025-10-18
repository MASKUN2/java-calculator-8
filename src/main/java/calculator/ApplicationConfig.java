package calculator;

import calculator.adaptor.IntergerResultPrinter;
import calculator.adaptor.StringInputReader;
import calculator.adaptor.SystemInputInstructor;
import calculator.hexagon.application.StringSumCalculatorImpl;
import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.IntegerCalculator;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.PositiveIntegerValidator;
import calculator.hexagon.domain.StringSplitter;
import calculator.hexagon.in.StringSumCalculator;

public class ApplicationConfig {

    public StringSumCalculator stringSumCalculator() {
        return new StringSumCalculatorImpl(
                new SystemInputInstructor(),
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
