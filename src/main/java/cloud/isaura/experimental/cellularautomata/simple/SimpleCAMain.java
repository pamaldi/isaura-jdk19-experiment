package cloud.isaura.experimental.cellularautomata.simple;

import cloud.isaura.experimental.cellularautomata.simple.gui.CaGui;
import cloud.isaura.experimental.cellularautomata.simple.model.BoardGuiConfiguration;
import cloud.isaura.experimental.cellularautomata.simple.utils.Constants;

import javax.swing.*;

public class SimpleCAMain extends JPanel
{


    public static void main(String[] args)
    {
        BoardGuiConfiguration boardGuiConfiguration = new BoardGuiConfiguration(Constants.boardRows, Constants.boardColumns);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI(boardGuiConfiguration);
            }
        });

    }

    private static void createAndShowGUI(BoardGuiConfiguration boardGuiConfiguration)
    {
        new CaGui(boardGuiConfiguration);
    }
}
