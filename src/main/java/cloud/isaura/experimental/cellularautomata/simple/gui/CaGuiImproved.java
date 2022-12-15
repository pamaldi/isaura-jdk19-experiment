package cloud.isaura.experimental.cellularautomata.simple.gui;

import cloud.isaura.experimental.cellularautomata.simple.gui.listener.SimulationListener;
import cloud.isaura.experimental.cellularautomata.simple.model.BoardGuiConfiguration;
import cloud.isaura.experimental.cellularautomata.simple.model.Ruleset;
import cloud.isaura.experimental.cellularautomata.simple.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CaGuiImproved extends javax.swing.JFrame
{
    private BoardGuiConfiguration boardGuiConfiguration;

    private SimulationListener simulationListener;


    private  boolean[][] cells;

    private final Canvas canvas;

    private final int rows;
    private final int columns;


    class RuleSetComboBoxModel extends DefaultComboBoxModel<Ruleset> {


        public RuleSetComboBoxModel(Vector<Ruleset> v)
        {
            super(v);
        }

        @Override
        public Ruleset getSelectedItem() {
            Ruleset ruleset = (Ruleset) super.getSelectedItem();

            // do something with this job before returning...

            return ruleset;
        }
    }

    class Canvas extends JPanel
    {


        private int cellWidth=(750/ cells[0].length);
        private int cellHeight = (750 / cells.length);

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
            Graphics2D g2d = (Graphics2D) g;

            if (cells == null)
                return;
            int currentRow = 0;

            for (int y = 0; y < 750; y += cellHeight) {
                int currentColumn = 0;
                for(int x = 0; x < 750; x += cellWidth )
                {
                    //System.out.println(" x "+x+" y "+y+" currentRow "+currentRow+" currentColumn "+currentColumn);
                    g2d.drawRect(x, y, cellWidth, cellHeight);
                    if(cells[currentRow][currentColumn])
                    {
                        g2d.fillRect(x, y, cellWidth, cellHeight);
                    }
                    currentColumn++;
                }
                currentRow++;
            }

        }


    }


    public CaGuiImproved(BoardGuiConfiguration boardGuiConfiguration) {
        this.boardGuiConfiguration=boardGuiConfiguration;
        this.simulationListener = new SimulationListener(this);
        this.rows = (int) (Constants.boardColumns);
        this.columns = (int) (Constants.boardRows);
        this.cells = new boolean[rows][columns];
        canvas = new Canvas();
        initComponents();
        this.canvas.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        start = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        comboRulesets = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        getRulesets();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
                canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                                       );
        canvasLayout.setVerticalGroup(
                canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 496, Short.MAX_VALUE)
                                     );


        start.setText("Start");
        start.addActionListener(this.simulationListener);
        start.setActionCommand("start");

        clear.setText("Clear");
        clear.addActionListener(this.simulationListener);
        clear.setActionCommand("clear");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        RuleSetComboBoxModel ruleSetComboBoxModel = new RuleSetComboBoxModel(getRulesets());
        comboRulesets.setModel(ruleSetComboBoxModel);

        jLabel1.setText("Regole");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                                        .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(comboRulesets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                                 );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(comboRulesets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(start)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(clear)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                               );
        pack();
    }// </editor-fold>

    private Vector<Ruleset> getRulesets(){
        int dim = 8;
        double num = Math.pow(2,dim);
        Vector<Ruleset> rulesets = new Vector<>();
        for(int i = 0; i < num;i++)
        {
            String current = Integer.toBinaryString(i);
            String padded = StringUtils.leftPad(current,dim,"0");
            //System.out.println("padded "+padded);
            int[] rule = new int[dim];
            for(int k = 0; k<dim;k++)
            {
                rule[k]=Integer.parseInt(Character.toString(padded.charAt(k)));

            }
            Ruleset ruleset = new Ruleset(rule,"Rule "+i+": "+padded);
            rulesets.add(ruleset);
        }
        return rulesets;
    }

    public Ruleset getSelected()
    {
        return (Ruleset) this.comboRulesets.getSelectedItem();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaGuiImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaGuiImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaGuiImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaGuiImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


    }

    public void setStateAt(int row, int column, int state)
    {

        this.cells[row][column]= state == 0? false: true;
        //System.out.println("repaint row "+row+" column "+column);
        this.canvas.repaint();
    }

    public void clear()
    {
        this.cells = new boolean[rows][columns];
        this.canvas.repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton start;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<Ruleset> comboRulesets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
