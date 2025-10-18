package calculator.adaptor;

import calculator.hexagon.out.InputInstructor;

public class SystemInputInstructor implements InputInstructor {
    @Override
    public void display() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
