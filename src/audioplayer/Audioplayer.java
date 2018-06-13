package audioplayer;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import screens.InitialScreen;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

    public static JSONArray readJson()
            throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
//        URL url = getResource("/home/victor/NetBeansProjects/Player-MP3-LP-II/src/data/users.json");
        try {
            jsonArray = (JSONArray) parser.parse(new FileReader("/home/victor/NetBeansProjects/Player-MP3-LP-II/src/data/users.json"));
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e + "  jsiad");
        }
        return jsonArray;

    }

    ;
    
    public static void printJson()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray = readJson();
        for (Object obj : jsonArray) {
            System.out.println(obj);
            System.out.println("------------------------------------------------------");
        }
    }

    ;
    
    public static String writeJson(String username, String password, Boolean vip, ArrayList<String> musics)
            throws IOException, FileNotFoundException, ParseException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;
        jsonArray = readJson();
        FileWriter writeFile = null;
        ArrayList<String> musicslist = musics;
        int count = 0;

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            //se possuir aquele username incrementa 
            if (obj.containsValue(username)) {
                count++;
            }

        }
        //se ja possuir aquele username nao entra aqui
        if (count == 0) {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            jsonObject.put("VIP", vip);
            jsonObject.put("musics", musics);

            jsonArray.add(jsonObject);

            writeFile = new FileWriter("saida.json");
            jsonArray.writeJSONString(jsonArray, writeFile);
            writeFile.close();

            return "Escrita realizada com sucesso";
        } else {
            return "Nome de usuario já cadastrado...Tente outro...";
        }

    }

    ;
    
    public static void insertMusic(String name, String music)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readJson();
        FileWriter writeFile = null;

        for (int i = 0; i < jsonArray.size(); i++) {
            //copia do valor do JSONObject do jsonarray
            JSONObject obj = (JSONObject) jsonArray.get(i);

            if (obj.containsValue(name)) {
                //atualizar o array de musicas
                jsonArray.remove(i);
                ArrayList<String> musicslist = (ArrayList<String>) obj.get("musics");
                musicslist.add(music);
                // atualiza o obj
                obj.put("musics", musicslist);
                //atualiza o jsonArray
                jsonArray.add(i, obj);
                break;
            }
        }
        //atualiza escrevendo no arquivo json
        writeFile = new FileWriter("saida.json");
        jsonArray.writeJSONString(jsonArray, writeFile);
        writeFile.close();

    }

    ;
    
    public static ArrayList<String> getMusics(String username)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readJson();

        for (int i = 0; i < jsonArray.size(); i++) {
            //copia do valor do JSONObject do jsonarray
            JSONObject obj = (JSONObject) jsonArray.get(i);

            if (obj.containsValue(username)) {
                ArrayList<String> musicslist = (ArrayList<String>) obj.get("musics");
                return musicslist;

            }

        }
        //se nao achar o username retorna lista vazia
        return null;
    }

    ;
    
    public static void deleteMusic(String username, String music)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readJson();
        FileWriter writeFile = null;

        for (int i = 0; i < jsonArray.size(); i++) {
            //copia do valor do JSONObject do jsonarray
            JSONObject obj = (JSONObject) jsonArray.get(i);

            if (obj.containsValue(username)) {
                //atualizar o array de musicas
                jsonArray.remove(i);
                ArrayList<String> musicslist = (ArrayList<String>) obj.get("musics");
                musicslist.remove(music);
                // atualiza o obj
                obj.put("musics", musicslist);
                //atualiza o jsonArray
                jsonArray.add(i, obj);
                break;
            }
        }
        //atualiza escrevendo no arquivo json
        writeFile = new FileWriter("saida.json");
        jsonArray.writeJSONString(jsonArray, writeFile);
        writeFile.close();

    }

    ;
    
    public static boolean login(String login_screen, String psw_screen) {
        JSONArray users_list;

        return false;
    }

    public static void main(String[] args)
            throws IOException, Exception {
        ArrayList<String> array = new ArrayList();

        //System.out.println( writeJSON("pedro","112233",false,array) );
//        InterfaceGrafica ig = new InterfaceGrafica();;
        LoginScreen login_screen = new LoginScreen();
        login_screen.setVisible(true);
        //writeJSON("pedro","114569",false,array);

        printJson();
    }

}
