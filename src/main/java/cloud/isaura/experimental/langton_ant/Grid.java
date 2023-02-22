package cloud.isaura.experimental.langton_ant;


import java.awt.*;



public class Grid
{
    private Cell[][] cells;

    private int rows;

    private int columns;

    public Grid(int rows, int columns)
    {
        this.rows=rows;
        this.columns=columns;
    }

    public void buildWithRowsAndColumns(int rows, int columns)
    {
        this.cells = new Cell[rows][columns];
        for(int row = 0; row < rows; row++)
        {
            for(int column = 0; column < columns ;column++)
            {
                this.cells[row][column]=new Cell(new CellParameter(Color.WHITE,row,column));
            }
        }
    }

    public Cell getCellAt(int row, int column)
    {
        return this.cells[row][column];
    }



    public void start()
    {
        for(int row = 0; row < this.cells.length; row++)
        {
            for(int column = 0; column < this.cells[row].length ;column++)
            {
                this.cells[row][column].start();
            }
        }

    }
}
