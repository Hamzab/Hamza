package contrat;


import org.junit.Test;
import static org.junit.Assert.*;

public class ContratTest {

    public ContratTest() {
    }

    @Test
    public void testGetDureeContrat() {
        Contrat c = new Contrat(2);
        assertEquals(2, c.getDureeContrat());
    }

   
     @Test
     public void testGetJourDebut() {
       Contrat c =new Contrat(2, 3,11);
       assertEquals(3, c.getJourDebut());
     }


     @Test
     public void testGetMoisDebut() {
       Contrat c =new Contrat(2, 3,11);
       assertEquals(11, c.getMoisDebut());
     }


     @Test
     public void testVerifierDureeContrat() {
                Contrat c =new Contrat(2, 3,11);
       assertEquals(true, c.verifierDureeContrat());
  
     }
}