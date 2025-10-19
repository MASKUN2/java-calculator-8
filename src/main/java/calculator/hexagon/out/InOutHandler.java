package calculator.hexagon.out;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.Result;

public interface InOutHandler {

    Input readIn();

    void writeOut(Result result);
}
