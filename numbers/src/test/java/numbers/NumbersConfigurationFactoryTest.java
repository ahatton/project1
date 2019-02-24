package numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class NumbersConfigurationFactoryTest
{
    private Properties properties;

    @BeforeEach
    public void setup()
    {
        properties = new Properties();
        properties.put(NumbersConfigurationFactory.START_RANGE, "1");
        properties.put(NumbersConfigurationFactory.END_RANGE, "7");
        properties.put(NumbersConfigurationFactory.SWITCH_FLAG, "false");
        properties.put(NumbersConfigurationFactory.FIRST_MULTIPLE, "3");
        properties.put(NumbersConfigurationFactory.SECOND_MULTIPLE, "5");
        properties.put(NumbersConfigurationFactory.FIRST_REPLACEMENT, "XYZ");
        properties.put(NumbersConfigurationFactory.SECOND_REPLACEMENT, "ABC");
        properties.put(NumbersConfigurationFactory.DUAL_REPLACEMENT, "###");
    }

    @Test
    public void test_createNumbersConfiguration_allFieldsSet()
    {
        NumbersConfigurationBean actual = NumbersConfigurationFactory.createNumbersConfiguration(properties);

        assertEquals(1, actual.getStartRange());
        assertEquals(7, actual.getEndRange());
        assertEquals(3, actual.getFirstMultiple());
        assertEquals(5, actual.getSecondMultiple());
        assertEquals("XYZ", actual.getFirstReplacement());
        assertEquals("ABC", actual.getSecondReplacement());
        assertEquals("###", actual.getDualReplacement());
    }

    @Test
    public void test_createNumbersConfiguration_switchBlank()
    {
        properties.put(NumbersConfigurationFactory.SWITCH_FLAG, "");

        NumbersConfigurationBean actual = NumbersConfigurationFactory.createNumbersConfiguration(properties);

        assertEquals(1, actual.getStartRange());
        assertEquals(7, actual.getEndRange());
        assertEquals(3, actual.getFirstMultiple());
        assertEquals(5, actual.getSecondMultiple());
        assertEquals("XYZ", actual.getFirstReplacement());
        assertEquals("ABC", actual.getSecondReplacement());
        assertEquals("###", actual.getDualReplacement());
    }

    @Test
    public void test_createNumbersConfiguration_switchTrue()
    {
        properties.put(NumbersConfigurationFactory.SWITCH_FLAG, "true");

        NumbersConfigurationBean actual = NumbersConfigurationFactory.createNumbersConfiguration(properties);

        assertEquals(1, actual.getStartRange());
        assertEquals(7, actual.getEndRange());
        assertEquals(5, actual.getFirstMultiple());
        assertEquals(3, actual.getSecondMultiple());
        assertEquals("XYZ", actual.getFirstReplacement());
        assertEquals("ABC", actual.getSecondReplacement());
        assertEquals("###", actual.getDualReplacement());
    }

}