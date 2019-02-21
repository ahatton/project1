package numbers;

import utilities.FileLoader;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Properties;

public class NumbersConvertor
{
    public static void main(String[] args)
    {
        Path propetiesFilePath = getPropertiesFilePath(args);
        Properties properties = FileLoader.loadPropertiesFile(propetiesFilePath.toAbsolutePath());
        NumbersConfigurationBean numbersConfigurationBean = NumbersConfigurationFactory.createNumbersConfiguration(properties);
        String conversion = new NumberConversionTool().doConversion(numbersConfigurationBean);
        System.out.println(conversion);
        System.exit(0);
    }

    private static Path getPropertiesFilePath(String[] args)
    {
        String fileSelected;
        if (args.length == 0)
        {
            FileDialog dialog = new FileDialog((Frame) null, "Select configuration file", FileDialog.LOAD);
            dialog.setVisible(true);
            fileSelected = dialog.getDirectory() + dialog.getFile();
        } else
        {
            fileSelected = args[0];
        }
        return Path.of(new File(fileSelected).getAbsolutePath());
    }
}
