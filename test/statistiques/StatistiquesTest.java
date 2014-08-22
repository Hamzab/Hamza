
package statistiques;

import jsonInput.JSON_Input;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatistiquesTest {
    
    public StatistiquesTest() {
    }
 

  
    @Test
    public void testExisteJson() {
        Statistiques s = new Statistiques();
        Boolean b=s.existeJson();
        assertEquals(false, b==null);
    }

  
    @Test
    public void testGetVehiculeParMarque() {
        Statistiques s = new Statistiques();
        assertEquals(false, s.getVehiculeParMarque()==null);
    }


 
    @Test
    public void testCreerUnJsonStat() throws Exception {
        Statistiques s = new Statistiques();
        assertEquals(false, s.creerUnJsonStat()==null);
    }

  
    @Test
    public void testRetournerMarques() {
        Statistiques s = new Statistiques();
        assertEquals(false, s.retournerMarques(new JSON_Input().getJsonStats())==null);
    }

  
    @Test
    public void testCopier() {
        Statistiques s = new Statistiques();
        assertEquals(false, s.copier()==null);
    }

 
   @Test
    public void testEcrireStats() throws Exception {
        String path = "";
        Statistiques s = new Statistiques();
        Boolean b=s.ecrireStats("");
      assertEquals(false, b==null);
    }
}