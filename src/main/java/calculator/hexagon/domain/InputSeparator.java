package calculator.hexagon.domain;

import calculator.hexagon.domain.model.SeparatedInput;

public interface InputSeparator {

    SeparatedInput separate(String input);
}
