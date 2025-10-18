package calculator.hexagon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomDelimiterValidatorTest {
    private DelimiterValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DelimiterValidator();
    }

    @Test
    void 잘못된_구분자_선언에_예외를_발생() {
        List<String> badTokens = List.of("\n", ".", "4", "");

        for (String bad : badTokens) {
            assertThatThrownBy(() -> validator.check(bad))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    void 괜찮은_구분자_선언은_넘어간다() {
        List<String> badTokens = List.of(";", "@");

        for (String bad : badTokens) {
            validator.check(bad);
        }
    }
}
