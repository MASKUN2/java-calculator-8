package calculator.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.StringSplitter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputSplitterTest {
    private InputSplitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new InputSplitter(
                new CustomDelimiterDeclarer(),
                new DelimiterValidator(),
                new StringSplitter()
        );
    }

    @Test
    void 숫자분할된다() {
        List<String> strings = splitter.split("1,2:3");
        assertThat(strings).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자_추가된다() {
        List<String> strings = splitter.split("//-\\n1,2:3-4");
        assertThat(strings).isEqualTo(List.of("1", "2", "3", "4"));
    }
}