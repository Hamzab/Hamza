
package jsonInput;


import org.junit.Test;
import static org.junit.Assert.*;

public class JSONMotosTest {

    public JSONMotosTest() {
    }

    @Test
    public void testGetMotos() {
        JSONMotos jm = new JSONMotos();
        assertEquals(false, jm.getMotos() == null);
    }

    @Test
    public void testGetAnnee() {
        JSONMotos jm = new JSONMotos();
        Integer i = jm.getAnnee(0);
        assertEquals(false, i == null);
    }

    @Test
    public void testGetMarque() {
        JSONMotos jm = new JSONMotos();
        assertEquals(false, jm.getMarque(0) == null);
    }

    @Test
    public void testGetModele() {
        JSONMotos jm = new JSONMotos();
        assertEquals(false, jm.getModele(0) == null);
    }

    @Test
    public void testGetValeurDesOptions() {
        JSONMotos jm = new JSONMotos();
        Double d = jm.getValeurDesOptions(0);
        assertEquals(false, d == null);
    }

    @Test
    public void testGetBuriange() {
        JSONMotos jm = new JSONMotos();
        assertEquals(false, jm.getBuriange(0) == null);
    }

    @Test
    public void testGetGarageInterieur() {
        JSONMotos jm = new JSONMotos();
        Boolean b = jm.getGarageInterieur(0);
        assertEquals(false, b == null);
    }

    @Test
    public void testGetSystemeAlarme() {
        JSONMotos jm = new JSONMotos();
        Boolean b = jm.getSystemeAlarme(0);
        assertEquals(false, b == null);
    }

    @Test
    public void testGetMessagesErreures() {
        JSONMotos jm = new JSONMotos();
        assertEquals(false, jm.getMessagesErreures() == null);
    }
}