
package jsonInput;

import org.junit.Test;
import static org.junit.Assert.*;

public class JSONContratTest {
    
    public JSONContratTest() {
    }
    

    @Test
    public void testGetDureeContrat() {
     JSONContrat jc=new JSONContrat();
     Integer i=jc.getDureeContrat();
     assertEquals(false,i==null);
    }

   
    @Test
    public void testGetDateDebut() {
     JSONContrat jc=new JSONContrat();
     assertEquals(false,jc.getDateDebut()==null);
    }

  
    @Test
    public void testGetMessagesErreurs() {
     JSONContrat jc=new JSONContrat();
     assertEquals(false,jc.getMessagesErreurs()==null);
    }
}