package calculator.hexagon.domain;

import java.util.List;

public class IntegerSumLogic implements SumLogic {
    private static final IntegerSumLogic INSTANCE = new IntegerSumLogic();

    public static IntegerSumLogic getInstance() {
        return INSTANCE;
    }

    private IntegerSumLogic() {
    }

    @Override
    public int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
