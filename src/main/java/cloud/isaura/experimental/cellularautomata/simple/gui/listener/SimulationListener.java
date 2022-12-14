package cloud.isaura.experimental.cellularautomata.simple.gui.listener;

import cloud.isaura.experimental.cellularautomata.simple.gui.CaGui;
import cloud.isaura.experimental.cellularautomata.simple.gui.worker.MainSimulationWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationListener implements ActionListener
{
    private MainSimulationWorker mainSimulationWorker;

    private CaGui gui;

    public SimulationListener(CaGui gui)
    {
        this.gui = gui;
    }

    private void startSimulation()
    {
        this.mainSimulationWorker = new MainSimulationWorker(this.gui);
        try
        {
            this.mainSimulationWorker.execute();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if (command == "start")
        {
            startSimulation();
        }else if (command == "clear")
        {
            this.gui.clear();
        }
    }
}
