package GamePlay0;
import java.io.*;
import sun.audio.*;

public class SoundEffects {
    public static void PlaySound(String Path) throws IOException{

            InputStream in = new FileInputStream(Path);
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
    }
}
