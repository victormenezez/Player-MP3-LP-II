
package audioplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
/**
 *
 * @author joaovitordeon
 */
public class Musics extends Thread{
    private final String music;
    private AdvancedPlayer player;
 

 
    public Musics(String music) throws Exception{
       
        this.music = music;
    
    }
    
    public void playMusic() throws Exception{

        new Thread() { 
                @Override
                public void run() {  
                    try {                          
                       FileInputStream stream = new FileInputStream(music);
                       player = new AdvancedPlayer(stream);
                       player.play();  
                       player.close();
                        
                    } catch (FileNotFoundException | JavaLayerException e) {  
                    }  
                }  
            }.start();       
    }
    public void stopMusic() throws Exception{
        if (this.player != null) {
            this.player.close();
        }
    }    

}
