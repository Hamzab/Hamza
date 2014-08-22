
package montantDeLaSoumission;


import org.junit.Test;
import static org.junit.Assert.*;


public class MontantSoumissionTest {
    
    public MontantSoumissionTest() {
    }
    
    
    @Test
    public void testGetMontant() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(100.0, m.getMontant(), 0.0);
    }

 
    @Test
    public void testGetPourcentagePourMontantDeBaseHomme() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(0.15, m.getPourcentagePourMontantDeBaseHomme(26), 0.0);
       assertEquals(0.12, m.getPourcentagePourMontantDeBaseHomme(44), 0.0);
       assertEquals(0.135, m.getPourcentagePourMontantDeBaseHomme(70), 0.0);
    }

  
    @Test
    public void testGetPourcentagePourMontantDeBaseFemme() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(0.11, m.getPourcentagePourMontantDeBaseFemme(26), 0.0);
       assertEquals(0.09, m.getPourcentagePourMontantDeBaseFemme(44), 0.0);
       assertEquals(0.155, m.getPourcentagePourMontantDeBaseFemme(70), 0.0);
    }
 
 
    @Test
    public void testGetPourcentagePourMontantDeBase() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(0.15, m.getPourcentagePourMontantDeBase(26, "M", "voiture"), 0.0);
    }
 
    @Test
    public void testCalculerMontantDeBase() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(15, m.calculerMontantDeBase(2,26, "M","voiture"), 0.0);
    }



    @Test
    public void testAjouterValeursDesOptions() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(2010, m.ajouterValeursDesOptions(100, 2000), 0.0);
    }

  
    @Test
    public void testAjouterMontantVille() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(2200, m.ajouterMontantVille("Montréal", 2000), 0.0);
    }

 
    @Test
    public void testRetirerMontantBurinage() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(1750, m.retirerMontantBurinage("Sherlock",2000), 0.0);
    }

  
    @Test
    public void testRetirerMontantGarageInterieur() {
      MontantSoumission m=new MontantSoumission(100);
       assertEquals(1500, m.retirerMontantGarageInterieur(true, 2000), 0.0);
    }


    @Test
    public void testRetirerMontantSystemAlarme() {
      MontantSoumission m=new MontantSoumission(100);
       assertEquals(1500, m.retirerMontantSystemAlarme(true, 2000), 0.0);
    }

   
    @Test
    public void testRetirerMontantCoursCAA() {
      MontantSoumission m=new MontantSoumission(100);
       assertEquals(1900, m.retirerMontantCoursCAA(true, 2000), 0.0);
    }

 
    @Test
    public void testAjouterMontantPremierContrat() {
      MontantSoumission m=new MontantSoumission(100);
       assertEquals(4000, m.ajouterMontantPremierContrat(true, 2000), 0.0);
    }
 
   
    @Test
    public void testRetirerMontantExperience15Ans() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(1600, m.retirerMontantExperience15Ans("1995-11-13", 2000), 0.0);
    }

  
    @Test
    public void testAjouterPuissanceSuperieur1100cc() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(3000, m.ajouterPuissanceSuperieur1100cc(1200, 2000), 0.0);
    }

    
    @Test
    public void testCalculerLeRabaisOrdreIngQuebec() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(900, m.calculerLeRabaisOrdreIngQuebec(true, 1000), 0.0);
    }

  
    @Test
    public void testCalculerLeRabaisDuNovembre() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(900, m.calculerLeRabaisDuNovembre(5, 11,1000), 0.0);
    }

  
    @Test
    public void testCalculerLeRabaisDuFevrier() {
       MontantSoumission m=new MontantSoumission(100);
       assertEquals(950, m.calculerLeRabaisDuFevrier(23, 02,1000), 0.0);
    }
}