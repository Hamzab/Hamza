
package jsonInput;

import org.junit.Test;
import static org.junit.Assert.*;


public class JSONConducteurTest {
    
    public JSONConducteurTest() {
    }
    
    @Test
    public void testGetConducteur() {
     JSONConducteur jc=new JSONConducteur();
     assertEquals(false, jc.getConducteur()==null);
    }

  
    @Test
    public void testGetDateDeNaissance() {
      JSONConducteur jc=new JSONConducteur();
     assertEquals(false, jc.getDateDeNaissance()==null);
    }

   
    @Test
    public void testGetProvince() {
      JSONConducteur jc=new JSONConducteur();
       assertEquals(false, jc.getProvince()==null);
    }

   
    @Test
    public void testGetVille() {
       JSONConducteur jc=new JSONConducteur();
       assertEquals(false, jc.getVille()==null);
    }

  
    @Test
    public void testGetSexe() {
       JSONConducteur jc=new JSONConducteur();
       assertEquals(false, jc.getSexe()==null);
    }

  
    @Test
    public void testGetDateFinCoursDeConduite() {
       JSONConducteur jc=new JSONConducteur();
       assertEquals(false, jc.getDateDeNaissance()==null);
    }
}