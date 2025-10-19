package calculator.adaptor;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.Result;
import calculator.hexagon.out.InOutHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorController implements InOutHandler {
    public static final CalculatorController INSTANCE = new CalculatorController();

    public static CalculatorController getInstance() {
        return INSTANCE;
    }

    private CalculatorController() {
    }

    @Override
    public Input readIn() {
        displayInstruction();
        String read = read();
        finishReading();
        return Input.of(read);
    }

    @Override
    public void writeOut(Result result) {
        System.out.printf("결과 : %s", result.value());
    }

    private void displayInstruction() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private String read() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private static void finishReading() {
        Console.close();
    }
}
