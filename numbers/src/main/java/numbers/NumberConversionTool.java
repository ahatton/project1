package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberConversionTool
{
    public String doConversion(NumbersConfigurationBean numbersConfigurationBean)
    {
        List<String> results = new ArrayList<>();
        IntStream.range(numbersConfigurationBean.getStartRange(), numbersConfigurationBean.getEndRange() + 1).forEachOrdered(
                num ->
                {
                    if (divisibleByBoth(num, numbersConfigurationBean.getFirstMultiple(), numbersConfigurationBean.getSecondMultiple()))
                    {
                        results.add(numbersConfigurationBean.getDualReplacement());
                    } else if (divisibleBy(num, numbersConfigurationBean.getFirstMultiple()))
                    {
                        results.add(numbersConfigurationBean.getFirstReplacement());
                    } else if (divisibleBy(num, numbersConfigurationBean.getSecondMultiple()))
                    {
                        results.add(numbersConfigurationBean.getSecondReplacement());
                    } else
                    {
                        results.add(String.valueOf(num));
                    }
                }
        );
        return String.join(",", results) + ".";
    }

    private boolean divisibleByBoth(int num, int firstMultiple, int secondMultiple)
    {
        return divisibleBy(num, firstMultiple) && divisibleBy(num, secondMultiple);
    }

    private boolean divisibleBy(int num, int multiple)
    {
        return multiple != 0 && num % multiple == 0;
    }
}
