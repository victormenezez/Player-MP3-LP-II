package audioplayer;

import static audioplayer.Musics.insertMusic;
import static audioplayer.UserDAO.addUser;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import screens.InitialScreen;
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

//        LoginScreen login_screen = new LoginScreen();
//        login_screen.setVisible(true);

        InitialScreen i = new InitialScreen(true, "carlos");
        try {
//            printMusicJson();
//            insertMusic("musica6");
//            printMusicJson();
            addUser("rw","12e",1);
            addUser("rr","12e",1);
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e + " oh");
        }

    }
}
