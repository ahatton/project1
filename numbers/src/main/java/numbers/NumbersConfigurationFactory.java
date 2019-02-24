package numbers;

import utilities.PropertyManager;

import java.util.Properties;

/**
 * Factory for creating a NumbersConfigurationBean object from a Properties object.
 */
public class NumbersConfigurationFactory
{
    protected static final String START_RANGE = "startRange";
    protected static final String END_RANGE = "endRange";
    protected static final String SWITCH_FLAG = "switchFlag";
    protected static final String FIRST_MULTIPLE = "firstMultiple";
    protected static final String SECOND_MULTIPLE = "secondMultiple";
    protected static final String FIRST_REPLACEMENT = "firstReplacement";
    protected static final String SECOND_REPLACEMENT = "secondReplacement";
    protected static final String DUAL_REPLACEMENT = "dualReplacement";

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
