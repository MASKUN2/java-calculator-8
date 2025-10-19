package calculator.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class IntegerSumLogicTest {
    private final IntegerSumLogic cal = IntegerSumLogic.getInstance();

    @Test
    void 덧셈을한다_1더하기1은2() {
        List<Integer> integers = List.of(1, 1);

        int result = cal.sum(integers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 덧셈을한다_아무것도_더하지_않으면_0() {
        List<Integer> integers = List.of();

        int result = cal.sum(integers);

        assertThat(result).isEqualTo(0);
    }
}
