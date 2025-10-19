package calculator.hexagon.domain.value;

public record ParsedInteger(int value) {
    public static final ParsedInteger ZERO = new ParsedInteger(0);

    public static ParsedInteger of(int value) {
        return new ParsedInteger(value);
    }

    public ParsedInteger {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다");
        }
    }
}
