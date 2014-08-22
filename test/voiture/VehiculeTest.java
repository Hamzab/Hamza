
package voiture;
import org.junit.Test;
import static org.junit.Assert.*;


public class VehiculeTest {
    
    public VehiculeTest() {
    }
    
 
  
    @Test
    public void testGetMarque() {
   Vehicule vi=new VehiculeImpl();
    assertEquals("marque", vi.getMarque());
    }

 
   @Test
    public void testGetAnnee() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(1999, vi.getAnnee());
    }

 
    @Test
    public void testGetModele() {
    Vehicule vi=new VehiculeImpl();
    assertEquals("modele", vi.getModele());
    }

 
    @Test
    public void testGetValeurInitiale() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(0.0, vi.getValeurInitiale(),0);
    }

      
    @Test
    public void testEstExistAnnee() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(false, vi.estExistAnnee(1989));
    }

  
    @Test
    public void testEstExistMarque() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(false, vi.estExistMarque("marque"));
    }

  
    @Test
    public void testEstExistModele() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(false, vi.estExistModele("modele"));
    }


    @Test
    public void testEstAssurable() {
    Vehicule vi=new VehiculeImpl();
    assertEquals(false, vi.estAssurable(1989, "marque", "modele"));
    }

    public class VehiculeImpl implements Vehicule {

        public String getMarque() {
            return "marque";
        }

        public int getAnnee() {
            return 1999;
        }

        public String getModele() {
            return "modele";
        }

        public double getValeurInitiale() {
            return 0.0;
        }

        public boolean estExistAnnee(int annee) {
            return false;
        }

        public boolean estExistMarque(String marque) {
            return false;
        }

        public boolean estExistModele(String modele) {
            return false;
        }

        public boolean estAssurable(int annee, String marque, String modele) {
            return false;
        }
    }
}