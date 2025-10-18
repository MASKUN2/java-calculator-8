package calculator.adaptor;

import calculator.hexagon.required.Instructor;

public class RunInstructor implements Instructor {
    @Override
    public void print() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
