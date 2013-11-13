package JSONEntree;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONContrat {
    JSONObject unObjet;
    JSONArray liste=new JSONArray();
    public JSONContrat(){
        try{
        unObjet = (JSONObject) JSONSerializer.toJSON((new JSON()).getJsonInfo());
        }catch(Exception e){
            
        }
    }
    public int getDureeContrat()  {
        int duree=0;
        try{
          duree=unObjet.getInt("duree_contrat");  
        }catch(Exception e){
            liste.add("Erreur fromat json ,ce json n'a pas duree contrat");
        }
        return duree;
    }
    public String getDateDebut(){
        String dateDebut="";
        try{
         dateDebut= unObjet.getString("date_debut"); 
        }catch(Exception e){
          liste.add("Erreur fromat json ,ce json n'a pas date debut");
        }
        return dateDebut;
    }
    public JSONArray getMessagesErreurs(){
        return liste;
    }
}
