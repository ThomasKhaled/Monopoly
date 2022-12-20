
package GamePlay0;

/**
 *
 * @author Thomas
 */



import Playerpkg.PlayerCurrentPostion;
import Playerpkg.Player;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


class ImageLabel extends JLabel{
    private Image _myimage;

    public ImageLabel(String text){
        super(text);
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        if (icon instanceof ImageIcon)
        {
            _myimage = ((ImageIcon) icon).getImage();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}


class CardsDraw{

    private String m_title;
    private String m_description;
    private String m_imgPath;
    private int m_amountOfMoneyPayedOrGained;

    public int getM_amountOfMoneyPayedOrGained() {
        return m_amountOfMoneyPayedOrGained;
    }
    public CardsDraw(){
        
    }
    
    public CardsDraw(String imgPath, int amountOfMoneyPayedOrGained ) {
        m_imgPath = imgPath;
        m_amountOfMoneyPayedOrGained = amountOfMoneyPayedOrGained;
    }
    
    public CardsDraw(int amountOfMoneyPayedOrGained ) {
        m_amountOfMoneyPayedOrGained = amountOfMoneyPayedOrGained;
    }
    
    
    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_description() {
        return m_description;
    }

    public void setM_description(String m_description) {
        this.m_description = m_description;
    }

    public String getM_imgPath() {
        return m_imgPath;
    }

    public void setM_imgPath(String m_imgPath) {
        this.m_imgPath = m_imgPath;
    }
 
}

class ChanceCards extends CardsDraw{
    private Map<Integer, CardsDraw> m_chanceCards;

    public Map<Integer, CardsDraw> getM_chanceCards() {
        return m_chanceCards;
    }

    CardsDraw card1 = new CardsDraw("1.jpg" ,200); //gain
    CardsDraw card2 = new CardsDraw("2.jpg" ,0);
    CardsDraw card3 = new CardsDraw("3.jpg" ,0);
    CardsDraw card4 = new CardsDraw("4.jpg" ,0);
    CardsDraw card5 = new CardsDraw("5.jpg" ,0);
    CardsDraw card6 = new CardsDraw("6.jpg" ,50); //gain
    CardsDraw card7 = new CardsDraw("7.jpg" ,0);
    CardsDraw card8 = new CardsDraw("8.jpg" ,0);
    CardsDraw card9 = new CardsDraw("9.jpg" ,0);
    CardsDraw card10 = new CardsDraw("10.jpg" ,150); //pay
    CardsDraw card11 = new CardsDraw("11.jpg" ,200); //gain
    CardsDraw card12 = new CardsDraw("12.jpg" ,0);
    CardsDraw card13 = new CardsDraw("13.jpg" ,0);
    CardsDraw card14 = new CardsDraw("14.jpg" ,150); //gain
    CardsDraw card15 = new CardsDraw("15.jpg"  ,50); //pay 50 for each player
    CardsDraw card16 = new CardsDraw("16.jpg"  ,50); //pay 50 for each player

    public ChanceCards() {
        this.m_chanceCards = new HashMap<Integer,CardsDraw>();
        
        this.m_chanceCards.put(1, card1);
        this.m_chanceCards.put(2, card2);
        this.m_chanceCards.put(3, card3);
        this.m_chanceCards.put(4, card4);
        this.m_chanceCards.put(5, card5);
        this.m_chanceCards.put(6, card6);
        this.m_chanceCards.put(7, card7);
        this.m_chanceCards.put(8, card8);
        this.m_chanceCards.put(9, card9);
        this.m_chanceCards.put(10, card10);
        this.m_chanceCards.put(11, card11);
        this.m_chanceCards.put(12, card12);
        this.m_chanceCards.put(13, card13);
        this.m_chanceCards.put(14, card14);
        this.m_chanceCards.put(15, card15);
        this.m_chanceCards.put(16, card16);
    }
}

class Community_Chest_Draw extends CardsDraw
{
    public Map<Integer , CardsDraw> cardEffect = new HashMap<Integer , CardsDraw>();
    {
    try
    {
      
    CardsDraw card1 = new CardsDraw("ps2cc1.jpg" ,200); // advance to Go and gain 200$
    CardsDraw card2 = new CardsDraw("ps2cc2.jpg" ,200); // gain 200$
    CardsDraw card3 = new CardsDraw("ps2cc3.jpg" ,50);// lose 50$
    CardsDraw card4 = new CardsDraw("ps2cc4.jpg" ,0);// everyone loses 10% of their balance
    CardsDraw card5 = new CardsDraw("ps2cc5.jpg" ,45);// gain 45$
    CardsDraw card6 = new CardsDraw("ps2cc6.jpg" ,0);// get out of jail free card
    CardsDraw card7 = new CardsDraw("ps2cc7.jpg" ,0);// go to jail
    CardsDraw card8 = new CardsDraw("ps2cc8.jpg" ,50);// collect 50$ from every player
    CardsDraw card9 = new CardsDraw("ps2cc9.jpg" ,20);// collect 20$ 
    CardsDraw card10 = new CardsDraw("ps2cc10.jpg" ,100);// collect 100$
    CardsDraw card11 = new CardsDraw("ps2cc11.jpg" ,100); //pay 100
    CardsDraw card12 = new CardsDraw("ps2cc12.jpg" ,25); // get 25$
    CardsDraw card13 = new CardsDraw("ps2cc13.jpg" ,11);// collect 11$
    CardsDraw card14 = new CardsDraw("ps2cc14.jpg" ,100); // get 100$
    CardsDraw card15 = new CardsDraw("ps2cc15.jpg"  ,100); // get 100$
    CardsDraw card16 = new CardsDraw("ps2cc16.jpg"  ,50); //get 50$
  
       
       
       
       
       
       cardEffect.put(1, card1); // advance to Go and gain 200$
       cardEffect.put(2, card2); // gain 200$
       cardEffect.put(3, card3); // lose 50$
       cardEffect.put(4, card4); // everyone loses 10% of their balance
       cardEffect.put(5, card5); // gain 45$
       cardEffect.put(6, card6); // get out of jail free card
       cardEffect.put(7, card7); // go to jail
       cardEffect.put(8, card8); // collect 50$ from every player
       cardEffect.put(9, card9); // collect 20$ 
       cardEffect.put(10, card10); // collect 100$
       cardEffect.put(11, card11); // pay 100$
       cardEffect.put(12, card12); // get 25$
       cardEffect.put(13, card13); // collect 11$
       cardEffect.put(14, card14); // get 100$
       cardEffect.put(15, card15); // get 100$
       cardEffect.put(16, card16); // get 50$
       
    }catch(Exception ex) {  };
    }

    public Map<Integer, CardsDraw> getCardEffect() {
        return cardEffect;
    }

    
    
}



public class Cards extends javax.swing.JFrame {
    
    
    //static CardsDraw frame2 = new CardsDraw();
    /**
     * Creates new form CardsDraws
     */
    public int displayChanceCards() {
        return JOptionPane.showConfirmDialog(null,
                        getChanceCardsPanel(),
                        "Chance Card  ",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
    }

    private JPanel getChanceCardsPanel() {
        JPanel panel = new JPanel();

        ChanceCards chanceCards = new ChanceCards();
        Map<Integer,CardsDraw> tmp = chanceCards.getM_chanceCards();
        Random r = new Random();
        int randomNumber = 1+r.nextInt(16);
        if(randomNumber==3 || randomNumber==5) // chance 3 makes the player advance to St.Charles which is not on our board and chance 5 is the same as chance 4
        {
            randomNumber = 4;
        }
        if(randomNumber == 13 || randomNumber==6) // chance 3 makes the player advance to BoardWalk which is not on our board
        {
            randomNumber = 11;
        }
        ImageIcon image = null;
        Image img = null;
        try {
            File imgFile = new File(tmp.get(randomNumber).getM_imgPath());
            img = ImageIO.read(imgFile);
            panel.setBorder(new LineBorder(Color.black, 10));

        } catch(MalformedURLException mue) {
            mue.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } 
        cardsRandomNumber = randomNumber;

        JLabel label = new JLabel(new ImageIcon(img));
        panel.add(label);

        return panel;
    }
    
    
    
    
    
    
    public void setImage(String path , boolean border){
        JPanel pnl = new JPanel(){
          public void paintComponent(Graphics g){
              Graphics2D g2 = (Graphics2D)g;
              Image img;
              try {
                  img = ImageIO.read(new File(path));
                  g2.drawImage(img, 3, 3, jPanel1.getWidth()-3, jPanel1.getHeight()-3, this);
              } catch (IOException ex) {
                  
              };
              if (border){
                g2.setStroke(new BasicStroke(6));
                g2.drawRect(0, 0, this.getWidth(), this.getHeight());
              }
          }

        };
        //JButton btn = new JButton();
       // this.add(btn);
        this.add(pnl);
        pnl.add(new JLabel("ghghgfh"));

        //this.setVisible(true);

        pnl.setBounds(0, 0, this.getWidth(), this.getHeight());

      //  btn.setBounds(0, 0, 100, 100);

    }
    
    
    
    
    
    
    int cardsRandomNumber;
     public int displayCommunityChestCards() {
       return JOptionPane.showConfirmDialog(null,
                        getCommunityChestCardsPanel(),
                        "Community Chest Card  ",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
    }

    private JPanel getCommunityChestCardsPanel() {
        JPanel panel = new JPanel();

        Community_Chest_Draw communityChestCards = new Community_Chest_Draw();
        Map<Integer,CardsDraw> tmp = communityChestCards.getCardEffect();
        Random r = new Random();
        ImageIcon image = null;
        int randomNumber = 1+r.nextInt(16);
        Image img = null;
        try {
            File imgFile = new File(tmp.get(randomNumber).getM_imgPath());
            img = ImageIO.read(imgFile);
            panel.setBorder(new LineBorder(Color.black, 10));

        } catch(MalformedURLException mue) {
            mue.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } 
        JLabel label = new JLabel(new ImageIcon(img));
        panel.add(label);

        cardsRandomNumber = randomNumber;
        return panel;
    }

    public int ApplyCardEffect(String cardType ,Player player , int playerTurn , PlayerCurrentPostion pos , int numberOfPlayers , Player[] players)
    {
        //cardsRandomNumber = 10;
        if(cardType == "CommunityChest")
        {
            if(cardsRandomNumber == 2)
            {
                player.setM_balance(player.getM_balance()+200);
            }
            else if(cardsRandomNumber == 3)
            {
                player.setM_balance(player.getM_balance()-50);
            }
            else if(cardsRandomNumber == 4)
            {
                int increase = 0;
                for(int i=0; i<numberOfPlayers; i++)
                {
                    if(i!=playerTurn)
                    {
                        int change = (int)Math.round(players[i].getM_balance() *0.1);
                        players[i].setM_balance(players[i].getM_balance() - change);
                        increase+= change;
                    }
                }
                player.setM_balance(player.getM_balance()+increase);
            }
            else if(cardsRandomNumber == 5)
            {
                player.setM_balance(player.getM_balance()+45);
            }
            else if(cardsRandomNumber == 6)
            {
                player.setM_getOutOfJailCards(player.getM_getOutOfJailCards()+1);
            }
            else if(cardsRandomNumber == 8)
            {
                for(int i=0; i<numberOfPlayers; i++)
                {
                    if(i!=playerTurn)
                    {
                        players[i].setM_balance(players[i].getM_balance() - 50);
                    }
                }
                player.setM_balance(player.getM_balance()+(50*(numberOfPlayers-1)));
            }
            else if(cardsRandomNumber == 9)
            {
                player.setM_balance(player.getM_balance()+20);
            }
            else if(cardsRandomNumber == 10)
            {
                player.setM_balance(player.getM_balance()+100);
            }
            else if(cardsRandomNumber == 11)
            {
                player.setM_balance(player.getM_balance()-100);
            }
            else if(cardsRandomNumber == 12)
            {
                player.setM_balance(player.getM_balance()+25);
            }
            else if(cardsRandomNumber == 13)
            {
                player.setM_balance(player.getM_balance()+11);
            }
            else if(cardsRandomNumber == 14)
            {
                player.setM_balance(player.getM_balance()+100);
            }
            else if(cardsRandomNumber == 15)
            {
                player.setM_balance(player.getM_balance()+100);
            }
            else if(cardsRandomNumber == 16)
            {
                player.setM_balance(player.getM_balance()+50);
            }
        }
        else if(cardType == "Chance")
        {
            if(cardsRandomNumber == 7)
            {
                player.setM_balance(player.getM_balance()+50);
            }
            else if(cardsRandomNumber == 8)
            {
                player.setM_getOutOfJailCards(player.getM_getOutOfJailCards()+1);
            }
            else if(cardsRandomNumber == 10)
            {
                int payment = (25 * player.getM_numberOfHouses()) + (100 * player.getM_numberOFHotels());
                player.setM_balance(player.getM_balance() - payment);
            }
            else if(cardsRandomNumber == 11)
            {
                player.setM_balance(player.getM_balance()- 150);
            }
            else if(cardsRandomNumber == 14)
            {
                int payment = (40 * player.getM_numberOfHouses()) + (115 * player.getM_numberOFHotels());
                player.setM_balance(player.getM_balance() - payment);
            }
            else if(cardsRandomNumber == 15)
            {
                player.setM_balance(player.getM_balance()+ 150);
            }
            else if(cardsRandomNumber == 16)
            {
                for(int i=0; i<numberOfPlayers; i++)
                {
                    if(i!=playerTurn)
                    {
                        players[i].setM_balance(players[i].getM_balance() + 50);
                    }
                }
                player.setM_balance(player.getM_balance()-(50*(numberOfPlayers-1)));
            }
        }
        return cardsRandomNumber;
    }
    
    

    /**
     * Creates new form Cards
     */
    public Cards() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        displayCommunityChestCards();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        displayChanceCards();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Cards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
