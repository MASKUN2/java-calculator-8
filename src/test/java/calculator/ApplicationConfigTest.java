package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.hexagon.in.StringSumCalculator;
import org.junit.jupiter.api.Test;

public class ApplicationConfigTest {

    @Test
    void 문자열_덧셈_계산기가_초기화된다() {
        StringSumCalculator calculator = ApplicationConfig.stringSumCalculator();

        assertThat(calculator).isNotNull();
    }
}
