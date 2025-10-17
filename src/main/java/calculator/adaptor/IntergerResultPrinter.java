package calculator.adaptor;

import calculator.hexagon.required.ResultPrinter;

public class IntergerResultPrinter implements ResultPrinter {
    @Override
    public void print(int result) {
        System.out.printf("결과 : %s", result);
    }
}
