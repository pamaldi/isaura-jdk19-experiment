package cloud.isaura.experimental.cellularautomata.simple.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board
{
    private Cell[][] cells = null;

    private final Integer numRows;
    private final Integer numColumns;


    public Board(Integer numColumns, Integer numRows)
    {
        this.numColumns = numColumns;
        this.numRows = numRows;
        this.cells = new Cell[numRows][numColumns];
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {

                cells[i][j] = new Cell(0,i,j);

            }
        }

    }

    public Cell[] getCellsAtRow(int row)
    {
        return this.cells[row];
    }

    public void setStateAtValue(int row, int column, int value)
    {
        this.cells[row][column].setState(value);
    }

    public Cell getCellsAt(int row, int column)
    {
        return this.cells[row][column];
    }

    public int getStateAt(int row, int column)
    {
        return this.cells[row][column].getState();
    }


    public void printRow(int i)
    {
        final Cell[] row = this.cells[i];
        for (int j = 0; j < row.length; j++)
        {
            System.out.println(row[j]);
        }
    }

    public String getRowAsAString(int i)
    {
        final Cell[] row = this.cells[i];
        return Arrays.stream(row).map(cell -> String.valueOf(cell.getState())).collect(Collectors.joining(""));

    }

    public void print()
    {
        for (int i = 0; i < this.cells.length; i++)
        {

            System.out.println(getRowAsAString(i));
        }

    }


}
