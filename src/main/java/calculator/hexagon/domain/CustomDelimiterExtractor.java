package calculator.hexagon.domain;

import java.util.Optional;

public interface CustomDelimiterExtractor {

    Optional<String> extractDelimiter(String declaration);
}
