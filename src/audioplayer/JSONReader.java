
package audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
/**
 *
 * @author joaovitordeon
 */
public class JSONReader {
    private JSONObject jsonObject;
    private JSONArray jsonArray;     
    private JSONParser parser = new JSONParser();
   
    
    public JSONReader(){
        
        
        try {  
            jsonArray = (JSONArray) parser.parse(new FileReader(
                    "saida.json"));
          
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
    }
    
    public JSONArray getJSON(){
        return jsonArray;
    };
    
    public void printJSON(){
        for(Object obj : jsonArray){
            System.out.println(obj);
            System.out.println("---------------------------------------------------------------");
        }
    };
    
}
