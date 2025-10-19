package calculator.hexagon.domain.value;

public record Regex(String value) {

    public static final Regex EMPTY = new Regex("");

    public static Regex of(String value) {
        return new Regex(value);
    }
}
