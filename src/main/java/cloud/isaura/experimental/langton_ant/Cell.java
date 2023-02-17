package cloud.isaura.experimental.langton_ant;

import java.awt.*;

public class Cell
{
    private Color color;

    private int row;

    private int column;

    private Boolean ant;

    private Channel<Boolean> tickChannel;
    private Channel<Boolean> resultChannel;

    public Cell(CellParameter cellParameter)
    {
        this.color=cellParameter.color();
        this.row=cellParameter.row();
        this.column= cellParameter.column();
    }

    void start() {
        Thread thread = Thread.startVirtualThread(this::run);
        //System.out.println("Started Thread "+thread);
    }

    public void setTickChannel(Channel<Boolean> tickChannel)
    {
        this.tickChannel = tickChannel;
    }

    public void setResultChannel(Channel<Boolean> resultChannel)
    {
        this.resultChannel = resultChannel;
    }

    private void run() {
        //System.out.println("Runnin Thread "+Thread.currentThread().getState());
    }

    public void setAnt(Boolean ant)
    {
        this.ant = ant;
    }
}
