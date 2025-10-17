package calculator.adaptor;

import calculator.helper.SystemOutputTestHelper;
import calculator.hexagon.required.ResultPrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultPrinterTest {
    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();
    }

    @AfterEach
    void tearDown() {
        SystemOutputTestHelper.finish();
    }

    @Test
    void 결과를_포맷에_맞춰_출력한다() {
        ResultPrinter printer = new IntergerResultPrinter();
        printer.print(123);
        String output = SystemOutputTestHelper.output();
        assertThat(output).isEqualTo("결과 : 123");
    }
}
