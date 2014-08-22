
package main1;

import org.junit.Test;
import static org.junit.Assert.*;


public class MainTest {
    
    public MainTest() {
    }
    
  
    @Test
    public void testValiderArgs() {
        Boolean b =  Main.validerArgs(new String[3]);
        assertEquals(false,b ==null);
    }

 
    @Test
    public void testSignerContrat() throws Exception {
        Boolean b=Main.signerContrat("");
         assertEquals(false,b==null);
    }

}