package calculator.hexagon.application;

import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.SplitLogic;
import calculator.hexagon.domain.SumLogic;
import java.util.List;

public class StringSumProcesserImpl implements StringSumProcessor {
    private final SplitLogic splitLogic;
    private final NumberParser numberParser;
    private final SumLogic sumLogic;


    public StringSumProcesserImpl(
            SplitLogic splitLogic,
            NumberParser numberParser,
            SumLogic sumLogic
    ) {
        this.splitLogic = splitLogic;
        this.numberParser = numberParser;
        this.sumLogic = sumLogic;

    }

    @Override
    public int parseAndSum(String input) throws IllegalArgumentException {
        List<String> parts = splitLogic.split(input);
        List<Integer> integers = numberParser.parse(parts);
        return sumLogic.sum(integers);
    }
}
