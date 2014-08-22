
package dateContrat;

import org.junit.Test;
import static org.junit.Assert.*;

public class Date1Test {
    
    public Date1Test() {
    }
    
 
   
    @Test
    public void testGetAnneeDeNaissance() {
     Date1 date=new Date1("2013-11-30");
     assertEquals(2013, date.getAnneeDeNaissance());
    }

  
    @Test
    public void testGetMoisDeNaissance() {
     Date1 date=new Date1("2013-11-30");
     assertEquals(11, date.getMoisDeNaissance());
    }

    
    @Test
    public void testGetJourDeNaissance() {
     Date1 date=new Date1("2013-11-30");
     assertEquals(30, date.getJourDeNaissance());
    }

   
    @Test
    public void testGetParametreDeDate() {
     Date1 date=new Date1("2000-11-30");
     date.getParametreDeDate();
     assertEquals(13, date.getAnnees());
    }


    @Test
    public void testGetAnnees() {
     Date1 date=new Date1("2000-11-30");
     date.getParametreDeDate();
     assertEquals(13, date.getAnnees());
     Date1 date2=new Date1("2000-12-31");
     date2.getParametreDeDate();
     assertEquals(12, date2.getAnnees());
    }

}