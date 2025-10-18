package calculator.hexagon.application;

import calculator.adaptor.IntergerResultPrinter;
import calculator.adaptor.RunInstructor;
import calculator.adaptor.StringInputReader;
import calculator.helper.SystemInputTestHelper;
import calculator.helper.SystemOutputTestHelper;
import calculator.hexagon.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorImplTest {
    private StringSumCalculatorImpl calculator;

    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();

        calculator = new StringSumCalculatorImpl(
                new RunInstructor(),
                new StringInputReader(),
                new CustomDelimiterDeclarer(),
                new DelimiterValidator(),
                new StringSplitter(),
                new IntegerParser(),
                new IntegerCalculator(),
                new IntergerResultPrinter()
        );
    }

    @AfterEach
    void tearDown() {
        SystemOutputTestHelper.finish();
    }

    @Test
    void welcomeMessage가_보인다() {
        calculator.printWelcome();

        String output = SystemOutputTestHelper.output();

        assertThat(output).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }

    @Test
    void 입력을_받는다() {
        SystemInputTestHelper.setInput("foo");
        calculator.readInput();
        //실행만 검증
    }

    @Test
    void 계산을_한다() {
        calculator.sum();
        //실행만 검증
    }

    @Test
    void 결과를_출력한다() {
        calculator.printResult();
        String output = SystemOutputTestHelper.output();

        assertThat(output).isEqualTo("결과 : 0");
    }


}
