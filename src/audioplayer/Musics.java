package audioplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class Musics{

    private static String MUSICS_PATH;
    private static String PLAYLISTS_PATH;
    private AdvancedPlayer player;
    private boolean playing=false;
   
    public Musics(){
        this.MUSICS_PATH= "/home/joaovitordeon/NetBeansProjects/Player-MP3-LP-II/src/data/musics.json";
        this.PLAYLISTS_PATH= "/home/joaovitordeon/NetBeansProjects/Player-MP3-LP-II/src/data/playlists.json";
    }
    
    //---------------------------------------------------------------------------------------------------
    public static void insertPlaylist(String name, ArrayList<String> array)
            throws IOException, FileNotFoundException, ParseException {

        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;

        //System.out.println(jarr.isEmpty());
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    JOptionPane.showMessageDialog(null, "A playlist " + name
                            + " já existe na biblioteca", "Erro", INFORMATION_MESSAGE);
                    return;
                }
            }
        }
        
        aux.put(name, array);
        jarr.add(aux);
        writeFile = new FileWriter(PLAYLISTS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }
    
    public ArrayList<String> getPlaylist(String name) throws IOException, FileNotFoundException, ParseException{
        
        ArrayList<String> array;
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    array = new ArrayList<String>();
                    array = (ArrayList<String>) jobj.get(name);
                    return array;
                }
            }
        }
        return null;
    
    }
    
    public static JSONArray readPlaylistJson()
            throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;

        try {
            obj = parser.parse(new FileReader(PLAYLISTS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

    //---------------------------------------------------------------------------------------------------- 
    public static JSONArray readMusicJson()
            throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;

        try {
            obj = parser.parse(new FileReader(MUSICS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

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
        writeFile = new FileWriter(MUSICS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }
   public static void deleteMusic(String musicname)
           throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readMusicJson();
        FileWriter writeFile = null;
        
        if(!jsonArray.isEmpty()){
            for (int i = 0; i < jsonArray.size(); i++) {
                //copia do valor do JSONObject do jsonarray
                JSONObject obj = (JSONObject) jsonArray.get(i);

                if (obj.containsKey(musicname)) {
                    //atualizar o array de musicas
                    jsonArray.remove(i);
                    break;
                }
            }
            //atualiza escrevendo no arquivo json
            writeFile = new FileWriter(MUSICS_PATH);
            JSONArray.writeJSONString(jsonArray, writeFile);
            writeFile.close();
        }    

    }
   
    public static ArrayList<String> getMusics()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        ArrayList<String> musicslist = new ArrayList<>();

        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);
            Set<String> s = jobj.keySet();
            musicslist.add(s.toString().substring(1, s.toString().length()-1) );
        }
        return musicslist;
    }
    //--------------------------------------------------------------------------------------------------
    public void playMusic(String music) throws Exception { 
        if(playing != true){
            try {
                String way ="/home/joaovitordeon/NetBeansProjects/Player-MP3-LP-II/src/"+music;
                FileInputStream stream = new FileInputStream(way);
                player = new AdvancedPlayer(stream);

            } catch (FileNotFoundException | JavaLayerException e) {
            } 
        
            new Thread(){
                private boolean playing;
                @Override
                public void run(){
                    try {
                        player.play();

                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
            this.playing=true;
        }
       
    }

    public void stopMusic() throws Exception {
        if (this.player != null && playing==true) {
            this.player.close();
            this.playing=false;
            
        }
    }

}
