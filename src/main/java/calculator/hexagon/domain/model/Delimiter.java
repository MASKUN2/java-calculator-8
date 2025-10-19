package calculator.hexagon.domain.model;

import java.util.Set;

public class Delimiter {
    public final static Set<String> FORBIDDEN = Set.of("\n", ".");
    public final static Set<String> DEFAULT = Set.of(",", ":");
    public final static String DECLARE_PREFIX = "//";
    public final static String DECLARE_SUFFIX = "\\n";

    private Delimiter() {
    }
}
