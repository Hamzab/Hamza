
package jsonInput;


import org.junit.Test;
import static org.junit.Assert.*;

public class JSONVoitureTest {
    
    public JSONVoitureTest() {
    }
  
    @Test
    public void testGetVoitures() {
        JSONVoiture jv= new JSONVoiture();
        assertEquals(false, jv.getVoitures()==null);       
    }


    @Test
    public void testGetAnnee() {
        JSONVoiture jv= new JSONVoiture();
        Integer i=jv.getAnnee(0);
        assertEquals(false,i==null); 
    }


    @Test
    public void testGetMarque() {
        JSONVoiture jv= new JSONVoiture();
        assertEquals(false, jv.getMarque(0)==null);  
    }


    @Test
    public void testGetModele() {
        JSONVoiture jv= new JSONVoiture();
        assertEquals(false, jv.getModele(0)==null); 
    }


    @Test
    public void testGetValeurDesOptions() {
        JSONVoiture jv= new JSONVoiture();     
        Double d=jv.getValeurDesOptions(0);
        assertEquals(false,d==null); 
    }

 
    @Test
    public void testGetBuriange() {
        JSONVoiture jv= new JSONVoiture();
        assertEquals(false, jv.getBuriange(0)==null); 
    }

 
    @Test
    public void testGetGarageInterieur() {
        JSONVoiture jv= new JSONVoiture();
        Boolean b=jv.getGarageInterieur(0);
        assertEquals(false, b==null); 
    }

 
    @Test
    public void testGetSystemeAlarme() {
        JSONVoiture jv= new JSONVoiture();
        Boolean b=jv.getSystemeAlarme(0);
        assertEquals(false, b==null); 
    }


    @Test
    public void testGetMessagesErreures() {
       JSONVoiture jv= new JSONVoiture();
        assertEquals(false, jv.getMessagesErreures()==null); 
    }
}