package utilities;

import java.util.Properties;

/**
 * Handy Helper class that standardises the retrieval/conversion of properties to respective types.
 */
public class PropertyManager
{
    private final Properties properties;

    /**
     * Initilises a PropertyManager object taking a properties object it will manage.
     * @param properties the properties object we want managed.
     */
    public PropertyManager(Properties properties)
    {
        this.properties = properties;
    }

    /**
     * Attempts to convert a given property to an integer. Throws Runtime Exception if property can not be parsed as int.
     * @param name the name of the property to retrieve.
     * @return the property converted to a int type.
     */
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

    /**
     * Attempts to convert a given property to a boolean.
     * @param name the name of the property to retrieve.
     * @return the property converted to a boolean type.
     */
    public boolean retrieveBoolean(String name)
    {
        return Boolean.parseBoolean(retrieveString(name));
    }

    /**
     * Attempts to retrieve a given property from the instances properties object.
     * Throws Runtime Exception if property can not be found.
     * @param name the name of the property to retrieve.
     * @return the property as a String.
     */
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
