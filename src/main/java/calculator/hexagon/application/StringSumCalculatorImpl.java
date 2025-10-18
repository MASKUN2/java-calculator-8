package calculator.hexagon.application;

import calculator.adaptor.StringInputReader;
import calculator.hexagon.domain.*;
import calculator.hexagon.domain.model.SeparatedInput;
import calculator.hexagon.provided.StringSumCalculator;
import calculator.hexagon.required.Instructor;
import calculator.hexagon.required.ResultPrinter;

import java.util.List;
import java.util.Optional;

public class StringSumCalculatorImpl implements StringSumCalculator {
    private final Instructor instructor;
    private final StringInputReader stringInputReader;
    private final ResultPrinter IntResultPrinter;
    private final CustomDelimiterDeclarer customDelimiterDeclarer;
    private final DelimiterValidator delimiterValidator;
    private final Splitter splitter;
    private final NumberParser numberParser;
    private final Calculator calculator;

    private String input = "";
    private int result = 0;

    public StringSumCalculatorImpl(Instructor instructor,
                                   StringInputReader stringInputReader,
                                   CustomDelimiterDeclarer customDelimiterDeclarer,
                                   DelimiterValidator delimiterValidator,
                                   Splitter splitter,
                                   NumberParser numberParser,
                                   Calculator calculator,
                                   ResultPrinter IntResultPrinter
    ) {
        this.instructor = instructor;
        this.stringInputReader = stringInputReader;
        this.IntResultPrinter = IntResultPrinter;
        this.customDelimiterDeclarer = customDelimiterDeclarer;
        this.delimiterValidator = delimiterValidator;
        this.splitter = splitter;
        this.numberParser = numberParser;
        this.calculator = calculator;

    }

    @Override
    public void printWelcome() {
        instructor.print();
    }

    @Override
    public void readInput() {
        this.result = 0;
        this.input = stringInputReader.read();
    }

    @Override
    public void sum() {
        SeparatedInput separated = customDelimiterDeclarer.separate(input);
        List<String> parts = split(separated);
        List<Integer> integers = parse(parts);
        result = calculator.sum(integers);
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

    @Override
    public void printResult() {
        IntResultPrinter.print(result);
    }
}
