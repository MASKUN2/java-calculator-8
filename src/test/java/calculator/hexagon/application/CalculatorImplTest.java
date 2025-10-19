package calculator.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.adaptor.CalculatorController;
import calculator.helper.SystemInputTestHelper;
import calculator.helper.SystemOutputTestHelper;
import calculator.hexagon.domain.CustomDelimiterSplitLogic;
import calculator.hexagon.domain.IntegerParser;
import calculator.hexagon.domain.IntegerSumLogic;
import calculator.hexagon.domain.PositiveIntegerValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorImplTest {
    private CalculatorImpl calculator;

    @BeforeEach
    void setUp() {
        SystemOutputTestHelper.record();

        StringIntegerParserImpl integerParser = new StringIntegerParserImpl(
                new IntegerParser(),
                new PositiveIntegerValidator()
        );

        StringSumProcesserImpl newCalculator = new StringSumProcesserImpl(
                new CustomDelimiterSplitLogic(),
                integerParser,
                new IntegerSumLogic()
        );

        calculator = new CalculatorImpl(
                new CalculatorController(),
                newCalculator
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
        calculator.writeResult();
        String output = SystemOutputTestHelper.output();

        assertThat(output).isEqualTo("결과 : 0");
    }


}
