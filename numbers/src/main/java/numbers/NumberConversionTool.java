package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Tool for converting a range of numbers into a String based on what multiples any given number in the range is divisible by.
 */
public class NumberConversionTool
{
    /**
     * Performs the conversion of a range of numbers to a String, replacing numbers in the range based on what multiples they are divisible by.
     * @param numbersConfigurationBean the full configuration bean the tool will use for its conversion.
     * @return a String containing replaced numbers that were divisible by one or both of the multiples provided.
     */
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
