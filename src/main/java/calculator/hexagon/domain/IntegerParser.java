package calculator.hexagon.domain;

import java.util.List;

public class IntegerParser implements NumberParser {

    @Override
    public List<Integer> parse(List<String> parts) throws IllegalArgumentException {
        return parts.stream()
                .map(this::parse)
                .toList();
    }

    public int parse(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return parseToInt(input);
    }

    private int parseToInt(String input) {
        try {
            int result = Integer.parseInt(input);
            check(result);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사용할 수 없는 숫자 정수 문자열입니다." + input, e);
        }
    }

    private void check(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다");
        }
    }
}
