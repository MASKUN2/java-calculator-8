package calculator.hexagon.domain;

import calculator.hexagon.domain.model.SeparatedInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterDeclarerTest {
    private CustomDelimiterDeclarer declarer;

    @BeforeEach
    void setUp() {
        declarer = new CustomDelimiterDeclarer();
    }

    @Test
    void 구분자_선언이_없는_경우_찾지못한다() {
        String input = "1,2:3";

        Optional<String> found = declarer.extractDelimiter(input);

        assertThat(found).isEmpty();
    }

    @Test
    void 구분자_선언이_있으면_찾는다() {
        String input = "//;\\n1,2:3";

        Optional<String> found = declarer.extractDelimiter(input);

        assertThat(found).isNotEmpty();
        assertThat(found.get()).isEqualTo(";");
    }

    @Test
    void 구분자선언이_없으면_숫자부문만_분리한다() {
        String input = "1,2:3";

        SeparatedInput result = declarer.separate(input);

        assertThat(result.stringNumbers()).isEqualTo("1,2:3");
        assertThat(result.customDelimiterDeclaration()).isEqualTo("");
    }

    @Test
    void 구분자선언이_있으면_모두_분리한다() {
        String input = "//;\\n1,2:3";

        SeparatedInput result = declarer.separate(input);

        assertThat(result.stringNumbers()).isEqualTo("1,2:3");
        assertThat(result.customDelimiterDeclaration()).isEqualTo("//;\\n");
    }

    @Test
    void 구분자선언만_있으면_구분자만_분리한다() {
        String input = "//;\\n";

        SeparatedInput result = declarer.separate(input);

        assertThat(result.stringNumbers()).isEqualTo("");
        assertThat(result.customDelimiterDeclaration()).isEqualTo("//;\\n");
    }

    @Test
    void 빈문자열_구분시_비어있음() {
        String input = "";

        SeparatedInput result = declarer.separate(input);

        assertThat(result.stringNumbers()).isEqualTo("");
        assertThat(result.customDelimiterDeclaration()).isEqualTo("");
    }
}
