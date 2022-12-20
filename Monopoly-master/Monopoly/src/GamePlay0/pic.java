package GamePlay0;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A.LoOotfy
 */
public class pic extends javax.swing.JPanel {

    public pic() {
        initComponents();

    }

     public void setImage(String path , boolean border){      
        JPanel pnl = new JPanel(){
          @Override
          public void paintComponent(Graphics g){
              Graphics2D g2 = (Graphics2D)g;
              Image img;
              try {
                  img = ImageIO.read(new File(path));
                  g2.drawImage(img, 1, 1, this.getWidth()-1, this.getHeight()-1, this);
              } catch (IOException ex) {
                  //Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
              }
              if (border){
                g2.setStroke(new BasicStroke(2));
                g2.drawRect(0, 0, this.getWidth(), this.getHeight());
              }
          }  
        };
        this.add(pnl);
        
  
        pnl.setBounds(0, 0, this.getWidth(), this.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
