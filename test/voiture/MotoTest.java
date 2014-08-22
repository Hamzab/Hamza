
package voiture;

import org.junit.Test;
import static org.junit.Assert.*;

public class MotoTest {
    
    public MotoTest() {
    }
    
    @Test
    public void testGetMarque() {
      Vehicule moto = new Moto(1999, "Porsche", "918 Spyder");
       assertEquals("Porsche",moto.getMarque());
    }

 
    @Test
    public void testGetAnnee() {
      Vehicule moto = new Moto(1999, "Porsche", "918 Spyder");
       assertEquals(1999,moto.getAnnee());
    }


    @Test
    public void testGetModele() {
      Vehicule moto = new Moto(1999, "Porsche", "918 Spyder");
       assertEquals("918 Spyder",moto.getModele());
    }


    @Test
    public void testGetValeurInitiale() {
      Vehicule moto = new Moto(1999, "Porsche", "918 Spyder");
       assertEquals(0,moto.getValeurInitiale(),0);
    }


    @Test
    public void testGetCC() {
      Moto moto = new Moto(1999, "Porsche", "918 Spyder");
       assertEquals(0,moto.getCC(),0);
    }


    @Test
    public void testEstExistAnnee() {
    Moto moto = new Moto(1999, "Porsche", "918 Spyder");
    assertEquals(true,moto.estExistAnnee(1999));
    }
 
 
    @Test
    public void testEstExistMarque() {
    Moto moto = new Moto(1999, "Porsche", "918 Spyder");
    assertEquals(true,moto.estExistMarque("Porsche"));
    }


    @Test
    public void testEstExistModele() {
    Moto moto = new Moto(1999, "Porsche", "918 Spyder");
    assertEquals(true,moto.estExistModele("918 Spyder"));
    }

 
    @Test
    public void testEstAssurable() {
    Moto moto = new Moto(1999, "Porsche", "918 Spyder");
    assertEquals(true,moto.estAssurable(1999, "Porsche", "918 Spyder"));
    }
}