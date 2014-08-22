
package jsonOutput;


import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import voiture.InfoVehicule;
import voiture.InfoVoiture;
import voiture.Vehicule;
import voiture.Voiture;


public class JSON_OutputTest {
    
    public JSON_OutputTest() {
    }


    @Test
    public void testGetSizeVehicules() throws Exception {
        JSON_Output jo = new JSON_Output();
        Integer i=jo.getSizeVehicules("voiture");
        assertEquals(false, i==null);
    }

  
    @Test
    public void testEstExistVehicule() throws Exception {
        JSON_Output jo = new JSON_Output();
      Vehicule v = new Voiture(2014, "Porsche", "Boxter");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,false);
        Boolean i=jo.estExistVehicule("voitures",iv);
        assertEquals(true, i);
    }

  
    @Test
    public void testEstAssurableUneVehicule() throws Exception {
        JSON_Output jo = new JSON_Output();
      Vehicule v = new Voiture(2014, "Porsche", "Boxter");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,true);
        Boolean i=jo.estAssurableUneVehicule("voitures",iv);
        assertEquals(true, i);
    }

   
    @Test
    public void testEstAssurablePlusieursVehicules() throws Exception {
        JSON_Output jo = new JSON_Output();
      Vehicule v = new Voiture(2014, "Porsche", "Boxter");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,true);
        List<InfoVehicule> l=new ArrayList<InfoVehicule>();
        l.add(iv);
        Boolean i=jo.estAssurablePlusieursVehicules("voitures", l);
        assertEquals(true,i);
    }
 
   
  @Test
    public void testEstAssurablePlusieursVoitures() throws Exception {
        JSON_Output jo = new JSON_Output();
      Vehicule v = new Voiture(2014, "Porsche", "Boxter");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,true);
        List<InfoVehicule> l=new ArrayList<InfoVehicule>();
        l.add(iv);
        Boolean i=jo.estAssurablePlusieursVoitures();
        assertEquals(false,i==null);
    }

 
   
    @Test
    public void testEstAssurablePlusieursMotos() throws Exception {
        JSON_Output jo = new JSON_Output();
      Vehicule v = new Voiture(2014, "Porsche", "Boxter");
        InfoVehicule iv = new InfoVoiture(v, 2000, 0, "MAGIC", true,true);
        List<InfoVehicule> l=new ArrayList<InfoVehicule>();
        l.add(iv);
        Boolean i=jo.estAssurablePlusieursMotos();
        assertEquals(false,i==null);
    }


  
 @Test
    public void testEstAssurable() throws Exception {
        JSON_Output jo = new JSON_Output();
        Boolean i=jo.estAssurable();
         assertEquals(false,i==null);
    }

     @Test
    public void testGetMessagesAssurable(){
         JSON_Output jo = new JSON_Output();
        assertEquals(false, jo.getMessagesAssurable()==null);
    }


    @Test
    public void testIncrementerNombresSoumissionsAssur() throws Exception {
        boolean estAssurable = false;
        JSON_Output instance = new JSON_Output();
        JSONObject j = new JSONObject();
        j.put("assurable", false);
        j.put("montant_annuel", 0);
        j.put("mensualite", 0);
        assertEquals(j, instance.incrementerNombresSoumissionsAssur(estAssurable));
    }

 
  @Test
    public void testGetResultat() throws Exception {
        JSON_Output jo = new JSON_Output();
         assertEquals(false, jo.getResultat()==null);
    }


    @Test
    public void testRetournerUnJSON() throws Exception {
        JSON_Output jo = new JSON_Output();
        assertEquals(false, jo.retournerUnJSON()==null);
    }

  
    @Test
    public void testGetStats() {
        JSON_Output jo = new JSON_Output();
        assertEquals(false, jo.getStats()==null);
    }
}