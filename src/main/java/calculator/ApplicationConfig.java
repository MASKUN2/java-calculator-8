package calculator;

import calculator.adaptor.CalculatorController;
import calculator.hexagon.application.CalculatorImpl;
import calculator.hexagon.application.InputSplitter;
import calculator.hexagon.application.StringIntegerParser;
import calculator.hexagon.application.StringIntegerParserImpl;
import calculator.hexagon.application.StringNumberSplitter;
import calculator.hexagon.application.StringSumProcesserImpl;
import calculator.hexagon.application.StringSumProcessor;
import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.IntegerSumLogic;
import calculator.hexagon.domain.PositiveIntegerValidator;
import calculator.hexagon.domain.StringSplitter;
import calculator.hexagon.in.Calculator;

public final class ApplicationConfig {

    private ApplicationConfig() {
    }

    public static Calculator calculator() {
        return new CalculatorImpl(
                new CalculatorController(),
                stringSumProcessor()
        );
    }

    private static StringSumProcessor stringSumProcessor() {
        return new StringSumProcesserImpl(
                stringNumberSplitter(),
                stringIntegerParser(),
                new IntegerSumLogic()
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
