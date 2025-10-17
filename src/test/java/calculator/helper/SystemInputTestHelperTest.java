package calculator.helper;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class SystemInputTestHelperTest {

    @Test
    void 테스트_헬퍼_시스템_입력_설정에_성공한다() throws IOException {
        SystemInputTestHelper.setInput("some input");
        String actual = Console.readLine();

        assertThat(actual).isEqualTo("some input");
    }
}
