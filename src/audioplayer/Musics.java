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
 * Classe que implementa as acoes correspondentes as musicas
 * 
 * @author Joao Vitor
 * @author Victor Gomes
 */
public class Musics {

    private static final String MUSICS_PATH = System.getProperty("user.dir") + "/src/data/musics.json";
    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/data/playlists.json";
    private String aux;
    private AdvancedPlayer player;
    private FileInputStream stream;
    private boolean playing = false;
    private boolean paused = false;
    public long duration_song;
    public long pause_position;

    /**
     * Altera o valor da variavel paused
     * 
     * @param b True se estiver pausado e False se não
     */
    public void setPausedStatus(boolean b) {
        this.paused = b;
    }

    /**
     * Identifica o atual valor da variavel paused
     * 
     * @return True se estiver pausada ou False se não
     */
    public boolean getPaused() {
        return this.paused;
    }

    /**
     * Identifica se existe uma musica tocando 
     * 
     * @return True se existir uma musica tocando ou False se não
     */
    public boolean getPlaying() {
        return this.playing;
    }

    /**
     * Insere uma nova playlist no arquivo de playlists
     * 
     * @param name Nome da Playlist a ser criada
     * @param array ArraList de musicas da Playlist
     * @return True se for adicionada com sucesso ou False se não
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static boolean insertPlaylist(String name, ArrayList<String> array)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    JOptionPane.showMessageDialog(null, "A playlist " + name
                            + " já existe na biblioteca", "Erro", INFORMATION_MESSAGE);
                    return false;
                }
            }
        }
        aux.put(name, array);
        jarr.add(aux);
        writeFile = new FileWriter(PLAYLISTS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }

    /**
     * Retorna a playlist requerida
     * 
     * @param name Nome da Playlist
     * @return ArraList de Strings contendo as musicas da playlist
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static ArrayList<String> getPlaylist(String name) 
            throws IOException, FileNotFoundException, ParseException {
        ArrayList<String> array;
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    array = (ArrayList<String>) jobj.get(name);
                    return array;
                }
            }
        }
        return null;
    }

    /**
     * Le o arquivo JSON contendo as playlists
     * 
     * @return Objeto JSONArray das playlist existentes
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException 
     */
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
    /**
     * Le o arquivo JSON contendo as musicas (e seus caminhos) adicionadas no sistema
     * 
     * @return Objeto JSONArray das musicas existentes 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException 
     */
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

    /**
     * Insere uma nova musica no arquivo de musicas
     * 
     * @param music Nome da Musica
     * @param path Caminho da musica
     * @return True se for adicionada com sucesso ou False se não
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static boolean insertMusic(String music, String path)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        System.out.println(jarr.isEmpty());
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(music)) {
                    JOptionPane.showMessageDialog(null, "A música " + music
                            + " já existe na biblioteca", "Erro", INFORMATION_MESSAGE);
                    return false;
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
        return true;
    }

    /**
     * Deleta uma musica do sistema
     * 
     * @param musicname Nome da musica a ser deletada
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static void deleteMusic(String musicname)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readMusicJson();
        FileWriter writeFile;
        if (!jsonArray.isEmpty()) {
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

    /**
     * Retorna todas as musicas (sem os seus respectivos caminhos) cadastradas no sistema
     * 
     * @return ArrayList
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public static ArrayList<String> getMusics()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        ArrayList<String> musicslist = new ArrayList<>();
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);
            Set<String> s = jobj.keySet();
            musicslist.add(s.toString().substring(1, s.toString().length() - 1));
        }
        return musicslist;
    }

    /**
     * Inicia a execucao de uma musica
     * 
     * @param music Nome da musica a ser tocada
     * @throws Exception 
     */
    public void playMusic(String music) throws Exception {
        if (playing == false) {
            try {
                JSONArray jarr = readMusicJson();
                String way = null;
                for (int i = 0; i < jarr.size(); i++) {
                    JSONObject jobj = (JSONObject) jarr.get(i);
                    if (jobj.containsKey(music)) {
                        way = jobj.get(music).toString();
                    }
                }
                System.out.println("caminho da musica " + way);
                aux = way;
                stream = new FileInputStream(way);
                player = new AdvancedPlayer(stream);
                // duraçao total da musica
                duration_song = stream.available();
            } catch (FileNotFoundException | JavaLayerException e) {
                System.out.println(e);
            }
            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();

                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            this.playing = true;
        }
    }

    /**
     * Para a execucao de uma musica
     * 
     * @throws Exception 
     */
    public void stopMusic() throws Exception {
        if (this.player != null && playing == true) {
            this.player.close();
            this.duration_song = 0;
            this.pause_position = 0;
            this.playing = false;
        }
    }

    /**
     * Executa a musica a partir de onde foi pausada
     * 
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws IOException 
     */
    public void resumeMusic() throws FileNotFoundException, JavaLayerException, IOException {
        if (this.player != null && paused == true) {
            stream = new FileInputStream(aux);
            stream.skip(duration_song - pause_position);
            player = new AdvancedPlayer(stream);
            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            this.playing = true;
        }
    }

    /**
     * Pausa a musica tocando
     * 
     * @throws IOException 
     */
    public void pauseMusic() throws IOException {
        if (this.player != null && playing == true) {
            pause_position = stream.available();
            this.player.close();
            this.setPausedStatus(true);
        }
    }
}
