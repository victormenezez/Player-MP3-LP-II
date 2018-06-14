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

//    public static ArrayList<String> getMusics(String username)
//            throws IOException, FileNotFoundException, ParseException {
//        JSONArray jsonArray;
//        jsonArray = readJson();
//
//        for (int i = 0; i < jsonArray.size(); i++) {
//            //copia do valor do JSONObject do jsonarray
//            JSONObject obj = (JSONObject) jsonArray.get(i);
//
//            if (obj.containsValue(username)) {
//                ArrayList<String> musicslist = (ArrayList<String>) obj.get("musics");
//                return musicslist;
//
//            }
//
//        }
//        //se nao achar o username retorna lista vazia
//        return null;
//    }
//    
    public static void main(String[] args)
            throws IOException, Exception {
//        ArrayList<String> array = new ArrayList();

        //System.out.println( writeJSON("pedro","112233",false,array) );
//        InterfaceGrafica ig = new InterfaceGrafica();;
//        LoginScreen login_screen = new LoginScreen();
//        login_screen.setVisible(true);
        //writeJSON("pedro","114569",false,array);
        try {
            printMusicJson();
            insertMusic("musica6");
//            printMusicJson();
        } catch (IOException | NullPointerException | ParseException e) {;
            System.out.println(e+" oh");
        }

    }
}
