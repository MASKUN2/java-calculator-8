package calculator.hexagon.application;

import calculator.hexagon.domain.NumberParser;
import calculator.hexagon.domain.SplitLogic;
import calculator.hexagon.domain.SumLogic;
import calculator.hexagon.domain.value.Input;
import calculator.hexagon.domain.value.ParsedInteger;
import calculator.hexagon.domain.value.Result;
import calculator.hexagon.domain.value.SingleIntegerPart;
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
    public Result parseAndSum(Input input) throws IllegalArgumentException {
        List<SingleIntegerPart> parts = splitLogic.split(input);
        List<ParsedInteger> integers = numberParser.parse(parts);
        return sumLogic.sum(integers);
    }
}
