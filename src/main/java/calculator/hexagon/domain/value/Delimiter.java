package calculator.hexagon.domain.value;

import java.util.Set;

public record Delimiter(String value) {
    private final static Set<String> FORBIDDEN = Set.of("\n", ".");
    public final static Set<Delimiter> DEFAULT = Set.of(of(","), of(":"));
    public final static String DECLARE_PREFIX = "//";
    public final static String DECLARE_SUFFIX = "\\n";

    public static Delimiter of(String value) {
        return new Delimiter(value);
    }

    public Delimiter {
        check(value);
    }

    private void check(String target) {
        noEmpty(target);
        notInForbidden(target);
        noNumeric(target);

    }

    private void noEmpty(String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (빈문자열)");
        }
    }

    private void notInForbidden(String target) {
        for (String bad : FORBIDDEN) {
            if (target.contains(bad)) {
                throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 :" + bad);
            }
        }
    }

    private void noNumeric(String target) {
        if (isNumeric(target)) {
            throw new IllegalArgumentException("사용할 수 없는 구분자 입니다 (숫자): " + target);
        }
    }

    private static boolean isNumeric(String target) {
        try {
            Double.parseDouble(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
