package numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersConverterTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup()
    {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test_main_testFilePassedAsArg()
    {
        String[] args = {NumbersConverterTest.class.getResource("standardPropertiesTestFile.txt").getFile()};
        NumbersConverter.main(args);

        assertEquals("###,-74,-73,XYZ,-71,ABC,XYZ,-68,-67,XYZ,ABC,-64,XYZ,-62,-61,###,-59,-58,XYZ,-56,ABC,XYZ,-53," +
                "-52,XYZ,ABC,-49,XYZ,-47,-46,###,-44,-43,XYZ,-41,ABC,XYZ,-38,-37,XYZ,ABC,-34,XYZ,-32,-31,###,-29,-28,XYZ,-26," +
                "ABC,XYZ,-23,-22,XYZ,ABC,-19,XYZ,-17,-16,###,-14,-13,XYZ,-11,ABC,XYZ,-8,-7,XYZ,ABC,-4,XYZ,-2,-1,###,1,2,XYZ,4," +
                "ABC,XYZ,7,8,XYZ,ABC,11,XYZ,13,14,###,16,17,XYZ,19,ABC,XYZ,22,23,XYZ,ABC,26,XYZ,28,29,###,31,32,XYZ,34,ABC,XYZ," +
                "37,38,XYZ,ABC,41,XYZ,43,44,###,46,47,XYZ,49,ABC,XYZ,52,53,XYZ,ABC,56,XYZ,58,59,###,61,62,XYZ,64,ABC,XYZ,67,68," +
                "XYZ,ABC,71,XYZ,73,74,###,76,77,XYZ,79,ABC,XYZ,82,83,XYZ,ABC,86,XYZ,88,89,###.\r\n", outContent.toString());
    }
}