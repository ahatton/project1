package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class FileLoader
{
    public static Properties loadPropertiesFile(Path propertiesFilePath)
    {
        Properties properties = new Properties();
        String absolutePath = propertiesFilePath.toAbsolutePath().toString();
        try (InputStream inputStream = new FileInputStream(absolutePath))
        {
            properties.load(inputStream);
        } catch (FileNotFoundException ex)
        {
            throw new RuntimeException(String.format("Could not find file at path %s", absolutePath));
        } catch (IOException ex)
        {
            throw new RuntimeException(String.format("Could not open file at path %s", absolutePath));
        }
        return properties;
    }
}
