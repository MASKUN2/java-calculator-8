package calculator.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class IntegerParserTest {
    private final IntegerParser parser = IntegerParser.getInstance();

    @Test
    void 숫자_변환에_성공() {
        List<String> input = List.of("1", "2");
        List<Integer> result = parser.parse(input);
        assertThat(result).isEqualTo(List.of(1, 2));
    }

    @Test
    void 빈문자열을_0으로_변환한다() {
        List<String> input = List.of("1", "");
        List<Integer> result = parser.parse(input);
        assertThat(result).isEqualTo(List.of(1, 0));
    }

    @Test
    void 소수에_대해_오류_발생한다() {
        List<String> input = List.of("1.5", "2");
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수에_대해_오류_발생한다() {
        List<String> input = List.of("1", "-2");
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자에_대해_오류_발생한다() {
        List<String> input = List.of("1", "a");
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
