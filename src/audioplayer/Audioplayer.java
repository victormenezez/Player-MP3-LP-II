
package audioplayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joaovitordeon
 */
public class Audioplayer {
   
    public static void main(String[] args) throws IOException, Exception {
        //InterfaceGrafica ig= new InterfaceGrafica();
        ArrayList<String> array1= new ArrayList();
        ArrayList<String> array2= new ArrayList();
        
        JSONWriter jw1,jw2;
        
        jw1 = new JSONWriter("joao","123456",true,array1);
        jw2 = new JSONWriter("pedro","654321", false,array2);
        //etc...
            
        JSONReader jr;
        jr = new JSONReader();
        jr.printJSON();
    }
    
}
