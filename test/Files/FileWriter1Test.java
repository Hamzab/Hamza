
package Files;


import org.junit.Test;
import static org.junit.Assert.*;


public class FileWriter1Test {
    
    public FileWriter1Test() {
    }
    
  
    @Test
    public void testEcrire() throws Exception {
        assertEquals(false, FileWriter1.ecrire("",null));

    }
}