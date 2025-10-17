package calculator.hexagon;

import java.util.List;

public class IntergerCalculator implements Calculator {

    @Override
    public int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
