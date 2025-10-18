package calculator.adaptor;

import calculator.hexagon.out.SystemInputReader;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class StringInputReader implements SystemInputReader {

    @Override
    public String read() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        } finally {
            Console.close();
        }
    }
}
