package Playerpkg;

import Playerpkg.Player;

public class PlayerCurrentPostion {
    private int Zone_Index;
    private String []Zones;
    private static int []currentPos;
    
    public PlayerCurrentPostion(){
        Zones = new String[36];
        currentPos = new int[6];
        Zones[0] = "111111";
        for (int i=1;i<36 ;i++){
            Zones[i] = "000000";
        }
        for (int i=0;i<6;i++){
            currentPos[i] = 0;
        }
        
    }
    //player id is a number from 0 to 5
    public void SetPlayer(int playerID , int NumOfSteps){
        String currpos = Zones[currentPos[playerID]];
        char []chCurrrent = currpos.toCharArray();
        chCurrrent[playerID] = '0';
        Zones[currentPos[playerID]] = String.valueOf(chCurrrent);
        String nextpos = Zones[(NumOfSteps + currentPos[playerID])%36];
        char []chNext = nextpos.toCharArray();
        chNext[playerID] = '1';
        
        Zones[(NumOfSteps + currentPos[playerID])%36] = String.valueOf(chNext);
        currentPos[playerID] = (NumOfSteps + currentPos[playerID])%36;
    }

    public int getCurrentPos(int playerID) {
        return currentPos[playerID];    
    }

    Object getCurrentPos(Player p0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
