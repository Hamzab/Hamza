
package jsonInput;

import main1.Main;
import net.sf.json.JSONObject;

import org.junit.Test;
import static org.junit.Assert.*;


public class JSON_InputTest {
    
    public JSON_InputTest() {
    }
    
   

   

    @Test
    public void testGetJsonData() throws Exception {
        JSON_Input ji = new JSON_Input();
        assertEquals(false,ji.getJsonData()==null);
    }

  
    @Test
    public void testGetJsonStats() {
        JSON_Input ji = new JSON_Input();
        assertEquals(false,ji.getJsonStats()==null);
    }

  
    @Test
    public void testValiderStats() {
       JSON_Input ji = new JSON_Input();
       Boolean b=ji.validerStats();
        assertEquals(false,b==null);
    }


    @Test
    public void testValiderListe() {
       JSON_Input ji = new JSON_Input();
       Boolean b=ji.validerListe();
        assertEquals(false,b==null);
    }

    
    @Test
    public void testGetJsonSortie() throws Exception {
       JSON_Input ji = new JSON_Input();
      JSONObject unObjet = new JSONObject();
        assertEquals(unObjet,ji.getJsonSortie());
    }
}