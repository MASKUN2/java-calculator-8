package calculator.hexagon;

import java.util.List;

public class StringSplitter implements Splitter {

    @Override
    public List<String> split(String input, String delimiter) {
        return List.of(input.split(delimiter));
    }
}
