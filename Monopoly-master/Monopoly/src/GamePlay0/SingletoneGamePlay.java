
package GamePlay0;

import java.io.IOException;

public class SingletoneGamePlay {
    private static Gameplay singleInstance = null;
    
    private SingletoneGamePlay(){
        
    }
    public static Gameplay getInstance(boolean isPlayAgain) throws IOException{
        if (singleInstance == null || isPlayAgain) 
            singleInstance = new Gameplay();
        
        return singleInstance;
    }

    
    
           
}
