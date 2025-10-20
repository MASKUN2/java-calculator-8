package calculator.hexagon.domain;

import static calculator.hexagon.domain.value.Delimiter.DECLARE_PREFIX;
import static calculator.hexagon.domain.value.Delimiter.DECLARE_SUFFIX;
import static calculator.hexagon.domain.value.Delimiter.DEFAULT;

import calculator.hexagon.domain.value.Delimiter;
import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.MultiIntegerPart;
import calculator.hexagon.domain.value.Regex;
import calculator.hexagon.domain.value.SingleIntegerPart;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter implements DelimiterSplitter {
    private static final CustomDelimiterSplitter INSTANCE = new CustomDelimiterSplitter();

    public static CustomDelimiterSplitter getInstance() {
        return INSTANCE;
    }

    private CustomDelimiterSplitter() {
    }

    @Override
    public List<SingleIntegerPart> split(Input input) throws IllegalArgumentException {
        if (hasDeclaration(input)) {
            return splitByCustomDelimiter(input);
        }

        return defaultSplit(input);
    }

    private boolean hasDeclaration(Input input) {
        final String value = input.value();
        return value.startsWith(DECLARE_PREFIX) && value.contains(DECLARE_SUFFIX);
    }

    private List<SingleIntegerPart> splitByCustomDelimiter(Input input) {
        Delimiter delimiter = extractCustomDelimiter(input);
        MultiIntegerPart multiIntegerPart = trimDeclaration(input);
        return splitWithCustomDelimiter(multiIntegerPart, delimiter);
    }

    private Delimiter extractCustomDelimiter(Input declaration) {
        final String value = declaration.value();

        int startIndex = DECLARE_PREFIX.length();
        int exclusiveEndIndex = value.lastIndexOf(DECLARE_SUFFIX);
        String sub = value.substring(startIndex, exclusiveEndIndex);

        return Delimiter.of(sub);
    }


    private MultiIntegerPart trimDeclaration(Input input) {
        final String value = input.value();

        int suffixIndex = value.lastIndexOf(DECLARE_SUFFIX);
        int exclusiveEndIndex = suffixIndex + DECLARE_SUFFIX.length();
        String sub = value.substring(exclusiveEndIndex);

        return MultiIntegerPart.of(sub);
    }

    private List<SingleIntegerPart> defaultSplit(Input input) {
        final String value = input.value();

        Regex regex = getRegex(DEFAULT);
        String[] parts = value.split(regex.value());

        return Arrays.stream(parts)
                .map(SingleIntegerPart::new)
                .toList();
    }

    private List<SingleIntegerPart> splitWithCustomDelimiter(MultiIntegerPart input, Delimiter customDelimiter) {
        final String value = input.value();

        Regex regex = extendRegex(customDelimiter);
        String[] parts = value.split(regex.value());

        return Arrays.stream(parts)
                .map(SingleIntegerPart::new)
                .toList();
    }

    private Regex extendRegex(Delimiter customDelimiter) {
        Set<Delimiter> extended = new HashSet<>(DEFAULT);
        extended.add(customDelimiter);
        return getRegex(extended);
    }

    private Regex getRegex(Set<Delimiter> delimiters) {
        List<String> escaped = delimiters.stream()
                .map(Delimiter::value)
                .map(Pattern::quote)
                .toList();
        String joined = String.join("|", escaped);
        return Regex.of(joined);
    }


}
