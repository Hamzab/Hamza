
package jsonOutput;

import jsonInput.JSONConducteur;
import jsonInput.JSONContrat;
import jsonInput.JSONMotos;
import jsonInput.JSONVoiture;
import org.junit.Test;
import static org.junit.Assert.*;


public class FormatJSONTest {
    
    public FormatJSONTest() {
    }
    
  
    @Test
    public void testEstRespecterLaNormeISO() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = false;
        boolean result = instance.estRespecterLaNormeISO("");
        assertEquals(expResult, result);

    }


    @Test
    public void testEstValideMoiJour() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.estValideMoiJour(9, 13);
        assertEquals(expResult, result);
    }


    @Test
    public void testVerifierBixetille() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.verifierBixetille(2012, 2, 29);
        assertEquals(expResult, result);
    }


    @Test
    public void testEstValideDate1() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.estValideDate1("2013-02-01");
        assertEquals(expResult, result);
    }


    @Test
    public void testEstValideDate() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.estValideDate("2013-02-01");
        assertEquals(expResult, result);
    }

 
    @Test
    public void testVerifierFormatDate() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.verifierFormatDate("2013-02-01");
        assertEquals(expResult, result);
    }


    @Test
    public void testVerifierLeSexeCond() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.verifierLeSexeCond("F");
        assertEquals(expResult, result);
    }


    @Test
    public void testVerifierDureeContrat() {
        FormatJSON instance =new FormatJSON(null, null, null, null);
        boolean expResult = true;
        boolean result = instance.verifierDureeContrat(2);
        assertEquals(expResult, result);
    }

 
    @Test
    public void testEstValide() {
        FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        Boolean b=fj.estValide();
        assertEquals(false, b==null);
    }


    @Test
    public void testGetMessagesValidation() {
        FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesValidation()==null);
    }


    @Test
    public void testGetMessagesConducteur() {
         FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesConducteur()==null);
    }

    @Test
    public void testGetMessagesContrat() {
         FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesContrat()==null);
    }


    @Test
    public void testGetMessagesMotos() {
         FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesMotos()==null);
    }


    @Test
    public void testGetMessagesVoitures() {
         FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesVoitures()==null);
    }


    @Test
    public void testGetMessagesErreures() {
         FormatJSON fj =new FormatJSON(new JSONConducteur(),new JSONContrat(),new JSONMotos(),new JSONVoiture());
        assertEquals(false, fj.getMessagesErreures()==null);
    }
}