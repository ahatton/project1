package utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;


public class PropertyManagerTest
{
    private PropertyManager propertyManager;

    @BeforeEach
    public void setup()
    {
        Properties properties = new Properties();
        properties.setProperty("intProp", "842");
        properties.setProperty("booleanPropTrue", "true");
        properties.setProperty("booleanPropFalse", "false");
        properties.setProperty("stringProp", "ABC");
        properties.setProperty("blankProp", "");

        propertyManager = new PropertyManager(properties);
    }

    @Test
    public void test_retrieveString_propertyMissing()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> propertyManager.retrieveString("missing"));
        assertEquals("No property was found with name missing", thrown.getMessage());
    }

    @Test
    public void test_retrieveString_propertyBlank()
    {
        String actual = propertyManager.retrieveString("blankProp");
        assertEquals("", actual);
    }

    @Test
    public void test_retrieveString_propertyPresent()
    {
        String actual = propertyManager.retrieveString("stringProp");
        assertEquals("ABC", actual);
    }

    @Test
    public void test_retrieveInt_propertyPresent()
    {
        int actual = propertyManager.retrieveInt("intProp");
        assertEquals(842, actual);
    }

    @Test
    public void test_retrieveInt_propertyBlank()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> propertyManager.retrieveInt("blankProp"));
        assertEquals("Property with name blankProp could not be parsed as an int", thrown.getMessage());
    }

    @Test
    public void test_retrieveInt_propertyNotInt()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> propertyManager.retrieveInt("stringProp"));
        assertEquals("Property with name stringProp could not be parsed as an int", thrown.getMessage());
    }

    @Test
    public void test_retrieveInt_propertyMissing()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> propertyManager.retrieveInt("missing"));
        assertEquals("No property was found with name missing", thrown.getMessage());
    }

    @Test
    public void test_retrieveBoolean_propertyPresentAndTrue()
    {
        boolean actual = propertyManager.retrieveBoolean("booleanPropTrue");
        assertTrue(actual);
    }

    @Test
    public void test_retrieveBoolean_propertyPresentAndFalse()
    {
        boolean actual = propertyManager.retrieveBoolean("booleanPropFalse");
        assertFalse(actual);
    }

    @Test
    public void test_retrieveBoolean_propertyBlank()
    {
        boolean actual = propertyManager.retrieveBoolean("blankProp");
        assertFalse(actual);
    }

    @Test
    public void test_retrieveBoolean_propertyNotBoolean()
    {
        boolean actual = propertyManager.retrieveBoolean("stringProp");
        assertFalse(actual);
    }

    @Test
    public void test_retrieveBoolean_propertyMissing()
    {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> propertyManager.retrieveBoolean("missing"));
        assertEquals("No property was found with name missing", thrown.getMessage());
    }
}