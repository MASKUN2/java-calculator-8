package calculator.helper;

import java.io.ByteArrayInputStream;

public class SystemInputTestHelper {
    private SystemInputTestHelper() {
    }

    public static void setInput(String input) {
        if (input == null) {
            throw new NullPointerException("null은 허용되지 않습니다.");
        }

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}
