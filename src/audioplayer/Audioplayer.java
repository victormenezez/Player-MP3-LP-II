package audioplayer;

import java.io.IOException;
import screens.LoginScreen;

/**
 * Classe Main para execucao do projeto
 *
 * @author Joao Vitor
 * @author Victor Gomes
 */
public class Audioplayer {

    public static void main(String[] args)
            throws IOException, Exception {

        LoginScreen login_screen = new LoginScreen();
        login_screen.setVisible(true);

    }
}
