package cloud.isaura.experimental.cellularautomata.simple.model;

public class Ruleset
{
    private final int[] representation;

    private final String description;

    public Ruleset(int[] representation, String description)
    {
        this.representation = representation;
        this.description = description;
    }

    public int[] getRepresentation()
    {
        return representation;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return description;
    }
}
