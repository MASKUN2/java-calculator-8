package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.helper.SystemInputTestHelper.restore;
import static calculator.helper.SystemInputTestHelper.setInput;
import static calculator.helper.SystemOutputTestHelper.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationAcceptanceTest {
    @BeforeEach
    void setUp() {
        record();
    }

    @AfterEach
    void tearDown() {
        restore();
        finish();
    }

    private static void run() {
        Application.main(new String[]{});
    }

    @Test
    void 기본예제() {
        setInput("//;\\n1");
        run();

        assertThat(output()).contains("결과 : 1");
    }

    @Test
    void 기본_오류_예제() {
        setInput("-1,2,3");

        assertThatThrownBy(ApplicationAcceptanceTest::run)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈값_입력() {
        setInput("");
        run();
        assertThat(output()).contains("결과 : 0");
    }

    @Test
    void 커스텀_구분자_선언_없는_입력() {
        setInput("1,2,3");
        run();
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void 커스텀_구분자_선언_없는_다중_구분자_입력() {
        setInput("1,2:3");
        run();
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void 커스텀_구분자_선언_있는_입력() {
        setInput("//;\\n1;2;3");
        run();
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    void 커스텀_구분자_및_기본_구분자_사용_입력() {
        setInput("//;\\n1;2:3,4");
        run();
        assertThat(output()).contains("결과 : 10");
    }

    @Test
    void 커스텀_구분자만_입력() {
        setInput("//;\\n");
        run();
        assertThat(output()).contains("결과 : 0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\\n", "//.\\n", "//\n\\n"})
    void 사용할수없는_구분자(String input) {
        setInput(input);

        assertThatThrownBy(ApplicationAcceptanceTest::run)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A,2,3", "1,?,3", "1.5,2,3"})
    void 정수가_아닌_입력(String input) {
        setInput(input);

        assertThatThrownBy(ApplicationAcceptanceTest::run)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
