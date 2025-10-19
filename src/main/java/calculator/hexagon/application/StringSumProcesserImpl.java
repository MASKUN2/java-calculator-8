package calculator.hexagon.application;

import calculator.hexagon.domain.SplitLogic;
import calculator.hexagon.domain.SumLogic;
import java.util.List;

public class StringSumProcesserImpl implements StringSumProcessor {
    private final SplitLogic splitLogic;
    private final StringIntegerParser stringIntegerParser;
    private final SumLogic sumLogic;


    public StringSumProcesserImpl(
            SplitLogic splitLogic,
            StringIntegerParser stringIntegerParser,
            SumLogic sumLogic
    ) {
        this.splitLogic = splitLogic;
        this.stringIntegerParser = stringIntegerParser;
        this.sumLogic = sumLogic;

    }

    @Override
    public int parseAndSum(String input) throws IllegalArgumentException {
        List<String> parts = splitLogic.split(input);
        List<Integer> integers = stringIntegerParser.parse(parts);
        return sumLogic.sum(integers);
    }
}
