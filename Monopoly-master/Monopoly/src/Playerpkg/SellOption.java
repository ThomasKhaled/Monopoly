/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Playerpkg;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author lap shop
 */
public class SellOption extends DesitionPanel{
    
    public SellOption(){
        
    }
    public static JPanel getCardInfoPanel(String Path) {
        JPanel panel = new JPanel();

        String path = Path;
        Image img = null;
        try {
            File imgFile = new File(path);
            img = ImageIO.read(imgFile);
            panel.setBorder(new LineBorder(Color.black, 7));

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        JLabel label = new JLabel(new ImageIcon(img));
        panel.add(label);

        return panel;
    }
    
    @Override
    public int displayCardInfo(String Path) {
        UIManager.put("OptionPane.yesButtonText", "Sell constructions"); //0
        UIManager.put("OptionPane.noButtonText", "Sell City"); //1
        UIManager.put("OptionPane.cancelButtonText", "OK");//2
        //  int dialogResult = JOptionPane.showConfirmDialog (null, "","",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE );

        int dialogResult = JOptionPane.showConfirmDialog(null,
                getCardInfoPanel(Path),
                "Card Info  ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        return dialogResult;
    }
    
}
