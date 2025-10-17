package calculator.hexagon;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    void 문자열을_구분자로_나눈다() {
        Splitter splitter = new StringSplitter();
        String input = "1,2";
        String delimiter = ",";

        List<String> result = splitter.split(input, delimiter);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
    }

    @Test
    void 빈문자열을_나누면_1개를_반환한다() {
        Splitter splitter = new StringSplitter();
        String input = "";
        String delimiter = ",";

        List<String> result = splitter.split(input, delimiter);
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("");
    }
}
