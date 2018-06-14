package audioplayer;

import static audioplayer.Musics.insertMusic;
import static audioplayer.Musics.printMusicJson;
import static audioplayer.Musics.readMusicJson;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import screens.LoginScreen;

/**
 *
 * /**
 *
 * @author joaovitordeon
 */
public class Audioplayer {
    
    public static void main(String[] args)
            throws IOException, Exception {

        LoginScreen login_screen = new LoginScreen();
        login_screen.setVisible(true);

        try {
            printMusicJson();
            insertMusic("musica6");
            printMusicJson();
        } catch (IOException | NullPointerException | ParseException e) {;
            System.out.println(e+" oh");
        }

    }
}
