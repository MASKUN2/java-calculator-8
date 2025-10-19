package calculator.hexagon.domain;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public class IntegerParser implements NumberParser {
    private static final IntegerParser INSTANCE = new IntegerParser();

    public static IntegerParser getInstance() {
        return INSTANCE;
    }

    private IntegerParser() {
    }

    @Override
    public List<ParsedInteger> parse(List<SingleIntegerPart> parts) throws IllegalArgumentException {
        return parts.stream()
                .map(this::parse)
                .toList();
    }

    public ParsedInteger parse(SingleIntegerPart input) {
        final String value = input.value();
        if (value.isEmpty()) {
            return ParsedInteger.ZERO;
        }
        int integer = parseToInt(value);
        return ParsedInteger.of(integer);
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사용할 수 없는 숫자 정수 문자열입니다." + input, e);
        }
    }
}
