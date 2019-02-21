package numbers;

import utilities.PropertyManager;

import java.util.Properties;

public class NumbersConfigurationFactory
{
    public static final String START_RANGE = "startRange";
    public static final String END_RANGE = "endRange";
    public static final String SWITCH_FLAG = "switchFlag";
    public static final String FIRST_MULTIPLE = "firstMultiple";
    public static final String SECOND_MULTIPLE = "secondMultiple";
    public static final String FIRST_REPLACEMENT = "firstReplacement";
    public static final String SECOND_REPLACEMENT = "secondReplacement";
    public static final String DUAL_REPLACEMENT = "dualReplacement";

    private NumbersConfigurationFactory()
    {

    }

    protected static NumbersConfigurationBean createNumbersConfiguration(Properties properties)
    {
        NumbersConfigurationBean numbersConfigurationBean = new NumbersConfigurationBean();
        PropertyManager propertyManager = new PropertyManager(properties);

        numbersConfigurationBean.setStartRange(propertyManager.retrieveInt(START_RANGE));
        numbersConfigurationBean.setEndRange(propertyManager.retrieveInt(END_RANGE));

       if(propertyManager.retrieveBoolean(SWITCH_FLAG))
        {
            numbersConfigurationBean.setFirstMultiple(propertyManager.retrieveInt(SECOND_MULTIPLE));
            numbersConfigurationBean.setSecondMultiple(propertyManager.retrieveInt(FIRST_MULTIPLE));
        }
        else
        {
            numbersConfigurationBean.setFirstMultiple(propertyManager.retrieveInt(FIRST_MULTIPLE));
            numbersConfigurationBean.setSecondMultiple(propertyManager.retrieveInt(SECOND_MULTIPLE));
        }

        numbersConfigurationBean.setFirstReplacement(propertyManager.retrieveString(FIRST_REPLACEMENT));
        numbersConfigurationBean.setSecondReplacement(propertyManager.retrieveString(SECOND_REPLACEMENT));
        numbersConfigurationBean.setDualReplacement(propertyManager.retrieveString(DUAL_REPLACEMENT));

        return numbersConfigurationBean;
    }

}
