package calculator;

import calculator.adaptor.UserInOutHandler;
import calculator.hexagon.application.CalculatorImpl;
import calculator.hexagon.application.DelimitedStringSumProcesser;
import calculator.hexagon.domain.CustomDelimiterSplitter;
import calculator.hexagon.domain.IntegerSumLogic;
import calculator.hexagon.domain.StringIntegerParser;
import calculator.hexagon.in.Calculator;

public final class ApplicationConfig {

    private ApplicationConfig() {
    }

    public static Calculator calculator() {
        return new CalculatorImpl(
                UserInOutHandler.getInstance(),
                getProcessor()
        );
    }

    private static DelimitedStringSumProcesser getProcessor() {
        return new DelimitedStringSumProcesser(
                CustomDelimiterSplitter.getInstance(),
                StringIntegerParser.getInstance(),
                IntegerSumLogic.getInstance()
        );
    }

}
