package calculator.adaptor;

import calculator.hexagon.out.ResultPrinter;

public class IntergerResultPrinter implements ResultPrinter {
    @Override
    public void print(int result) {
        System.out.printf("결과 : %s", result);
    }
}
