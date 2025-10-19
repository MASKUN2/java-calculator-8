package calculator.hexagon.application;

import calculator.hexagon.domain.SumLogic;
import java.util.List;

public class StringSumProcesserImpl implements StringSumProcessor {
    private final StringNumberSplitter splitter;
    private final StringIntegerParser stringIntegerParser;
    private final SumLogic sumLogic;


    public StringSumProcesserImpl(
            StringNumberSplitter splitter,
            StringIntegerParser stringIntegerParser,
            SumLogic sumLogic
    ) {
        this.splitter = splitter;
        this.stringIntegerParser = stringIntegerParser;
        this.sumLogic = sumLogic;

    }

    @Override
    public int parseAndSum(String input) throws IllegalArgumentException {
        List<String> parts = splitter.split(input);
        List<Integer> integers = stringIntegerParser.parse(parts);
        return sumLogic.sum(integers);
    }
}
