package audioplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author joaovitordeon
 */
public class Musics extends Thread {

    private static final String PATH = "/home/victor/NetBeansProjects/Player-MP3-LP-II/src/data/musics.json";
    private final String music;
    private AdvancedPlayer player;

    public Musics(String music) throws Exception {

        this.music = music;

    }

    public static JSONArray readMusicJson()
            throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;

        try {
            obj = parser.parse(new FileReader(PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

//    public static void printMusicJson()
//            throws IOException, FileNotFoundException, ParseException {
//
//        JSONArray jsonArray = null;
//
//        try {
//            JSONObject musics = readMusicJson();
//            jsonArray = (JSONArray) musics.get("musics");
//        } catch (IOException | ParseException e) {
//            System.out.println(e);
//        }
//
//        for (Object obj : jsonArray) {
//            System.out.println(obj);
//            System.out.println("------------------------------------------------------");
//        }
//    }
    public static void insertMusic(String music, String path)
            throws IOException, FileNotFoundException, ParseException {

        JSONArray jarr = readMusicJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;

        System.out.println(jarr.isEmpty());
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(music)) {
                    JOptionPane.showMessageDialog(null, "A música " + music
                            + " já existe na biblioteca", "Erro", INFORMATION_MESSAGE);
                    return;
                }
            }
        }
        
        aux.put(music, path);
        System.out.println(aux);
        jarr.add(aux);
        System.out.println(jarr);
        writeFile = new FileWriter(PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }

//    public static void deleteMusic(String username, String music)
//            throws IOException, FileNotFoundException, ParseException {
//        JSONArray jsonArray;
//        jsonArray = readMusicJson();
//        FileWriter writeFile = null;
//
//        for (int i = 0; i < jsonArray.size(); i++) {
//            //copia do valor do JSONObject do jsonarray
//            JSONObject obj = (JSONObject) jsonArray.get(i);
//
//            if (obj.containsValue(username)) {
//                //atualizar o array de musicas
//                jsonArray.remove(i);
//                ArrayList<String> musicslist = (ArrayList<String>) obj.get("musics");
//                musicslist.remove(music);
//                // atualiza o obj
//                obj.put("musics", musicslist);
//                //atualiza o jsonArray
//                jsonArray.add(i, obj);
//                break;
//            }
//        }
//        //atualiza escrevendo no arquivo json
//        writeFile = new FileWriter("saida.json");
//        jsonArray.writeJSONString(jsonArray, writeFile);
//        writeFile.close();
//
//    }
    public static ArrayList<String> getMusics()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        ArrayList<String> musicslist = new ArrayList<>();

        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);
            musicslist = (ArrayList<String>) jobj.get(i);
        }
        return musicslist;
    }

    public void playMusic() throws Exception {

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

    public void stopMusic() throws Exception {
        if (this.player != null) {
            this.player.close();
        }
    }

}
