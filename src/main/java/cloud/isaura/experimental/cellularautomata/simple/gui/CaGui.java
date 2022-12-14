package cloud.isaura.experimental.cellularautomata.simple.gui;

import cloud.isaura.experimental.cellularautomata.simple.gui.listener.SimulationListener;
import cloud.isaura.experimental.cellularautomata.simple.model.BoardGuiConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaGui extends JFrame implements MouseListener, MouseMotionListener
{
    public static final int dimw = 1000;
    public static final int dimh = 800;

    JLayeredPane layeredPane;
    JPanel boardPanel;

    private SimulationListener simulationListener;

    private BoardGuiConfiguration boardGuiConfiguration;

    private BorderLayout layout;

    private Dimension boardSize;

    private JPanel[][] squarePanels;

    public CaGui(BoardGuiConfiguration boardGuiConfiguration)
    {
        initGui(boardGuiConfiguration);
        buildGui(boardGuiConfiguration);
        disposeGui();
    }

    private void disposeGui()
    {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            // Method
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    private void initGui(BoardGuiConfiguration boardGuiConfiguration)
    {
        this.setSize(1000,1200);
        this.setResizable(false);
        boardSize = new Dimension(dimw, dimh);
        layeredPane = new JLayeredPane();
        //ayeredPane.setSize(900,1000);
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        this.simulationListener = new SimulationListener(this);
        this.boardGuiConfiguration = boardGuiConfiguration;
    }

    public void buildGui(BoardGuiConfiguration boardGuiConfiguration)
    {
        layout = new BorderLayout();
        layeredPane.setLayout(layout);
        addBoard(boardGuiConfiguration);
        addButtons();
        addInfo();
    }

    private void addBoard(BoardGuiConfiguration boardGuiConfiguration)
    {


        boardPanel = new JPanel();
        final Integer columns = boardGuiConfiguration.getColumns();
        final Integer rows = boardGuiConfiguration.getRows();
        boardPanel.setLayout(new GridLayout(rows, columns));
        Dimension boardSize1 = new Dimension(800, 300);
        boardPanel.setPreferredSize(boardSize1);
        //boardPanel.setBounds(0, 0, boardSize1.width, boardSize1.height);
        squarePanels = new JPanel[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                JPanel square = new JPanel(new BorderLayout());
                boardPanel.add(square);
                square.setBackground(Color.white);
                square.setBorder(BorderFactory.createLineBorder(Color.black));
                squarePanels[i][j] = square;
            }


        }
        layeredPane.add(boardPanel, BorderLayout.CENTER);
    }

    public void setStateAt(int row, int column, int state)
    {
        Color color = Color.white;
        if (state == 1)
        {
            color = Color.black;
        }
        this.squarePanels[row][column].setBackground(color);
    }

    public void clear()
    {
        final Integer columns = boardGuiConfiguration.getColumns();
        final Integer rows = boardGuiConfiguration.getRows();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                this.squarePanels[i][j].setBackground(Color.white);
            }


        }
    }

    private void addButtons()
    {

        JPanel buttonPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(boxLayout);
        JButton start = new JButton("Start");
        buttonPanel.add(start);
        start.addActionListener(this.simulationListener);
        start.setActionCommand("start");
        JButton clear = new JButton("Clear");
        buttonPanel.add(clear);
        clear.addActionListener(this.simulationListener);
        clear.setActionCommand("clear");
        layeredPane.add(buttonPanel, BorderLayout.LINE_START);
    }

    private void addInfo()
    {

        JPanel infoPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
        infoPanel.setLayout(boxLayout);
        JTextArea textArea = new JTextArea("Info");
        textArea.setSize(100,100);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        infoPanel.add("infoArea",textArea);
        layeredPane.add(infoPanel, BorderLayout.PAGE_END);
    }

    public void mousePressed(MouseEvent e)
    {

        Component c = boardPanel.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;


    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me)
    {

    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

}