package calculator.adaptor;

import static calculator.helper.SystemInputTestHelper.restore;
import static calculator.helper.SystemInputTestHelper.setInput;
import static calculator.helper.SystemOutputTestHelper.finish;
import static calculator.helper.SystemOutputTestHelper.output;
import static calculator.helper.SystemOutputTestHelper.record;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.hexagon.domain.value.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    private final CalculatorController controller = CalculatorController.getInstance();

    @BeforeEach
    void setUp() {
        record();
    }

    @AfterEach
    void tearDown() {
        finish();
        restore();
    }

    @Test
    void 입력을_그대로_가져온다() {
        String input = "입력문샘플";
        setInput(input);

        String result = controller.readIn().value();

        assertThat(result).isEqualTo(input);
    }

    @Test
    void 이스케이프_입력을_그대로_가져온다() {
        String input = "//;\\n1";
        setInput(input);

        String result = controller.readIn().value();

        assertThat(result).isEqualTo(input);
    }

    @Test
    void 빈문자_그대로_가져온다() {
        String input = "";
        setInput(input);

        String result = controller.readIn().value();

        assertThat(result).isEqualTo(input);
    }

    @Test
    void 설명을_출력한다() {
        setInput("");
        controller.readIn();
        assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
    }

    @Test
    void 결과를_포맷에_맞춰_출력한다() {
        Result result = Result.of(123);
        controller.writeOut(result);
        String output = output();
        assertThat(output).isEqualTo("결과 : 123");
    }
}
