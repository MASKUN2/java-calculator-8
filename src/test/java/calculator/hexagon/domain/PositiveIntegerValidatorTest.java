package calculator.hexagon.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveIntegerValidatorTest {

    @Test
    void 영_또는_양수는_넘어간다() {
        PositiveIntegerValidator validator = new PositiveIntegerValidator();
        validator.check(1);
        validator.check(0);
    }

    @Test
    void 음수_오류발생() {
        PositiveIntegerValidator validator = new PositiveIntegerValidator();

        assertThatThrownBy(() -> validator.check(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
