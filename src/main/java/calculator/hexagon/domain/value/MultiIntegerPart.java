package calculator.hexagon.domain.value;

public record MultiIntegerPart(String value) {

    public static final MultiIntegerPart EMPTY = new MultiIntegerPart("");

    public static MultiIntegerPart of(String value) {
        return new MultiIntegerPart(value);
    }
}
