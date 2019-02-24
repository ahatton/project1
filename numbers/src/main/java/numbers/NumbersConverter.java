package numbers;

import utilities.FileLoader;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Main class for the NumberConversion program.
 * If you provide a single arg that will be used as the file path for the configuration file.
 * If you don't provide any args then you will be presented with a File Chooser dialog.
 */
public class NumbersConverter
{
    public static void main(String[] args)
    {
        Path propertiesFilePath = getPropertiesFilePath(args);
        Properties properties = FileLoader.loadPropertiesFile(propertiesFilePath.toAbsolutePath());
        NumbersConfigurationBean numbersConfigurationBean = NumbersConfigurationFactory.createNumbersConfiguration(properties);
        String conversion = new NumberConversionTool().doConversion(numbersConfigurationBean);
        System.out.println(conversion);
    }

    private static Path getPropertiesFilePath(String[] args)
    {
        String fileSelected;
        if (args.length == 0)
        {
            FileDialog dialog = new FileDialog((Frame) null, "Select configuration file", FileDialog.LOAD);
            dialog.setVisible(true);
            fileSelected = dialog.getDirectory() + dialog.getFile();
            dialog.dispose();
        } else
        {
            fileSelected = args[0];
        }
        return Path.of(new File(fileSelected).getAbsolutePath());
    }
}
