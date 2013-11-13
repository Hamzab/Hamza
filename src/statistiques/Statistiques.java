
package statistiques;

import Files.FileWriter1;
import jsonInput.JSON_Input;
import jsonOutput.JSON_Output;
import java.io.IOException;
import main.Main;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


public class Statistiques {
    private double nombreTotale;
    JSON_Output unjson=new JSON_Output();
    JSON_Input jsonin=new JSON_Input();
    JSONObject unObjet;
    public Statistiques(){
        unObjet=new JSONObject();
    }
    
       public boolean existeJson(){
       boolean res=true;
       try{
        if(jsonin.validerStats()){
        unObjet = ( JSONObject) JSONSerializer.toJSON(jsonin.getJsonStats());  
        }else{
          res=false;  
        }
       }catch(Exception e){
           res=false;
       }
      return res;
   }
    public JSONArray getVehiculeParMarque(){
        JSONObject o[]=new JSONObject[4];
        JSONArray tab=new JSONArray();
          for(int i=0;i<4;i++){
           o[i]=new JSONObject(); 
        }
        o[0].put("marque", "Porsche");
        o[0].put("nombre",0);
        o[1].put("marque", "Maserati");
        o[1].put("nombre",0);
        o[2].put("marque","Ferrari");
        o[2].put("nombre",0);
        o[3].put("marque","Ducati");
        o[3].put("nombre",0);
        for(int i=0;i<4;i++){
           tab.add(o[i]); 
        }
        return tab;
    }
            
    public JSONObject creerUnJsonStat() throws IOException, Exception{   
        unObjet.put("nombre_de_soumissions", 0);                      
        unObjet.put("nombre_de_soumissions_non_assurables",0);
        unObjet.put("nombre_de_soumissions_assurables",0);
        unObjet.put("nombre_de_soumissions_hommes",0);
        unObjet.put("nombre_de_soumissions_femmes",0);
        unObjet.put("nombre_de_vehicules",0);
        unObjet.put("nombre_de_voitures_assurables",0);
        unObjet.put("nombre_de_motos_assurables",0);     
        unObjet.put("vehicules_par_marque", getVehiculeParMarque());
        FileWriter1.ecrire("json/stats.json", unObjet);

            unObjet=unjson.getStats();
       
         FileWriter1.ecrire("json/stats.json", unObjet);
        
        
        return unObjet;
    }
    
}
