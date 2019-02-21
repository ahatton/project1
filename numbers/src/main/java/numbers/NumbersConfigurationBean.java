package numbers;

public class NumbersConfigurationBean
{
    private int startRange;
    private int endRange;

    private int firstMultiple;
    private int secondMultiple;

    private String firstReplacement;
    private String secondReplacement;
    private String dualReplacement;

    public int getStartRange()
    {
        return startRange;
    }

    public void setStartRange(int startRange)
    {
        this.startRange = startRange;
    }

    public int getEndRange()
    {
        return endRange;
    }

    public void setEndRange(int endRange)
    {
        this.endRange = endRange;
    }

    public int getFirstMultiple()
    {
        return firstMultiple;
    }

    public void setFirstMultiple(int firstMultiple)
    {
        this.firstMultiple = firstMultiple;
    }

    public int getSecondMultiple()
    {
        return secondMultiple;
    }

    public void setSecondMultiple(int secondMultiple)
    {
        this.secondMultiple = secondMultiple;
    }

    public String getFirstReplacement()
    {
        return firstReplacement;
    }

    public void setFirstReplacement(String firstReplacement)
    {
        this.firstReplacement = firstReplacement;
    }

    public String getSecondReplacement()
    {
        return secondReplacement;
    }

    public void setSecondReplacement(String secondReplacement)
    {
        this.secondReplacement = secondReplacement;
    }

    public String getDualReplacement()
    {
        return dualReplacement;
    }

    public void setDualReplacement(String dualReplacement)
    {
        this.dualReplacement = dualReplacement;
    }
}
