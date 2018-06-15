/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author victor
 */
public class UserDAO {

    private static final String PATH = "/home/joaovitordeon/NetBeansProjects/Player-MP3-LP-II/src/data/users.json";
    
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

    public static void printUserJson()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray = readUserJson();
        for (Object obj : jsonArray) {
            System.out.println(obj);
            System.out.println("------------------------------------------------------");
        }
    }

    public static void addUser(String username, String password, int vip)
            throws IOException, FileNotFoundException, ParseException {

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

        System.out.println("user to be salved "+jsonObject);
        jarr.add(jsonObject);
        System.out.println(jarr);

        writeFile = new FileWriter(PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
    }
    public static void deleteUser(String username)
            throws IOException, FileNotFoundException, ParseException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jarr;
        jarr = readUserJson();
        FileWriter writeFile=null;

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

}
