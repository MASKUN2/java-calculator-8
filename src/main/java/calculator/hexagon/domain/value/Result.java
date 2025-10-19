package calculator.hexagon.domain.value;

public record Result(int value) {
    public static final Result ZERO = new Result(0);

    public static Result of(int value) {
        return new Result(value);
    }
}
