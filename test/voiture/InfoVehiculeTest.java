
package voiture;


import org.junit.Test;
import static org.junit.Assert.*;



public class InfoVehiculeTest {
    
    public InfoVehiculeTest() {
    }
    
 
    @Test
    public void testGetValeurDesOption() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(2000, iv.getValeurDesOption(),0);
    }


    @Test
    public void testGetBurinage() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals("burinage", iv.getBurinage());
    }

    
    @Test
    public void testIsGarageInterieur() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(false, iv.isGarageInterieur());
    }

   
    @Test
    public void testIsSystemeAlarme() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(false, iv.isSystemeAlarme());
    }

  
    @Test
    public void testGetValeurCC() {
        InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(1000, iv.getValeurCC());
    }

 
    @Test
    public void testEstAssurableVoiturePlusUnMillion() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(false, iv.estAssurableVoiturePlusUnMillion(10000));
    }

  
    @Test
    public void testEstAssurable() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(false, iv.estAssurable(1989, "marque", "modele",19000));
    }

     
    @Test
    public void testGetVehicule() {
    InfoVehicule iv=new InfoVehiculeImpl();
     assertEquals(null, iv.getVehicule());
    }

    public class InfoVehiculeImpl implements InfoVehicule {

        public double getValeurDesOption() {
            return 2000;
        }

        public String getBurinage() {
            return "burinage";
        }

        public boolean isGarageInterieur() {
            return false;
        }

        public boolean isSystemeAlarme() {
            return false;
        }

        public int getValeurCC() {
            return 1000;
        }

        public boolean estAssurableVoiturePlusUnMillion(double valeur) {
            return false;
        }

        public boolean estAssurable(int annee, String marque, String modele, double valeur) {
            return false;
        }

        public Vehicule getVehicule() {
            return null;
        }
    }
}