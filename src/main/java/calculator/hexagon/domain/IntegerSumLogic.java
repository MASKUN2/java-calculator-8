package calculator.hexagon.domain;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.Result;
import java.util.List;

public class IntegerSumLogic implements SumLogic {
    private static final IntegerSumLogic INSTANCE = new IntegerSumLogic();

    public static IntegerSumLogic getInstance() {
        return INSTANCE;
    }

    private IntegerSumLogic() {
    }

    @Override
    public Result sum(List<ParsedInteger> numbers) {
        int result = 0;
        for (ParsedInteger number : numbers) {
            result += number.value();
        }
        return Result.of(result);
    }
}
