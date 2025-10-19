package calculator.adaptor;

import calculator.hexagon.out.InOutHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorController implements InOutHandler {

    @Override
    public String readIn() {
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
    public void writeOut(int result) {
        System.out.printf("결과 : %s", result);
    }

    private void displayInstruction() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
