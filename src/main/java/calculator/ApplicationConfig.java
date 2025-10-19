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
import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.PositiveIntegerValidator;
import calculator.hexagon.domain.PositiveNumberValidator;
import calculator.hexagon.domain.Splitter;
import calculator.hexagon.domain.StringSplitter;
import calculator.hexagon.domain.SumLogic;
import calculator.hexagon.in.Calculator;
import calculator.hexagon.out.InOutHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ApplicationConfig {
    private static final Map<Class<?>, Object> BEANS = new ConcurrentHashMap<>();

    private ApplicationConfig() {
    }

    public static Calculator calculator() {
        return new CalculatorImpl(
                inOutHandler(),
                stringSumProcessor()
        );
    }

    private static InOutHandler inOutHandler() {
        return get(InOutHandler.class, CalculatorController::new);
    }

    private static StringSumProcessor stringSumProcessor() {
        Supplier<StringSumProcessor> supplier = () -> new StringSumProcesserImpl(
                stringNumberSplitter(),
                stringIntegerParser(),
                sumLogic()
        );
        return get(StringSumProcessor.class, supplier);
    }

    private static StringNumberSplitter stringNumberSplitter() {
        Supplier<StringNumberSplitter> supplier = () -> new InputSplitter(
                new CustomDelimiterDeclarer(),
                delimiterValidator(),
                splitter()
        );
        return get(StringNumberSplitter.class, supplier);
    }


    private static StringIntegerParser stringIntegerParser() {
        Supplier<StringIntegerParser> supplier = () -> new StringIntegerParserImpl(
                numberParser(),
                positiveNumberValidator());
        return get(StringIntegerParser.class, supplier);
    }

    private static SumLogic sumLogic() {
        return get(SumLogic.class, IntegerSumLogic::new);
    }

    private static DelimiterValidator delimiterValidator() {
        return get(DelimiterValidator.class, DelimiterValidator::new);
    }

    private static Splitter splitter() {
        return get(Splitter.class, StringSplitter::new);
    }

    private static NumberParser numberParser() {
        return get(NumberParser.class, IntegerParser::new);
    }

    private static PositiveNumberValidator positiveNumberValidator() {
        return get(PositiveNumberValidator.class, PositiveIntegerValidator::new);
    }

    private static <T> T get(Class<T> type, Supplier<T> supplier) {
        Function<Class<?>, Object> beanSupplier = k -> supplier.get();
        Object bean = BEANS.computeIfAbsent(type, beanSupplier);
        return type.cast(bean);
    }
}
