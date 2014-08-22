
package Files;


import org.junit.Test;
import static org.junit.Assert.*;


public class FileReaderTest {
    
    public FileReaderTest() {
    }
    
 
    @Test
    public void testLoadFileIntoString() {
     assertEquals("", FileReader.loadFileIntoString("", "UTF8"));
    }
}