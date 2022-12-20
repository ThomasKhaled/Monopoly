package GamePlay0;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Player_pnl extends javax.swing.JPanel {
    
    public Player_pnl() {
        initComponents();
    }

    public JLabel getBalance_lbl() {
        return Balance_lbl;
    }

    public void setBalance_lbl(JLabel Balance_lbl) {
        this.Balance_lbl = Balance_lbl;
    }

    public JLabel getID_lbl() {
        return ID_lbl;
    }

    public void setID_lbl(JLabel ID_lbl) {
        this.ID_lbl = ID_lbl;
    }

    public JPanel getPlayercolor_pnl() {
        return Playercolor_pnl;
    }

    public void setPlayercolor_pnl(JPanel Playercolor_pnl) {
        this.Playercolor_pnl = Playercolor_pnl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Playercolor_pnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ID_lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Balance_lbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(125, 150));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Player ID:");

        ID_lbl.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Owned");

        javax.swing.GroupLayout Playercolor_pnlLayout = new javax.swing.GroupLayout(Playercolor_pnl);
        Playercolor_pnl.setLayout(Playercolor_pnlLayout);
        Playercolor_pnlLayout.setHorizontalGroup(
            Playercolor_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Playercolor_pnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(Playercolor_pnlLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        Playercolor_pnlLayout.setVerticalGroup(
            Playercolor_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Playercolor_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Playercolor_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(Playercolor_pnl);
        Playercolor_pnl.setBounds(4, 5, 112, 33);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Balance:");
        add(jLabel2);
        jLabel2.setBounds(10, 116, 55, 23);

        Balance_lbl.setText("jLabel3");
        add(Balance_lbl);
        Balance_lbl.setBounds(75, 120, 34, 14);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/money.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 40, 120, 80);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Balance_lbl;
    private javax.swing.JLabel ID_lbl;
    private javax.swing.JPanel Playercolor_pnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
