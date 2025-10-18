package calculator.hexagon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterDeclarationTest {
    private CustomDelimiterDeclarer declarer;

    @BeforeEach
    void setUp() {
        declarer = new CustomDelimiterDeclarer();
    }

    @Test
    void 구분자_선언이_없는_경우_찾지못한다() {
        String input = "1,2:3";

        Optional<String> found = declarer.find(input);

        assertThat(found).isEmpty();
    }

    @Test
    void 구분자_선언이_있으면_찾는다() {
        String input = "//;\\n1,2:3";

        Optional<String> found = declarer.find(input);

        assertThat(found).isNotEmpty();
        assertThat(found.get()).isEqualTo(";");
    }
}
