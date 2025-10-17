package calculator.helper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutputTestHelper {

    private static final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    private SystemOutputTestHelper() {
    }

    public static void record() {
        captor.reset();
        System.setOut(new PrintStream(captor));

    }

    public static void finish() {
        System.setOut(standardOut);
    }

    public static String output() {
        return captor.toString().trim();
    }

}
