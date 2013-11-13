package jsonInput;

import Files.FileReader;
import main.Main;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSON_Input {

    static boolean estValideStats;
    static boolean estValideListe;
    public JSON_Input() {
    }

    public String getJsonInfo() throws Exception {
        String jsonTxt ="";
        if(!(Main.tmp[0].equals("-L")) && !(Main.tmp[0].equals("-S"))){
                jsonTxt =FileReader.loadFileIntoString(Main.tmp[0], "UTF-8");//Main.tmp[0]
        }
        return jsonTxt;
    }

    public String getJsonData() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("json/vehicules.json", "UTF-8");
        return jsonTxt;
    }

    public String getJsonListe()  {
        String jsonTxt ="";
      try{
         jsonTxt = FileReader.loadFileIntoString("json/liste.json", "UTF-8");
         estValideListe=true;
      }catch(Exception e){
          estValideListe=false;
      }

        return jsonTxt;
    }

    public JSONObject getJsonStats() {
        JSONObject unObjet = new JSONObject();
        try {
            estValideStats = true;

            String jsonTxt = FileReader.loadFileIntoString("json/stats.json", "UTF-8");
            unObjet = (JSONObject) JSONSerializer.toJSON(jsonTxt);


        } catch (Exception e) {
            estValideStats = false;
                
        }
        return unObjet;
    }

    public boolean validerStats() {
        return estValideStats ;
    }
    public boolean validerListe(){
        return estValideListe;
    }
    public JSONObject getJsonSortie() throws Exception {
        String jsonTxt = FileReader.loadFileIntoString("json/sortie1.json", "UTF-8");
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        return unObjet;
    }
}
