package cloud.isaura.experimental.cellularautomata.simple.model;

public class BoardGuiConfiguration
{
    private final Integer rows;
    private final Integer columns;

    public BoardGuiConfiguration(Integer rows, Integer columns)
    {
        this.rows = rows;
        this.columns = columns;
    }

    public Integer getRows()
    {
        return rows;
    }

    public Integer getColumns()
    {
        return columns;
    }
}
