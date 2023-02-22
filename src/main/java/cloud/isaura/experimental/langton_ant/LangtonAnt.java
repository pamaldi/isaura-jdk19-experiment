package cloud.isaura.experimental.langton_ant;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LangtonAnt
{
    private LangtonAntParameter langtonAntParameter;

    private Grid grid;

    private  List<List<Channel<Boolean>>> tickChannels;
    private  List<List<Channel<Boolean>>> resultChannels;

    LangtonAnt(LangtonAntParameter langtonAntParameter)
    {
        this.langtonAntParameter=langtonAntParameter;
        initGrid(langtonAntParameter);
        addCells(langtonAntParameter);
        this.grid.getCellAt(langtonAntParameter.rowAnt(), langtonAntParameter.columnAnt()).setAnt(Boolean.TRUE);
    }

    private void addCells(LangtonAntParameter langtonAntParameter)
    {
        this.tickChannels   = makeGrid(langtonAntParameter.rows(), langtonAntParameter.columns(), Channel::new);
        this.resultChannels = makeGrid(langtonAntParameter.rows(), langtonAntParameter.columns(), Channel::new);
        for(int row = 0; row < langtonAntParameter.rows(); row++)
        {
            for(int column = 0; column< langtonAntParameter.columns(); column++)
            {
                Cell cell = this.grid.getCellAt(row, column);
                cell.setTickChannel(this.tickChannels.get(row).get(column));
                cell.setResultChannel(this.resultChannels.get(row).get(column));
            }
        }
    }

    private void initGrid(LangtonAntParameter langtonAntParameter)
    {
        this.grid = new Grid(langtonAntParameter.rows(), langtonAntParameter.columns());

    }

    void start() {

        this.grid.start();
        System.out.println("Started all cells");
        Thread.startVirtualThread(this::run);
    }

    public void run() {
        System.out.println("Run LA");
        while (true) {
             System.out.println("Langton Ant Game running");
             sleep();
        }
    }

    private void sleep() {
        try {
            System.out.println("Langton Ant Game sleeping");
            Thread.sleep(langtonAntParameter.period());

        } catch (InterruptedException ignore) {

        }
    }

    private static <T> List<List<T>> makeGrid(int rows, int cols, Supplier<T> supplier) {
        return   IntStream.range(0, rows)
                .mapToObj(r -> IntStream.range(0, cols)
                .mapToObj(c -> supplier.get()).toList())
                .toList();
    }
}
