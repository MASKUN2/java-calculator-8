package calculator.helper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemOutputTestHelperTest {

    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();
    }

    @AfterEach
    void tearDown() {
        SystemOutputTestHelper.finish();
    }

    @Test
    void 출력을_확인한다() {
        System.out.println("결과 : 1");
        String recorded = SystemOutputTestHelper.output();
        assertThat(recorded).isEqualTo("결과 : 1");
    }

}
