package calculator.hexagon.application;

import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.PositiveNumberValidator;
import java.util.List;

public class StringIntegerParserImpl implements StringIntegerParser {
    private final NumberParser numberParser;
    private final PositiveNumberValidator positiveNumberValidator;

    public StringIntegerParserImpl(NumberParser numberParser,
                                   PositiveNumberValidator positiveNumberValidator) {
        this.numberParser = numberParser;
        this.positiveNumberValidator = positiveNumberValidator;

    }

    @Override
    public List<Integer> parse(List<String> parts) {
        List<Integer> integers = parseInt(parts);
        validateNumber(integers);
        return integers;
    }

    private List<Integer> parseInt(List<String> parts) {
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
