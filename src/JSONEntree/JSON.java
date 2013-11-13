package JSONEntree;

import Files.FileReader;
import main.Main;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSON {
   static boolean estValide;
   public JSON(){
       
   }
    public String getJsonInfo() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString(Main.tmp[0], "UTF-8");//Main.tmp[0]
        return jsonTxt;
    }

    public String getJsonData() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("json/vehicules.json", "UTF-8");
        return jsonTxt;
    }

    public String getJsonListe() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("json/liste.json", "UTF-8");
        return jsonTxt;
    }
   public  JSONObject getJsonStats() {
       JSONObject unObjet = new JSONObject();
       try{
         estValide=true;
         
        String jsonTxt = FileReader.loadFileIntoString("json/stats.json", "UTF-8");
         unObjet = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        
       }catch(Exception e){
            estValide=false;
       }
        return unObjet;
    }
   
   public  boolean validerFichier(){
       return estValide;
   }
   public  JSONObject getJsonSortie() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("json/sortie1.json", "UTF-8");
         JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        return unObjet;
    }
}
