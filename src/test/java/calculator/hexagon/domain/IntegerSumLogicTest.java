package calculator.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.Result;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IntegerSumLogicTest {
    private final IntegerSumLogic cal = IntegerSumLogic.getInstance();

    @Test
    void 덧셈을한다_1더하기1은2() {
        List<Integer> integers = List.of(1, 1);

        int result = sum(integers);

        assertThat(result).isEqualTo(2);
    }

    private int sum(List<Integer> integers) {
        List<ParsedInteger> list = integers.stream()
                .map(ParsedInteger::new)
                .toList();

        Result result = cal.sum(list);

        return result.value();
    }

    @Test
    void 덧셈을한다_아무것도_더하지_않으면_0() {
        List<Integer> integers = List.of();

        int result = sum(integers);

        assertThat(result).isEqualTo(0);
    }
}
