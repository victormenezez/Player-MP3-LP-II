
package audioplayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.player.Player;
/**
 *
 * @author joaovitordeon
 */
public class Musics {
    private final File music;
    private Player player;
 
    public Musics(File music) throws Exception{
        this.music = music;
    
    }    
    public void play(){
        try{
            FileInputStream stream = new FileInputStream(music);
            BufferedInputStream buffer = new BufferedInputStream(stream);
            this.player = new Player (buffer);
            System.out.println("Executando...");
            this.player.play();
            System.out.println("Terminado");
        }
        catch (Exception e) {
            System.out.println("Erro!");
            e.printStackTrace();
        }
    }
}
