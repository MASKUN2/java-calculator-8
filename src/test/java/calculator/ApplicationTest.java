package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            String read = Console.readLine();
            assertThat(read).contains("//;\\n1"); // 통과한다.
        });
    }
    
    @Test
    void 빈문자열_테스트() {
        assertSimpleTest(() -> {
            run("");
            String read = Console.readLine(); //java.util.NoSuchElementException: No line found
            assertThat(read).contains("");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
