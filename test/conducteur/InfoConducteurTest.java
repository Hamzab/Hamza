
package conducteur;

import org.junit.*;
import static org.junit.Assert.*;

public class InfoConducteurTest {
    
    public InfoConducteurTest() {
    }

    @Test
    public void testGetConducteur() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
      InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,true,true);
      assertEquals(c, ic.getConducteur());
    }

   @Test
    public void testGetDateFinCoursDeConduite() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,true,true);
       assertEquals("1984-02-21", ic.getDateFinCoursDeConduite());
    }


    @Test
    public void testEstReconnusParCAA_0args() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",false,true,true);
       assertEquals(false, ic.estReconnusParCAA());
    }


    @Test
    public void testIsPremierContrat() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,false,true);
       assertEquals(false, ic.isPremierContrat());
    }

   
    @Test
    public void testSetConducteur() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,true,false);
       Conducteur c2=new Conducteur(25, "Ontario", "Toronto", "F");
       ic.setConducteur(c2);
       assertEquals(c2, ic.getConducteur());
    }

    @Test
    public void testSetDateFinCoursDeConduite() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,false,true);
       ic.setDateFinCoursDeConduite("2000-06-29");
       assertEquals("2000-06-29", ic.getDateFinCoursDeConduite());
    }


    @Test
    public void testEstReconnusParCAA_boolean() {
       Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,true,false);
       assertEquals(true, ic.estReconnusParCAA);
    }

    @Test
    public void testSetPremierContrat() {
          Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,false,true);
       ic.setPremierContrat(true);
       assertEquals(true, ic.isPremierContrat());
    }

    @Test
    public void testEstUnMembre_oiq() {
          Conducteur c=new Conducteur(20, "Quebec", "Montreal", "M");
       InfoConducteur ic=new InfoConducteur(c, "1984-02-21",true,true,false);
       assertEquals(false, ic.estUnMembre_oiq());
    }
}
