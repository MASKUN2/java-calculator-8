package calculator.hexagon.application;

import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.Result;

public interface StringSumProcessor {

    Result parseAndSum(Input input) throws IllegalArgumentException;

}
