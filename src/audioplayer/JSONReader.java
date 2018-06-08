
package audioplayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author joaovitordeon
 */
public class JSONReader {
    public JSONReader(){
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        String nome;
        String sobrenome;
        String estado;
        String pais;
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "saida.json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            nome = (String) jsonObject.get("nome");
            sobrenome = (String) jsonObject.get("sobrenome");
            estado = (String) jsonObject.get("estado");
            pais = (String) jsonObject.get("pais");
 
            System.out.println(nome);
            System.out.println(sobrenome);
            System.out.println(estado);
            System.out.println(pais);
            
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
