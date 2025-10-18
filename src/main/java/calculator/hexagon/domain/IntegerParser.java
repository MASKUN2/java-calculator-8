package calculator.hexagon.domain;

public class IntegerParser implements NumberParser {

    @Override
    public int parse(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return parseToInt(input);
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다", e);
        }
    }
}
