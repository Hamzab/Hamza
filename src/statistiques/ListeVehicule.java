package statistiques;

import Files.FileWriter1;
import jsonInput.JSON_Input;
import jsonInput.JSONMotos;
import jsonInput.JSONVoiture;
import jsonOutput.JSON_Output;
import main.Main;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ListeVehicule {
   static JSONMotos jsonMotos=new JSONMotos();
   static JSONVoiture jsonVoiture=new JSONVoiture();
   public static boolean existeJson(){
       boolean res=true;
       try{
         JSONObject unObjet=new JSONObject();
            unObjet = ( JSONObject) JSONSerializer.toJSON((new JSON_Input()).getJsonListe());  
 
       }catch(Exception e){
           res=false;
       }
      return res;
   }
    public static JSONArray getListe() throws Exception {
        JSONArray uneliste=new JSONArray();
        if(existeJson()){
        JSONObject unObjet = ( JSONObject) JSONSerializer.toJSON((new JSON_Input()).getJsonListe());
        uneliste= unObjet.getJSONArray("assurables");
        }
        return uneliste;
    }

    public static JSONArray getListeAssurableVoiture() throws Exception {
        JSONArray unjson =getListe();
        boolean estAssurable = (new JSON_Input()).getJsonSortie().getBoolean("assurable");;
        if (estAssurable) {
            for (int i = 0; i < jsonVoiture.getVoitures().size(); i++) {
                JSONObject unObjet = new JSONObject();
                unObjet.put("marque", jsonVoiture.getMarque(i));
                unObjet.put("modele", jsonVoiture.getModele(i));
                unObjet.put("annee", jsonVoiture.getAnnee(i));
                unObjet.put("type", "voiture");
                unjson.add(unObjet);
            }
        }
        return unjson;
    }

    public static JSONArray getListeAssurableMoto() throws Exception {
        JSONArray unjson = getListeAssurableVoiture();
        boolean estAssurable =(new JSON_Input()).getJsonSortie().getBoolean("assurable");
        if (estAssurable) {
            for (int i = 0; i < jsonMotos.getMotos().size(); i++) {
                JSONObject unObjet = new JSONObject();
                unObjet.put("marque", jsonMotos.getMarque(i));
                unObjet.put("modele", jsonMotos.getModele(i));
                unObjet.put("annee", jsonMotos.getAnnee(i));
                unObjet.put("type", "moto");
                unjson.add(unObjet);
            }
        }
        return unjson;
    }
    public static JSONArray putListe() throws Exception{
        JSONArray unjson=getListeAssurableMoto();
        return unjson;
    }
    public static JSONObject putObjetJson() throws Exception{
        JSONObject unjson=new JSONObject();
        unjson.put("assurables", putListe());
        if(existeJson()){
             unjson.put("assurables", putListe());
           FileWriter1.ecrire("json/liste.json", unjson);
        }else if(Main.tmp[0].equals("-L")){
            unjson.put("assurables",new JSONArray()); 
            FileWriter1.ecrire("json/liste.json", unjson);
        }
        return unjson;
    }
}
