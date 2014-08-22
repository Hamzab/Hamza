package conducteur;

import net.sf.json.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;

public class ConducteurTest {

    public ConducteurTest() {
    }

    @Test
    public void getAgeTest() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals(20, c.getAge());
    }

    @Test
    public void testGetProvince() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals("Quebec", c.getProvince());
    }

    @Test
    public void testGetVille() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals("Montreal", c.getVille());
    }

    @Test
    public void testGetSexe() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals("M", c.getSexe());

    }

    @Test
    public void testSetAge() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        c.setAge(30);
        assertEquals(30, c.getAge());
    }

    @Test
    public void testSetProvince() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        c.setProvince("Ontario");
        assertEquals("Ontario", c.getProvince());
    }

    @Test
    public void testSetVille() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        c.setVille("Toronto");
        assertEquals("Toronto", c.getVille());
    }

    @Test
    public void testSetSexe() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        c.setSexe("F");
        assertEquals("F", c.getSexe());
    }

    @Test
    public void testEstResideAuQuebec() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        Conducteur c2 = new Conducteur(20, "Québec", "Montreal", "M");
        assertEquals(true, c2.estResideAuQuebec());
    }

    @Test
    public void testEstUnHommeMoins25() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals(true, c.estUnHommeMoins25());
    }

    @Test
    public void testEstUneFemmeMoins21() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        Conducteur c2 = new Conducteur(20, "Quebec", "Montreal", "F");
        assertEquals(false, c.estUneFemmeMoins21());
        assertEquals(true, c2.estUneFemmeMoins21());
    }

    @Test
    public void testEstUnePersonnePlus75() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        Conducteur c2 = new Conducteur(76, "Quebec", "Montreal", "M");
        assertEquals(true, c2.estUnePersonnePlus75());
    }

    @Test
    public void testEstAssurable() {
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        assertEquals(false, c.estAssurable());
    }

    @Test
    public void testGetMessageAssurableAge() {
        JSONArray messages = new JSONArray(), messages2 = new JSONArray(),messages3 = new JSONArray();
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        messages.add("Le conducteure est un homme a " + c.getAge() + ", il est moin de 25 ans");
        Conducteur c2 = new Conducteur(20, "Quebec", "Montreal", "F");
        messages2.add("Le conducteure est une femme a " + c2.getAge() + ", elle est moin de 21 ans");
        Conducteur c3 = new Conducteur(76, "Quebec", "Montreal", "M");
        messages3.add("Le conducteure est une personne a " + c3.getAge() + ", il est plus de 75 ans");
        assertEquals(messages, c.getMessageAssurableAge());
        assertEquals(messages2, c2.getMessageAssurableAge());
        assertEquals(messages3, c3.getMessageAssurableAge());
    }

    @Test
    public void testGetMessageAssurable() {
        JSONArray messages = new JSONArray();
        Conducteur c = new Conducteur(20, "Quebec", "Montreal", "M");
        messages.add("Le conducteure est un homme a " + c.getAge() + ", il est moin de 25 ans");
        messages.add("Le conducteure est une personne reside à " + c.getProvince() + ", il ne reside pas au Quebec");
        assertEquals(messages, c.getMessageAssurable());
    }
}