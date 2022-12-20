package Buildings;

import java.awt.Color;

public class HBuildings extends javax.swing.JPanel {
    private int NumOfHouses;
    private boolean isHotel;
    public HBuildings() {
        initComponents();
        setOpaque(false);
        setVisible(false);
        
    }
    public void RemoveBuidings(){
        NumOfHouses=0;
        setOpaque(false);
        setVisible(false);
        isHotel = false; 
        Rent1.setVisible(false);
        Rent2.setVisible(false);
        Rent3.setVisible(false); 
        Rent4.setVisible(false); 
    }
    public void setNumAndColor(int NumOfHouses , Color color , boolean ISHotel){
        this.NumOfHouses = NumOfHouses;
        this.isHotel = ISHotel;
        Rent1.setVisible(false); Rent1.setBackground(color);
        Rent2.setVisible(false); Rent2.setBackground(color);
        Rent3.setVisible(false); Rent3.setBackground(color);
        Rent4.setVisible(false); Rent4.setBackground(color);
        setOpaque(false);
        if (NumOfHouses >= 1) Rent1.setVisible(true);
        if (NumOfHouses >= 2) Rent2.setVisible(true);
        if (NumOfHouses >= 3) Rent3.setVisible(true);
        if (NumOfHouses >= 4) Rent4.setVisible(true);
        
         this.setBackground(color);
         this.setOpaque(ISHotel);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rent1 = new javax.swing.JPanel();
        Rent2 = new javax.swing.JPanel();
        Rent3 = new javax.swing.JPanel();
        Rent4 = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Rent1.setBackground(new java.awt.Color(153, 0, 51));
        Rent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Rent1.setMinimumSize(new java.awt.Dimension(12, 12));
        Rent1.setPreferredSize(new java.awt.Dimension(8, 12));

        javax.swing.GroupLayout Rent1Layout = new javax.swing.GroupLayout(Rent1);
        Rent1.setLayout(Rent1Layout);
        Rent1Layout.setHorizontalGroup(
            Rent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Rent1Layout.setVerticalGroup(
            Rent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        Rent2.setBackground(new java.awt.Color(153, 0, 51));
        Rent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Rent2.setMinimumSize(new java.awt.Dimension(10, 12));
        Rent2.setPreferredSize(new java.awt.Dimension(8, 12));

        javax.swing.GroupLayout Rent2Layout = new javax.swing.GroupLayout(Rent2);
        Rent2.setLayout(Rent2Layout);
        Rent2Layout.setHorizontalGroup(
            Rent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Rent2Layout.setVerticalGroup(
            Rent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        Rent3.setBackground(new java.awt.Color(153, 0, 51));
        Rent3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Rent3.setMinimumSize(new java.awt.Dimension(10, 12));
        Rent3.setPreferredSize(new java.awt.Dimension(8, 12));

        javax.swing.GroupLayout Rent3Layout = new javax.swing.GroupLayout(Rent3);
        Rent3.setLayout(Rent3Layout);
        Rent3Layout.setHorizontalGroup(
            Rent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Rent3Layout.setVerticalGroup(
            Rent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        Rent4.setBackground(new java.awt.Color(153, 0, 51));
        Rent4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Rent4.setMinimumSize(new java.awt.Dimension(10, 12));
        Rent4.setPreferredSize(new java.awt.Dimension(8, 12));

        javax.swing.GroupLayout Rent4Layout = new javax.swing.GroupLayout(Rent4);
        Rent4.setLayout(Rent4Layout);
        Rent4Layout.setHorizontalGroup(
            Rent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Rent4Layout.setVerticalGroup(
            Rent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Rent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Rent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Rent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Rent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Rent1;
    private javax.swing.JPanel Rent2;
    private javax.swing.JPanel Rent3;
    private javax.swing.JPanel Rent4;
    // End of variables declaration//GEN-END:variables

    public int getNumOfHouses() {
        return NumOfHouses;
    }
    public boolean isIsHotel() {
        return isHotel;
    }

    public void setIsHotel(boolean isHotel) {
        this.setOpaque(isHotel);
        this.isHotel = isHotel;
    }
}
