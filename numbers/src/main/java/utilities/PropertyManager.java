package utilities;

import java.util.Properties;

public class PropertyManager
{
    private final Properties properties;

    public PropertyManager(Properties properties)
    {
        this.properties = properties;
    }

    public int retrieveInt(String name)
    {
        int result;
        try
        {
            result = Integer.parseInt(retrieveString(name));
        } catch (NumberFormatException ex)
        {
            throw new NumberFormatException(String.format("Property with name %s could not be parsed as an int", name));
        }
        return result;
    }

    public boolean retrieveBoolean(String name)
    {
        return Boolean.parseBoolean(retrieveString(name));
    }

    public String retrieveString(String name)
    {
        String propertyValue = properties.getProperty(name);
        if (null == propertyValue)
        {
            throw new RuntimeException(String.format("No property was found with name %s", name));
        }
        return propertyValue;
    }
}
