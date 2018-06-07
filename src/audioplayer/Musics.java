
package audioplayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 *
 * @author joaovitordeon
 */
public class Musics extends Thread{
    private final File music;
    private Player player;
 
    public Musics(File music) throws Exception{
        this.music = music;
    
    }    
    public void play() throws Exception{
        
        FileInputStream stream = new FileInputStream(music);
        BufferedInputStream buffer = new BufferedInputStream(stream);
        this.player = new Player (buffer);
        System.out.println("Tocando musica...");
        this.player.play();
        System.out.println("Musica terminada...");
       
    }
}
