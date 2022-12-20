
package SaveAndLoadGame;

import Playerpkg.Player;
import Playerpkg.PlayerCurrentPostion;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;


public class LoadGame {
    private Player []player;
    private int NumofPlayers;
    private PlayerCurrentPostion pos;
    private FileReader fr;
    private BufferedReader br;

    public LoadGame(Player[] player, int NumofPlayers) throws FileNotFoundException {
        this.player = player;
        this.NumofPlayers = NumofPlayers;
        fr = new FileReader("data.txt");
        br = new BufferedReader(fr);
    }
    /*
    public void SaveToFile() throws IOException{
        
        for (int i=0;i<player.length;i++){
            out.write(String.valueOf(player[i].getM_id())+"\n");
         
            out.write(String.valueOf(player[i].getM_color())+"\n");
        
            out.write(String.valueOf(pos.getCurrentPos(i))+"\n"); //******postion
            out.write(String.valueOf(player[i].getM_balance())+"\n");
            
            out.write(String.valueOf(player[i].isM_inJail())+"\n");
            out.write(String.valueOf(player[i].getM_getOutOfJailCards())+"\n");
            String ZonedOwned = "";
            for (int j=0;j<player[i].getM_zonesOwnedIndexes().size();j++){
                ZonedOwned+=(String.valueOf(player[i].getM_zonesOwnedIndexes().get(j))+",");
            }
            out.write(ZonedOwned+"\n");
            

            out.write(String.valueOf(player[i].getM_numberOfHouses())+"\n");
            out.write(String.valueOf(player[i].getM_numberOFHotels())+"\n");
            out.write(String.valueOf(player[i].getInJail())+"\n");
            out.write(String.valueOf(player[i].getM_railRoadsBought())+"\n");
            out.write(String.valueOf(player[i].isM_isBankrupted())+"\n");
            out.write(String.valueOf(player[i].isM_isWinner())+"\n");
            
            out.write(String.valueOf(player[i].isM_isWinner())+"\n");
            out.write("\n");
            
            
        }
        out.close();
    }
    */
    public void Load() throws IOException{
        for (int i=0;i<6;i++){
            player[i] = new Player();
        }
        
        
        
        
        int i=0;
        Color []c = new Color[6];
        c[0] = Color.BLUE;
        c[1] = Color.RED;
        c[2] = Color.DARK_GRAY;
        c[3] = Color.GREEN;
        c[4] = Color.PINK;
        c[5] = Color.YELLOW;
       
            
        
        
        while (br.readLine()!=null){
            player[i].setM_id(Integer.valueOf(br.readLine()));     
            player[i].setM_color(c[i]);
            //pos.SetPlayer(()Integer.valueOf(br.readLine()));   
            
            i++;
            if (br.readLine()== null) break;
        }
        
    }
    
    
}
