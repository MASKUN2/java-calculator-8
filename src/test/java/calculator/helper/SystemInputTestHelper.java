package calculator.helper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemInputTestHelper {
    private static final InputStream STANDARD_IN = System.in;

    private SystemInputTestHelper() {
    }

    public static void setInput(String input) {
        if (input == null) {
            throw new NullPointerException("null은 허용되지 않습니다.");
        }

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    public static void restore() {
        System.setIn(STANDARD_IN);
    }

}
