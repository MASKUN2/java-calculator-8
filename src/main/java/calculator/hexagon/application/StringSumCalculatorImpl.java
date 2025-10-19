package calculator.hexagon.application;

import calculator.hexagon.domain.Calculator;
import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.PositiveNumberValidator;
import calculator.hexagon.domain.Splitter;
import calculator.hexagon.domain.model.SeparatedInput;
import calculator.hexagon.in.StringSumCalculator;
import calculator.hexagon.out.InOutHandler;
import java.util.List;
import java.util.Optional;

public class StringSumCalculatorImpl implements StringSumCalculator {
    private final InOutHandler ioHandler;
    private final CustomDelimiterDeclarer customDelimiterDeclarer;
    private final DelimiterValidator delimiterValidator;
    private final Splitter splitter;
    private final NumberParser numberParser;
    private final PositiveNumberValidator positiveNumberValidator;
    private final Calculator calculator;

    private String input = "";
    private int result = 0;

    public StringSumCalculatorImpl(
            InOutHandler ioHandler,
            CustomDelimiterDeclarer customDelimiterDeclarer,
            DelimiterValidator delimiterValidator,
            Splitter splitter,
            NumberParser numberParser,
            PositiveNumberValidator positiveNumberValidator,
            Calculator calculator
    ) {
        this.ioHandler = ioHandler;
        this.customDelimiterDeclarer = customDelimiterDeclarer;
        this.delimiterValidator = delimiterValidator;
        this.splitter = splitter;
        this.numberParser = numberParser;
        this.positiveNumberValidator = positiveNumberValidator;
        this.calculator = calculator;

    }

    @Override
    public void readInput() {
        this.result = 0;
        this.input = ioHandler.readIn();
    }

    @Override
    public void sum() {
        SeparatedInput separated = customDelimiterDeclarer.separate(input);
        List<String> parts = split(separated);
        List<Integer> integers = parse(parts);
        validateNumber(integers);
        result = calculator.sum(integers);
    }

    @Override
    public void writeResult() {
        ioHandler.writeOut(result);
    }

    private List<String> split(SeparatedInput separated) {
        Optional<String> found = findCustomDelimiter(separated);

        if (found.isPresent()) {
            String customDelimiter = found.get();
            delimiterValidator.check(customDelimiter);
            return splitter.splitWithCustomDelimiter(separated.stringNumbers(), customDelimiter);
        }

        return splitter.defaultSplit(separated.stringNumbers());
    }

    private Optional<String> findCustomDelimiter(SeparatedInput separated) {
        return customDelimiterDeclarer.extractDelimiter(separated.customDelimiterDeclaration());
    }

    private List<Integer> parse(List<String> parts) {
        return parts.stream()
                .map(numberParser::parse)
                .toList();
    }

    private void validateNumber(List<Integer> integers) {
        for (Integer number : integers) {
            positiveNumberValidator.check(number);
        }
    }
}
