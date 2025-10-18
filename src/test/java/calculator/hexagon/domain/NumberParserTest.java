package calculator.hexagon.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberParserTest {

    @Test
    void 숫자_변환에_성공() {
        NumberParser parser = new IntegerParser();
        int result = parser.parse("123");
        assertThat(result).isEqualTo(123);
    }

    @Test
    void 빈문자열을_0으로_변환한다() {
        NumberParser parser = new IntegerParser();
        int result = parser.parse("");
        assertThat(result).isEqualTo(0);
    }
}
