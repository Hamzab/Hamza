
package voiture;

import org.junit.Test;
import static org.junit.Assert.*;


public class VoitureTest {
    
    public VoitureTest() {
    }
    
   
    @Test
    public void testGetMarque() {
      Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals("Porsche",voiture.getMarque());
    }

    @Test
    public void testGetAnnee() {
      Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(1999,voiture.getAnnee());
    }


    @Test
    public void testGetModele() {
      Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals("918 Spyder",voiture.getModele());
    }


    @Test
    public void testGetValeurInitiale() {
      Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(0,voiture.getValeurInitiale(),0);
    }




 


    @Test
    public void testEstExistAnnee() {
      Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(true,voiture.estExistAnnee(1999));
    }


    @Test
    public void testEstExistMarque() {
       Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(true,voiture.estExistMarque("Porsche"));
    }


    @Test
    public void testEstExistModele() {
        Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(true,voiture.estExistModele("918 Spyder"));
    }


    @Test
    public void testEstAssurable() {
         Vehicule voiture = new Voiture(1999, "Porsche", "918 Spyder");
       assertEquals(true,voiture.estAssurable(1999, "Porsche", "918 Spyder"));
    }
}