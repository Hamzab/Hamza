
package voiture;


import org.junit.Test;
import static org.junit.Assert.*;

public class InfoVoitureTest {

    public InfoVoitureTest() {
    }

    @Test
    public void testGetVehicule() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, true);
        assertEquals(v, iv.getVehicule());
    }

    @Test
    public void testGetValeurDesOption() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, true);
        assertEquals(2000, iv.getValeurDesOption(), 0.0);
    }

   
     @Test
     public void testGetBurinage() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, true);
        assertEquals("MAGIC", iv.getBurinage());
     }

     
     @Test
     public void testIsGarageInterieur() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", false, true);
        assertEquals(false, iv.isGarageInterieur());
     }


     @Test
     public void testIsSystemeAlarme() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,false);
        assertEquals(false, iv.isSystemeAlarme());
     }
 
  
     @Test
     public void testGetValeurCC() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,false);
        assertEquals(0, iv.getValeurCC());
     }
 
  
     @Test
     public void testEstAssurableVoiturePlusUnMillion() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,false);
        assertEquals(false, iv.estAssurableVoiturePlusUnMillion(5000000));
     }

  
     @Test
     public void testEstAssurable() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,false);
         assertEquals(false,iv.estAssurable(33, "Porsche", "918 Spyder", 7000));
     }
}