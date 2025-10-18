package calculator;

import calculator.hexagon.in.StringSumCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationConfigTest {

    @Test
    void 문자열_덧셈_계산기가_초기화된다() {
        ApplicationConfig config = new ApplicationConfig();

        StringSumCalculator calculator = config.stringSumCalculator();

        assertThat(calculator).isNotNull();
    }
}
