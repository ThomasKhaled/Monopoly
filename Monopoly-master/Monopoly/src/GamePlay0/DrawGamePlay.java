package GamePlay0;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;


public class DrawGamePlay {

    //Gameplay game = new Gameplay();
    
    Gameplay g ;
    
    public void DrawGamePlay(boolean bought , Color color) throws IOException{      
        
        g = SingletoneGamePlay.getInstance(false);
        
        g.getGo().setImage("src/Gameplay/img/go.png", true,bought ,color);
        
        g.getJail().setImage("src/Gameplay/img/jail.png", true,bought ,color);
        
        g.getParking().setImage("src/Gameplay/img/free-parking.png", true,bought ,color);
        g.getGoToJail().setImage("src/Gameplay/img/go-to-jail.png", true,bought ,color);
        g.getMarvinGardens().setImage("src/Gameplay/img/Untitled-15.png", true,bought ,color);
        g.getWaterWorks().setImage("src/Gameplay/img/Untitled-114.png", true,bought ,color);
        g.getVentnor().setImage("src/Gameplay/img/Untitled-16.png", true,bought ,color);
        g.getAtlantic().setImage("src/Gameplay/img/Untitled-17.png", true,bought ,color);
        g.getRailRoad().setImage("src/Gameplay/img/Untitled-21.png", true,bought ,color);
        g.getIllinois().setImage("src/Gameplay/img/Untitled-18.png", true,bought ,color);
        g.getIndiana().setImage("src/Gameplay/img/Untitled-19.png", true,bought ,color);
        g.getChanceBlue().setImage("src/Gameplay/img/chance blue.png", true,bought ,color);
        g.getKentucky().setImage("src/Gameplay/img/20.png", true,bought ,color);
        g.getMediter_Ranean().setImage("src/Gameplay/img/Untitled-1.png", true,bought ,color);
        g.getCommunity_Chest().setImage("src/Gameplay/img/community-chest.png", true,bought ,color);
        g.getBaltic().setImage("src/Gameplay/img/Untitled-2.png", true,bought ,color);
        g.getIncomeTax().setImage("src/Gameplay/img/24.png", true,bought ,color);
        g.getRealRoad().setImage("src/Gameplay/img/Untitled-21.png", true,bought ,color);
        g.getOriental().setImage("src/Gameplay/img/Untitled-3.png", true,bought ,color);
        g.getChanceRed().setImage("src/Gameplay/img/chance-red.png", true,bought ,color);
        g.getVermont().setImage("src/Gameplay/img/Untitled-4.png", true,bought ,color);
        g.getConnecticut().setImage("src/Gameplay/img/Untitled-5.png", true,bought ,color);
        g.getPacific().setImage("src/Gameplay/img/Untitled-12.png", true,bought ,color);
        g.getNorthCaro().setImage("src/Gameplay/img/Untitled-13.png", true,bought ,color);
        g.getCommuntityChestRight().setImage("src/Gameplay/img/community-chest-left.png", true,bought ,color);
        g.getPennsy().setImage("src/Gameplay/img/Untitled-14.png", true,bought ,color);
        g.getShorLline().setImage("src/Gameplay/img/Untitled-121.png", true,bought ,color);
        g.getOrangeChance().setImage("src/Gameplay/img/chance-orange.png", true,bought ,color);
        g.getParkPlace().setImage("src/Gameplay/img/Untitled-PR.png", true,bought ,color);
        g.getNewYork().setImage("src/Gameplay/img/Untitled-11.png", true,bought ,color);
        g.getTenss().setImage("src/Gameplay/img/Untitled-10.png", true,bought ,color);
        g.getCCT().setImage("src/Gameplay/img/community-chest-right.png", true,bought ,color);
        g.getStJames().setImage("src/Gameplay/img/Untitled-9.png", true,bought ,color);
        g.getPennsyl().setImage("src/Gameplay/img/PENS.png", true,bought ,color);
        g.getVirginnia().setImage("src/Gameplay/img/Untitled-8.png", true,bought ,color);
        g.getStates().setImage("src/Gameplay/img/Untitled-7.png", true,bought ,color);
        g.getMONOMAN().setImage("src/Gameplay/img/monoMan.png", false,bought ,color);
        g.getOrange().setImage("src/Gameplay/img/orange-CHANCE.png", false,bought ,color);
        g.getBluetreasure().setImage("src/Gameplay/img/treasure.png", false,bought ,color);
        
    }
 
}
