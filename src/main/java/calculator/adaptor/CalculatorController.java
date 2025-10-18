package calculator.adaptor;

import calculator.hexagon.out.CalculatorUi;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorController implements CalculatorUi {

    @Override
    public String readInput() {
        try {
            displayInstruction();
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        } finally {
            Console.close();
        }
    }

    @Override
    public void printResult(int result) {
        System.out.printf("결과 : %s", result);
    }

    private void displayInstruction() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
