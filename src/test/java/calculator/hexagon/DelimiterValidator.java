package calculator.hexagon;

import java.util.List;

public class DelimiterValidator {
    private final List<String> badTokens = List.of("\n", ".");

    public void check(String target) {
        checkEmpty(target);
        checkContainsBadToken(target);
        checkNumeric(target);

    }

    private void checkEmpty(String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (빈문자열)");
        }
    }

    private void checkContainsBadToken(String target) {
        for (String badToken : badTokens) {
            if (target.contains(badToken)) {
                throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 :" + badToken);
            }
        }
    }

    private void checkNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            return;
        }
        throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (숫자): " + target);
    }
}
