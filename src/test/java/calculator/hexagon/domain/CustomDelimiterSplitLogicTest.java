package calculator.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class CustomDelimiterSplitLogicTest {
    private final CustomDelimiterSplitLogic splitLogic = CustomDelimiterSplitLogic.getInstance();

    @Test
    void 구분자선언이_없으면_숫자부문만_분리한다() {
        Input input = Input.of("1,2:3");

        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<String> values = parts.stream()
                .map(SingleIntegerPart::value)
                .toList();

        assertThat(values).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자선언이_있으면_모두_분리한다() {
        Input input = Input.of("//;\\n1,2:3");

        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<String> values = parts.stream()
                .map(SingleIntegerPart::value)
                .toList();

        assertThat(values).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 구분자선언만_있으면_구분자만_분리한다() {
        Input input = Input.of("//;\\n");

        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<String> values = parts.stream()
                .map(SingleIntegerPart::value)
                .toList();

        assertThat(values).isEqualTo(List.of(""));
    }

    @Test
    void 빈문자열_구분시_비어있음() {
        Input input = Input.of("");
        List<SingleIntegerPart> strings = splitLogic.split(input);

        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<String> values = parts.stream()
                .map(SingleIntegerPart::value)
                .toList();

        assertThat(values).isEqualTo(List.of(""));
    }


    @Test
    void 구분자_추가된다() {
        Input input = Input.of("//-\\n1,2:3-4");

        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<String> values = parts.stream()
                .map(SingleIntegerPart::value)
                .toList();

        assertThat(values).isEqualTo(List.of("1", "2", "3", "4"));
    }

    @Test
    void 잘못된_구분자_선언에_예외를_발생() {
        List<String> badTokens = List.of("\n", ".", "4", "");

        for (String bad : badTokens) {
            ThrowingCallable throwingCallable = () -> {
                Input input = Input.of("//" + bad + "\\n");
                splitLogic.split(input);
            };
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    void 괜찮은_구분자_선언은_넘어간다() {
        List<String> goods = List.of(";", "@");

        for (String good : goods) {
            ThrowingCallable throwingCallable = () -> {
                Input input = Input.of("//" + good + "\\n");
                splitLogic.split(input);
            };
        }
    }
}
