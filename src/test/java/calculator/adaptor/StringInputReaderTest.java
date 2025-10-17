package calculator.adaptor;

import calculator.helper.SystemInputTestHelper;
import calculator.hexagon.required.SystemInputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringInputReaderTest {

    private SystemInputReader reader;

    @BeforeEach
    void setUp() {
        reader = new StringInputReader();
    }

    @Test
    void 입력을_그대로_가져온다() {
        String input = "입력문샘플";
        SystemInputTestHelper.setInput(input);

        String read = reader.read();

        assertThat(read).isEqualTo(input);
    }

    @Test
    void 이스케이프_입력을_그대로_가져온다() {
        String input = "//;\\n1";
        SystemInputTestHelper.setInput(input);

        String read = reader.read();
        String read2 = reader.read();

        assertThat(read).isEqualTo(input);
    }

    @Test
    void 빈문자_그대로_가져온다() {
        String input = "";
        SystemInputTestHelper.setInput(input);

        String read = reader.read();

        assertThat(read).isEqualTo(input);
    }
}
