
package audioplayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
/**
 *
 * @author joaovitordeon
 */

 
public class JSONWriter{
        private JSONArray jsonArray = new JSONArray();
        private JSONObject jsonObject = new JSONObject();
         
        private FileWriter writeFile = null;
       
        public JSONWriter(String name,String password,Boolean vip,ArrayList<String> musics ){
        
        //chama uma instancia da classe que le o arquivo JSON
        JSONReader jw = new JSONReader();
        jsonArray = jw.getJSON();
        
        
        jsonObject.put("username", name);
        jsonObject.put("password", password);
        jsonObject.put("VIP",vip);
        jsonObject.put("musics",musics);
        
        //adiciona um JSONObject(usuario) no final
        jsonArray.add(jsonObject);
        
        try{
            writeFile = new FileWriter("saida.json");
            jsonArray.writeJSONString(jsonArray,writeFile);
            writeFile.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
        //System.out.println(jsonObject);
          
    }
 
}
