package calculator;

import calculator.adaptor.CalculatorController;
import calculator.hexagon.application.CalculatorImpl;
import calculator.hexagon.application.StringSumProcesserImpl;
import calculator.hexagon.domain.CustomDelimiterSplitLogic;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.IntegerSumLogic;
import calculator.hexagon.in.Calculator;

public final class ApplicationConfig {

    private ApplicationConfig() {
    }

    public static Calculator calculator() {
        return new CalculatorImpl(
                CalculatorController.getInstance(),
                getProcessor()
        );
    }

    private static StringSumProcesserImpl getProcessor() {
        return new StringSumProcesserImpl(
                CustomDelimiterSplitLogic.getInstance(),
                IntegerParser.getInstance(),
                IntegerSumLogic.getInstance()
        );
    }

}
