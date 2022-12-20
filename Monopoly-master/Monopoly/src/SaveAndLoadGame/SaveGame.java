package SaveAndLoadGame;

import Playerpkg.Player;
import Playerpkg.PlayerCurrentPostion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGame {
    private Player []player;
    private int NumofPlayers;
    private PlayerCurrentPostion pos;
    private FileWriter fs;
    private BufferedWriter out;

    public SaveGame(Player[] player, int NumofPlayers, PlayerCurrentPostion pos) throws IOException {
        this.player = player;
        this.NumofPlayers = NumofPlayers;
        this.pos = pos;
        fs = new FileWriter("data.txt");
        out = new BufferedWriter(fs);
    }
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

    public Player[] getPlayer() {
        return player;
    }

    public int getNumofPlayers() {
        return NumofPlayers;
    }

    public PlayerCurrentPostion getPos() {
        return pos;
    }
    
    
}
