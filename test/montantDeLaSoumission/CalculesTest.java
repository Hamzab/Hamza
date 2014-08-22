
package montantDeLaSoumission;

import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import org.junit.Test;
import static org.junit.Assert.*;
import voiture.InfoVehicule;
import voiture.InfoVoiture;
import voiture.Vehicule;
import voiture.Voiture;

public class CalculesTest {

    public CalculesTest() {
    }

    @Test
    public void testGetDateFinCours() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, true);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 100);
        assertEquals("1984-02-21", cal.getDateFinCours());
    }

  
     @Test
     public void testGetAge() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, true);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 100);
        assertEquals(20, cal.getAge());
     }


     @Test
     public void testGetSexe() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, true);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 100);
        assertEquals("M", cal.getSexe());
     }


     @Test
     public void testGetDuree() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, true);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 100);
        assertEquals(2, cal.getDuree());
     }
 
     @Test
     public void testEstMemebre_oiq() {
        Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, false);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 100);
        assertEquals(false, cal.estMemebre_oiq());
     }


     @Test
     public void testAppliquer1() {
           Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, false);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 0);
        assertEquals(1200, cal.appliquer("voiture"),0);
     }

 
     @Test
     public void testAppliquer() {
           Vehicule v = new Voiture(1999, "Porsche", "918 Spyder");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true, false);
        Conducteur cond = new Conducteur(20, "Quebec", "Montreal", "M");
        InfoConducteur ic = new InfoConducteur(cond, "1984-02-21", true, true, false);
        Contrat c = new Contrat(2);
        Calcules cal = new Calcules(iv, ic, c, 0);
        System.out.println(cal.appliquer1("voiture"));
        assertEquals(-300, cal.appliquer1("voiture"),0);
     }
}