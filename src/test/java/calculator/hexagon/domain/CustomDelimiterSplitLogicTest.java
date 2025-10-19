package calculator.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomDelimiterSplitLogicTest {
    private CustomDelimiterSplitLogic splitLogic;

    @BeforeEach
    void setUp() {
        splitLogic = new CustomDelimiterSplitLogic();
    }

    @Test
    void 구분자선언이_없으면_숫자부문만_분리한다() {
        String input = "1,2:3";
        List<String> strings = splitLogic.split(input);
        assertThat(strings).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자선언이_있으면_모두_분리한다() {
        String input = "//;\\n1,2:3";
        List<String> strings = splitLogic.split(input);
        assertThat(strings).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자선언만_있으면_구분자만_분리한다() {
        String input = "//;\\n";
        List<String> strings = splitLogic.split(input);
        assertThat(strings).isEqualTo(List.of(""));
    }

    @Test
    void 빈문자열_구분시_비어있음() {
        String input = "";
        List<String> strings = splitLogic.split(input);
        assertThat(strings).isEqualTo(List.of(""));
    }

    @Test
    void 숫자분할된다() {
        List<String> strings = splitLogic.split("1,2:3");
        assertThat(strings).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자_추가된다() {
        List<String> strings = splitLogic.split("//-\\n1,2:3-4");
        assertThat(strings).isEqualTo(List.of("1", "2", "3", "4"));
    }

    @Test
    void 잘못된_구분자_선언에_예외를_발생() {
        List<String> badTokens = List.of("\n", ".", "4", "");

        for (String bad : badTokens) {
            assertThatThrownBy(() -> splitLogic.split("//" + bad + "\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    void 괜찮은_구분자_선언은_넘어간다() {
        List<String> goods = List.of(";", "@");

        for (String good : goods) {
            splitLogic.split("//" + good + "\\n");
        }
    }
}
