package calculator.adaptor;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.Result;
import calculator.hexagon.out.InOutHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class UserInOutHandler implements InOutHandler {
    public static final UserInOutHandler INSTANCE = new UserInOutHandler();

    public static UserInOutHandler getInstance() {
        return INSTANCE;
    }

    private UserInOutHandler() {
    }

    @Override
    public Input readIn() {
        displayInstruction();
        return read();
    }

    @Override
    public void writeOut(Result result) {
        System.out.printf("결과 : %s", result.value());
    }

    private void displayInstruction() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private Input read() {
        try {
            String value = Console.readLine();
            return Input.of(value);
        } catch (NoSuchElementException e) {
            return Input.EMPTY;
        } finally {
            Console.close();
        }
    }
}
