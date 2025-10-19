package calculator.hexagon.domain.value;

public record Input(String value) {

    public static final Input EMPTY = new Input("");

    public static Input of(String value) {
        return new Input(value);
    }
}
