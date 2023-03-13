package cloud.isaura.experimental.cellularautomata.simple;

import cloud.isaura.experimental.cellularautomata.simple.gui.CaGuiImproved;
import cloud.isaura.experimental.cellularautomata.simple.model.BoardGuiConfiguration;
import cloud.isaura.experimental.cellularautomata.simple.utils.Constants;

import javax.swing.*;

public class SimpleCAMain extends JPanel
{


    public static void main(String[] args)
    {
        BoardGuiConfiguration boardGuiConfiguration = new BoardGuiConfiguration(Constants.boardRows, Constants.boardColumns);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaGuiImproved(boardGuiConfiguration).setVisible(true);
            }
        });

    }


}
