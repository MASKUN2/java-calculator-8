package calculator.hexagon.application;

import calculator.hexagon.domain.CustomDelimiterDeclarer;
import calculator.hexagon.domain.DelimiterValidator;
import calculator.hexagon.domain.Splitter;
import calculator.hexagon.domain.model.SeparatedInput;
import java.util.List;
import java.util.Optional;

public class InputSplitter implements StringNumberSplitter {
    private final CustomDelimiterDeclarer customDelimiterDeclarer;
    private final DelimiterValidator delimiterValidator;
    private final Splitter splitter;

    public InputSplitter(
            CustomDelimiterDeclarer customDelimiterDeclarer,
            DelimiterValidator delimiterValidator,
            Splitter splitter
    ) {
        this.customDelimiterDeclarer = customDelimiterDeclarer;
        this.delimiterValidator = delimiterValidator;
        this.splitter = splitter;

    }

    @Override
    public List<String> split(String input) {
        SeparatedInput separated = customDelimiterDeclarer.separate(input);
        return splitStringNumbers(separated);
    }

    private List<String> splitStringNumbers(SeparatedInput separated) {
        Optional<String> found = findCustomDelimiter(separated);

        if (found.isPresent()) {
            String customDelimiter = found.get();
            delimiterValidator.check(customDelimiter);
            return splitter.splitWithCustomDelimiter(separated.stringNumbers(), customDelimiter);
        }

        return splitter.defaultSplit(separated.stringNumbers());
    }

    private Optional<String> findCustomDelimiter(SeparatedInput separated) {
        return customDelimiterDeclarer.extractDelimiter(separated.customDelimiterDeclaration());
    }
}
