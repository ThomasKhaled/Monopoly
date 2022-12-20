package NewGame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameOver extends javax.swing.JPanel {

    private boolean PlayAgain;
    
    public GameOver() {
        initComponents();
        PlayAgain = false;
        setBackground(new Color(0,0,0,95));
        jLabel11.setBackground(new Color(0,0,0,100));
    }

    public boolean isPlayAgain() {
        return PlayAgain;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 72)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePlay/img/GameOver2.png"))); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(360, 260, 680, 370);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    // End of variables declaration//GEN-END:variables
}
