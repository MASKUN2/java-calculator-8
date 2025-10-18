package calculator.hexagon.domain;

public class PositiveIntegerValidator implements PositiveNumberValidator {
    @Override
    public void check(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다");
        }
    }
}
