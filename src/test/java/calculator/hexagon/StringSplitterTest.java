package calculator.hexagon;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    void 기본구분자로_문자열_분리한다() {
        String input = "1,2:3";

        Splitter splitter = new StringSplitter();
        List<String> result = splitter.defaultSplit(input);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo("3");
    }

    @Test
    void 기본구분자로_빈문자열_분리한다() {
        String input = "";

        Splitter splitter = new StringSplitter();
        List<String> result = splitter.defaultSplit(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.getFirst()).isEqualTo("");
    }
}
