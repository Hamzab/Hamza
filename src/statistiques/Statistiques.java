
package statistiques;

import Files.FileWriter1;
import JSONEntree.JSON;
import JSONSortie.UnJSON;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


public class Statistiques {
    private double nombreTotale;
    UnJSON unjson=new UnJSON();
    JSONObject unObjet;
    public Statistiques(){
        unObjet=new JSONObject();
    }
    
       public boolean existeJson(){
       boolean res=true;
       try{
        unObjet = ( JSONObject) JSONSerializer.toJSON((new JSON()).getJsonStats());  
       }catch(Exception e){
           res=false;
       }
      return res;
   }
    public JSONObject creerUnJsonStat() throws IOException, Exception{
       
        if(!existeJson()){
        unObjet.put("nombre_de_soumissions", 0);
        unObjet.put("nombre_de_soumissions_non_assurables",0);
        unObjet.put("nombre_de_soumissions_assurables",0);
        unObjet.put("nombre_de_soumissions_hommes",0);
        unObjet.put("nombre_de_soumissions_femmes",0);
        unObjet.put("nombre_de_vehicules",0);
        unObjet.put("nombre_de_voitures_assurables",0);
        unObjet.put("nombre_de_motos_assurables",0);
        JSONArray unArray=new JSONArray();
        unObjet.put("vehicules_par_marque", unArray);
        
        }else{
            unObjet=unjson.getStats();
        }
        FileWriter1.ecrire("json/stats.json", unObjet);
        return unObjet;
    }
    
}
