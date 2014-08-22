
package statistiques;

import net.sf.json.JSONObject;

import org.junit.Test;
import static org.junit.Assert.*;


public class ListeVehiculeTest {
    
    public ListeVehiculeTest() {
    }
    
   
    @Test
    public void testAjouterVehicule() {
        String marque = "";
        String modele = "";
        int annee = 0;
        String type = "";
        ListeVehicule l = new ListeVehicule();
        JSONObject result = l.ajouterVehicule(marque, modele, annee, type);
        assertEquals(false, result==null);
    }


    @Test
    public void testGetListeVehicules() throws Exception {
        ListeVehicule l = new ListeVehicule();
        assertEquals(false,l.getListeVehicules("voitures")==null);

    }


    @Test
    public void testGetListe() throws Exception {
        ListeVehicule l = new ListeVehicule();
        assertEquals(false,l.getListe()==null);
    }


    @Test
    public void testGetListeTriee() throws Exception {
        ListeVehicule l = new ListeVehicule();
        assertEquals(false,l.getListeTriee()==null);
    }


    @Test
    public void testEcrireListe() throws Exception {
           ListeVehicule l = new ListeVehicule();
           assertEquals(false,l.ecrireListe(null));
           assertEquals(true,l.ecrireListe(""));
    }
}