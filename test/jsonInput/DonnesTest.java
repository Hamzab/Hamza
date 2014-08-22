
package jsonInput;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import org.junit.Test;
import static org.junit.Assert.*;


public class DonnesTest {
    
    public DonnesTest() {
    }

    String motos="[{\"année\":2013,\"marque\":\"Ducati\",\"modèle\":\"Diavel Dark\",\"CC\":1198.4,\"valeur_initiale_du_véhicule\":19000},{\"année\":2013,\"marque\":\"Ducati\",\"modèle\":\"Hypermotard SP\",\"CC\":821.1,\"valeur_initiale_du_véhicule\":16000},{\"année\":2013,\"marque\":\"Ducati\",\"modèle\":\"Monster 1100 Evo\",\"CC\":1078,\"valeur_initiale_du_véhicule\":13500},{\"année\":2013,\"marque\":\"Ducati\",\"modèle\":\"Streetfighter 848\",\"CC\":849,\"valeur_initiale_du_véhicule\":14300},{\"année\":2013,\"marque\":\"Ducati\",\"modèle\":\"Superbike 1199 Panigale R\",\"CC\":1198,\"valeur_initiale_du_véhicule\":32000}]";
    String modeles[]={"Diavel Dark","Hypermotard SP","Monster 1100 Evo","Streetfighter 848","Superbike 1199 Panigale R"};
    String marques[]={"Ducati", "Ducati", "Ducati", "Ducati", "Ducati"};
 /**   @Test
    public void testGetData() throws Exception {
     
    }*/

    @Test
    public void testGetDataVihecules() throws Exception {
     Donnes d=new Donnes();
     JSONArray ja = (JSONArray) JSONSerializer.toJSON((motos));
     assertEquals(ja, d.getDataVihecules("motos"));
    }


   
    @Test
    public void testGetModeles() throws Exception {
     Donnes d=new Donnes();  
    List<String> l=new ArrayList<String>();
     for(int i=0;i<modeles.length;i++){
        l.add(modeles[i]);
     }
     assertEquals(l, d.getModeles("motos"));
    }
  
   
    @Test
    public void testGetMarques() throws Exception {
     Donnes d=new Donnes();  
    List<String> l=new ArrayList<String>();
     for(int i=0;i<marques.length;i++){
        l.add(marques[i]);
     }
     assertEquals(l, d.getMarques("motos"));
    }

  
    @Test
    public void testGetAnnees() throws Exception {
     Donnes d=new Donnes();  
    List<Integer> l=new ArrayList<Integer>();
     for(int i=0;i<marques.length;i++){
        l.add(2013);
     }
     assertEquals(l, d.getAnnees("motos"));
    }

  
    @Test
    public void testGetValeur() throws Exception {   
     Donnes d=new Donnes();  
     assertEquals(13500.0, d.getValeur("Monster 1100 Evo", "motos"),0);
    }

   
    @Test
    public void testGetValeurCC() throws Exception {      
     Donnes d=new Donnes();  
     assertEquals(1078, d.getValeurCC("Monster 1100 Evo"));
    }
}