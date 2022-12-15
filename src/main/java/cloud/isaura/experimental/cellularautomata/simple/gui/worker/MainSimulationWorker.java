package cloud.isaura.experimental.cellularautomata.simple.gui.worker;

import cloud.isaura.experimental.cellularautomata.simple.algo.AutomataGenerator;
import cloud.isaura.experimental.cellularautomata.simple.gui.CaGui;
import cloud.isaura.experimental.cellularautomata.simple.gui.CaGuiImproved;
import cloud.isaura.experimental.cellularautomata.simple.model.Cell;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import javax.swing.*;
import java.util.List;

public class MainSimulationWorker extends SwingWorker<Void, Cell> implements Observer<Cell>
{

    private CaGuiImproved gui;

    public MainSimulationWorker(CaGuiImproved gui)
    {
        this.gui = gui;
    }

    @Override
    protected Void doInBackground() throws Exception
    {
        System.out.println("Ciao, sono " + Thread.currentThread().getName()
                + " ed eseguo doInBackground()");

        AutomataGenerator automataGenerator = new AutomataGenerator();
        automataGenerator.execute(this, this.gui.getSelected());
        System.out.println("Ciao, sono " + Thread.currentThread().getName()
                + " e finisco doInBackground()");
        return null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d)
    {

    }

    @Override
    public void onNext(@NonNull Cell cell)
    {
        //System.out.println("observed updated cell " + cell);
        publish(cell);
    }

    @Override
    public void onError(@NonNull Throwable e)
    {

    }

    @Override
    public void onComplete()
    {

    }

    @Override
    protected void process(List<Cell> chunks)
    {
        super.process(chunks);
        //System.out.println(chunks.size());
        for(int i = 0; i < chunks.size();i++)
        {
            Cell cell = chunks.get(i);
            this.gui.setStateAt(cell.getRow(),cell.getColumn(),cell.getState());
        }

    }
}
