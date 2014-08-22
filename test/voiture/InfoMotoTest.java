
package voiture;


import org.junit.Test;
import static org.junit.Assert.*;


public class InfoMotoTest {

    public InfoMotoTest() {
    }

    @Test
    public void testGetVehicule() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC", true, true);
        assertEquals(moto,im.getVehicule());
    }
  
     @Test
     public void testGetValeurDesOption() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC", true, true);
        assertEquals(2000,im.getValeurDesOption(),0);
     }
  

     @Test
     public void testGetValeurCC() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC", true, true);
        assertEquals(100,im.getValeurCC());
     }
 
 
     @Test
     public void testGetBurinage() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC", true, true);
        assertEquals("MAGIC",im.getBurinage());
     }

   
     @Test
     public void testIsGarageInterieur() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC",false, true);
        assertEquals(false,im.isGarageInterieur());
     }

    
     @Test
     public void testIsSystemeAlarme() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC",true, false);
        assertEquals(false,im.isSystemeAlarme());
     }


     @Test
     public void testEstAssurableVoiturePlusUnMillion() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC",true, false);
        assertEquals(false,im.estAssurableVoiturePlusUnMillion(5000000));
     }

   
     @Test
     public void testEstAssurable() {
        Vehicule moto = new Moto(19, "Porsche", "918 Spyder");
        InfoMoto im = new InfoMoto(moto, 2000, 100, "MAGIC",true, false);
        assertEquals(false,im.estAssurable(33, "Porsche", "918 Spyder", 7000));
        assertEquals(true,im.estAssurable(19, "Porsche", "918 Spyder", 7000));
     }
}