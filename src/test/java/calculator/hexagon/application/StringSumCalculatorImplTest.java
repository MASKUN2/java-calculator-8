package calculator.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.adaptor.CalculatorController;
import calculator.helper.SystemInputTestHelper;
import calculator.helper.SystemOutputTestHelper;
import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.IntegerCalculator;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.PositiveIntegerValidator;
import calculator.hexagon.domain.StringSplitter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSumCalculatorImplTest {
    private StringSumCalculatorImpl calculator;

    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();

        calculator = new StringSumCalculatorImpl(
                new CalculatorController(),
                new CustomDelimiterDeclarer(),
                new DelimiterValidator(),
                new StringSplitter(),
                new IntegerParser(),
                new PositiveIntegerValidator(),
                new IntegerCalculator()
        );
    }

    @AfterEach
    void tearDown() {
        SystemOutputTestHelper.finish();
    }

    @Test
    void welcomeMessage가_보인다() {
        SystemInputTestHelper.setInput("");

        calculator.readInput();

        String output = SystemOutputTestHelper.output();

        assertThat(output).contains("덧셈할 문자열을 입력해 주세요.");
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
