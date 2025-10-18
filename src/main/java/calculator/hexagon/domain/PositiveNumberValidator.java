package calculator.hexagon.domain;

public interface PositiveNumberValidator {
    void check(int number) throws IllegalArgumentException;
}
