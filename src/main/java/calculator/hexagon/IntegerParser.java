package calculator.hexagon;

public class IntegerParser implements NumberParser {

    @Override
    public int parse(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
