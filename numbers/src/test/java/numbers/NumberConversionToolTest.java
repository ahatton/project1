package numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberConversionToolTest
{

    private NumberConversionTool numberConversionTool;
    private NumbersConfigurationBean numbersConfigurationBean;

    @BeforeEach
    public void setup()
    {
        numberConversionTool = new NumberConversionTool();

        numbersConfigurationBean = new NumbersConfigurationBean();
        numbersConfigurationBean.setStartRange(-75);
        numbersConfigurationBean.setEndRange(90);
        numbersConfigurationBean.setFirstMultiple(3);
        numbersConfigurationBean.setSecondMultiple(5);
        numbersConfigurationBean.setFirstReplacement("XYZ");
        numbersConfigurationBean.setSecondReplacement("ABC");
        numbersConfigurationBean.setDualReplacement("###");
    }

    @Test
    public void test_doConversion_standardTestData()
    {
        String actual = numberConversionTool.doConversion(numbersConfigurationBean);

        assertTrue(actual.contains("7,8,XYZ,ABC,11,XYZ,13,14,###"));

        assertTrue(actual.endsWith("88,89,###."));

        assertEquals("###,-74,-73,XYZ,-71,ABC,XYZ,-68,-67,XYZ,ABC,-64,XYZ,-62,-61,###,-59,-58,XYZ,-56,ABC,XYZ,-53," +
                "-52,XYZ,ABC,-49,XYZ,-47,-46,###,-44,-43,XYZ,-41,ABC,XYZ,-38,-37,XYZ,ABC,-34,XYZ,-32,-31,###,-29,-28,XYZ,-26," +
                "ABC,XYZ,-23,-22,XYZ,ABC,-19,XYZ,-17,-16,###,-14,-13,XYZ,-11,ABC,XYZ,-8,-7,XYZ,ABC,-4,XYZ,-2,-1,###,1,2,XYZ,4," +
                "ABC,XYZ,7,8,XYZ,ABC,11,XYZ,13,14,###,16,17,XYZ,19,ABC,XYZ,22,23,XYZ,ABC,26,XYZ,28,29,###,31,32,XYZ,34,ABC,XYZ," +
                "37,38,XYZ,ABC,41,XYZ,43,44,###,46,47,XYZ,49,ABC,XYZ,52,53,XYZ,ABC,56,XYZ,58,59,###,61,62,XYZ,64,ABC,XYZ,67,68," +
                "XYZ,ABC,71,XYZ,73,74,###,76,77,XYZ,79,ABC,XYZ,82,83,XYZ,ABC,86,XYZ,88,89,###.", actual);
    }

    @Test
    public void test_doConversion_reverseReplacementStrings()
    {
        numbersConfigurationBean.setFirstReplacement("ABC");
        numbersConfigurationBean.setSecondReplacement("XYZ");

        String actual = numberConversionTool.doConversion(numbersConfigurationBean);

        assertTrue(actual.contains("7,8,ABC,XYZ,11,ABC,13,14,###"));

        assertTrue(actual.endsWith("88,89,###."));

        assertEquals("###,-74,-73,ABC,-71,XYZ,ABC,-68,-67,ABC,XYZ,-64,ABC,-62,-61,###,-59,-58,ABC,-56,XYZ,ABC,-53," +
                "-52,ABC,XYZ,-49,ABC,-47,-46,###,-44,-43,ABC,-41,XYZ,ABC,-38,-37,ABC,XYZ,-34,ABC,-32,-31,###,-29,-28,ABC," +
                "-26,XYZ,ABC,-23,-22,ABC,XYZ,-19,ABC,-17,-16,###,-14,-13,ABC,-11,XYZ,ABC,-8,-7,ABC,XYZ,-4,ABC,-2,-1,###,1,2," +
                "ABC,4,XYZ,ABC,7,8,ABC,XYZ,11,ABC,13,14,###,16,17,ABC,19,XYZ,ABC,22,23,ABC,XYZ,26,ABC,28,29,###,31,32,ABC,34," +
                "XYZ,ABC,37,38,ABC,XYZ,41,ABC,43,44,###,46,47,ABC,49,XYZ,ABC,52,53,ABC,XYZ,56,ABC,58,59,###,61,62,ABC,64,XYZ," +
                "ABC,67,68,ABC,XYZ,71,ABC,73,74,###,76,77,ABC,79,XYZ,ABC,82,83,ABC,XYZ,86,ABC,88,89,###.", actual);
    }
}