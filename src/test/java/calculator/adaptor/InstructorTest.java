package calculator.adaptor;

import calculator.helper.SystemOutputTestHelper;
import calculator.hexagon.out.Instructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructorTest {

    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();
    }

    @AfterEach
    void tearDown() {
        SystemOutputTestHelper.finish();
    }

    @Test
    void 설명을_출력한다() {
        Instructor instructor = new RunInstructor();
        instructor.print();
        String output = SystemOutputTestHelper.output();
        assertThat(output).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }
}
