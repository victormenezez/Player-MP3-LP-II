package audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Classe que implementa as acoes correspondentes ao usuario
 * 
 * @author Joao Vitor
 * @author Victor Gomes
 */
public class UserDAO {

    private static final String PATH = System.getProperty("user.dir") + "/src/data/users.json";
    private static ArrayList<String> playlists;

    /**
     * Adiciona a Playlist criada ao usuario logado.
     *
     * @param username Nome do usuario logado
     * @param playlist_name Nome da playlist criada
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public static void addPlaylistToUser(String username, String playlist_name)
            throws IOException, FileNotFoundException, ParseException {

        //array auxiliar 
        ArrayList<String> aux;

        JSONArray jarr;
        jarr = readUserJson();
        FileWriter writeFile;

        for (int i = 0; i < jarr.size(); i++) {
            JSONObject obj = (JSONObject) jarr.get(i);
            //se possuir aquele username incrementa 
            if (obj.containsValue(username)) {
                jarr.remove(i);
                aux = (ArrayList<String>) obj.get("playlists");
                for (String s : aux) {
                    System.out.println(s);
                }
                aux.add(playlist_name);
                obj.remove("playlists");
                obj.put("playlists", aux);
                jarr.add(i, obj);
                break;
            }
        }
        writeFile = new FileWriter(PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();

    }

    /**
     * Retorna as playlists pertencentes ao usuario
     *
     * @param username Nome do usuario logado
     * @return ArraList de Strings contendo os nomes das playlists
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<String> getPlaylistsNames(String username)
            throws IOException, FileNotFoundException, ParseException {

        ArrayList<String> aux;
        JSONArray jarr;
        jarr = readUserJson();

        for (int i = 0; i < jarr.size(); i++) {
            JSONObject obj = (JSONObject) jarr.get(i);
            //se possuir aquele username incrementa 
            if (obj.containsValue(username)) {
                aux = (ArrayList<String>) obj.get("playlists");
                return aux;
            }
        }
        return null;
    }

    /**
     * Le o arquivo users.json
     *
     * @return Objeto JSONArray contendo todos os usuarios cadastrados
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readUserJson()
            throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(new FileReader(PATH));
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jsonArray;
    }

    /**
     * Imprime no terminal todos os dados de todos os usuarios
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void printUserJson()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray = readUserJson();
        for (Object obj : jsonArray) {
            System.out.println(obj);
            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * Adiciona um novo usuario
     *
     * @param username Nome do usuario a ser criado
     * @param password Senha do usuario a ser criado
     * @param vip 1 se o usuario for VIP e 0 caso nao seja
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void addUser(String username, String password, int vip)
            throws IOException, FileNotFoundException, ParseException {
        //vetor das playlists inicia vazio quando se cria um user
        playlists = new ArrayList<>();

        JSONObject jsonObject = new JSONObject();
        JSONArray jarr;
        jarr = readUserJson();
        FileWriter writeFile;

        for (int i = 0; i < jarr.size(); i++) {
            JSONObject obj = (JSONObject) jarr.get(i);
            //se possuir aquele username incrementa 
            if (obj.containsValue(username)) {
                JOptionPane.showMessageDialog(null, "Este nome de usuário já existe!\nTente outro.", "Usuário existente", INFORMATION_MESSAGE);
                return;
            }
        }

        jsonObject.put("login", username);
        jsonObject.put("password", password);
        jsonObject.put("vip", vip);
        jsonObject.put("playlists", playlists);

        jarr.add(jsonObject);

        writeFile = new FileWriter(PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }

    /**
     * Deleta um usuario cadastrado
     *
     * @param username Nome do usuario a ser deletado
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void deleteUser(String username)
            throws IOException, FileNotFoundException, ParseException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jarr;
        jarr = readUserJson();
        FileWriter writeFile;

        for (int i = 0; i < jarr.size(); i++) {
            JSONObject obj = (JSONObject) jarr.get(i);
            //se possuir aquele username incrementa 
            if (obj.containsValue(username)) {
                jarr.remove(i);
            }
        }

        writeFile = new FileWriter(PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }

    /**
     * Verifica se existe o usuario
     *
     * @param username Nome do usuario a ser verificado
     * @return
     * @throws IOException
     */
    public static boolean hasUser(String username)
            throws IOException {
        try {
            JSONArray jarr = readUserJson();

            for (int i = 0; i < jarr.size(); i++) {
                JSONObject obj = (JSONObject) jarr.get(i);
                //se possuir aquele username incrementa 
                if (obj.containsValue(username)) {
                    JOptionPane.showMessageDialog(null, "Este nome de usuário já existe!\nTente outro.", "Usuário existente", ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
