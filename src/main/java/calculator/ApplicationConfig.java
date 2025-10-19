package calculator;

import calculator.adaptor.CalculatorController;
import calculator.hexagon.application.InputSplitter;
import calculator.hexagon.application.StringIntegerParser;
import calculator.hexagon.application.StringIntegerParserImpl;
import calculator.hexagon.application.StringNumberSplitter;
import calculator.hexagon.application.StringSumCalculatorImpl;
import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.IntegerCalculator;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.PositiveIntegerValidator;
import calculator.hexagon.domain.StringSplitter;
import calculator.hexagon.in.StringSumCalculator;

public final class ApplicationConfig {

    private ApplicationConfig() {
    }

    public static StringSumCalculator stringSumCalculator() {
        return new StringSumCalculatorImpl(
                new CalculatorController(),
                stringNumberSplitter(),
                stringIntegerParser(),
                new IntegerCalculator()
        );
    }

    private static StringNumberSplitter stringNumberSplitter() {
        return new InputSplitter(
                new CustomDelimiterDeclarer(),
                new DelimiterValidator(),
                new StringSplitter()
        );
    }

    private static StringIntegerParser stringIntegerParser() {
        return new StringIntegerParserImpl(
                new IntegerParser(),
                new PositiveIntegerValidator()
        );
    }
}
