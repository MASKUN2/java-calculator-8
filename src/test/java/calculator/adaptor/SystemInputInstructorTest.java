package calculator.adaptor;

import static calculator.helper.SystemOutputTestHelper.finish;
import static calculator.helper.SystemOutputTestHelper.output;
import static calculator.helper.SystemOutputTestHelper.record;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.hexagon.out.InputInstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SystemInputInstructorTest {

    @BeforeEach
    void setUp() {
        record();
    }

    @AfterEach
    void tearDown() {
        finish();
    }

    @Test
    void 설명을_출력한다() {
        InputInstructor instructor = new SystemInputInstructor();
        instructor.display();
        assertThat(output()).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }
}
