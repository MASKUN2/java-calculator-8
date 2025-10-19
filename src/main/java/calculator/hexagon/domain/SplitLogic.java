package calculator.hexagon.domain;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public interface SplitLogic {

    List<SingleIntegerPart> split(Input input) throws IllegalArgumentException;

}
