package statistiques;

import Files.FileWriter1;
import java.io.IOException;
import jsonInput.Donnes;
import jsonInput.JSONMotos;
import jsonInput.JSONVoiture;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListeVehicule {
   public  ListeVehicule(){
       
   }
    static JSONMotos jsonMotos = new JSONMotos();
    static JSONVoiture jsonVoiture = new JSONVoiture();


    public JSONObject ajouterVehicule(String marque,String modele,int annee,String type){
        JSONObject jo=new JSONObject();
        jo.put("marque",marque);
        jo.put("modele", modele);
        jo.put("annee",annee);
        jo.put("type",type);        
        return jo;
    }
    public  JSONArray getListeVehicules(String type) throws Exception {
        JSONArray uneliste = new JSONArray();
        Donnes d=new Donnes();
       JSONArray voitures= d.getDataVihecules(type);       
            for(int i=0;i<voitures.size();i++){
              String marque= d.getMarques(type).get(i); 
              String modele= d.getModeles(type).get(i);
              int annee= d.getAnnees(type).get(i);
              uneliste.add(ajouterVehicule(marque,modele,annee,type));
            }
        return uneliste;
    }
   public JSONObject getListe() throws Exception{
      JSONArray liste =getListeVehicules("voitures");
      JSONArray listeTmp=getListeVehicules("motos"); 
      JSONObject jo=new JSONObject();
      for(int i=0;i<listeTmp.size();i++){
          liste.add(listeTmp.get(i));
      }
      jo.put("assurables",liste);
      return jo;
   }
      public  void ecrireListe(String path) throws IOException, Exception {
        JSONObject ob =getListe();
        FileWriter1.ecrire(path, ob);
    }         
}
