package calculator.hexagon.domain;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.List;

public interface DelimiterSplitter {

    List<SingleIntegerPart> split(Input input) throws IllegalArgumentException;

}
