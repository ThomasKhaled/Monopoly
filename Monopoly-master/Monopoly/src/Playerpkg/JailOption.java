
package Playerpkg;

import GamePlay0.Gameplay;
import GamePlay0.SingletoneGamePlay;
import static Playerpkg.SellOption.getCardInfoPanel;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JailOption extends DesitionPanel{

    private Gameplay g;
    public JailOption() throws IOException{
        g = SingletoneGamePlay.getInstance(false);
    }
    @Override
    public int displayCardInfo(String Path) {
        UIManager.put("OptionPane.cancelButtonText", "Skip Turn");//2
        UIManager.put("OptionPane.noButtonText", "Use Card");//1
        UIManager.put("OptionPane.yesButtonText", "Pay 50$");//0
        //  int dialogResult = JOptionPane.showConfirmDialog (null, "","",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE );
        int input = JOptionPane.showConfirmDialog(g.jailPanel(), "Pay 50$ to get out of jail or Use a \"Get Out of Jail\" card or Skip your turn", "You Are In Jail!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        return input;
    }
    
}
