package calculator.hexagon.domain;

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

    @Test
    void 커스텀_구분자를_추가하여_빈문자열_분리한다() {
        String input = "1,2:3;0";
        String customDelimiter = ";";

        Splitter splitter = new StringSplitter();
        List<String> result = splitter.splitWithCustomDelimiter(input, customDelimiter);

        assertThat(result.size()).isEqualTo(4);
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo("3");
        assertThat(result.get(3)).isEqualTo("0");
    }


    @Test
    void 커스텀_구분자가_기본구분자와_겹치므로_무시한다() {
        String input = "1,2:3";
        String customDelimiter = ":";

        Splitter splitter = new StringSplitter();
        List<String> result = splitter.splitWithCustomDelimiter(input, customDelimiter);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.getFirst()).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo("3");

    }
}