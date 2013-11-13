package statistiques;

import Files.FileWriter1;
import jsonInput.JSON_Input;
import jsonOutput.JSON_Output;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Statistiques {

    JSON_Output unjson = new JSON_Output();
    JSON_Input jsonin = new JSON_Input();
    JSONObject unObjet;

    public Statistiques() {
        unObjet = new JSONObject();
    }

    public boolean existeJson() {
        boolean res = true;
        try {
            if (jsonin.validerStats()) {
                unObjet = (JSONObject) JSONSerializer.toJSON(jsonin.getJsonStats());
            } else {
                res = false;
            }
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public void initialiserNombresMarques(JSONObject o[]) {
        o[0].put("marque", "Porsche");
        o[0].put("nombre", 0);
        o[1].put("marque", "Maserati");
        o[1].put("nombre", 0);
        o[2].put("marque", "Ferrari");
        o[2].put("nombre", 0);
        o[3].put("marque", "Ducati");
        o[3].put("nombre", 0);
    }

    public JSONArray getVehiculeParMarque() {
        JSONObject o[] = new JSONObject[4];
        JSONArray tab = new JSONArray();
        for (int i = 0; i < 4; i++) {
            o[i] = new JSONObject();
        }
        initialiserNombresMarques(o);
        for (int i = 0; i < 4; i++) {
            tab.add(o[i]);
        }
        return tab;
    }

    public void initialiserStatistiques() {
        unObjet.put("nombre_de_soumissions", 0);
        unObjet.put("nombre_de_soumissions_non_assurables", 0);
        unObjet.put("nombre_de_soumissions_assurables", 0);
        unObjet.put("nombre_de_soumissions_hommes", 0);
        unObjet.put("nombre_de_soumissions_femmes", 0);
        unObjet.put("nombre_de_vehicules", 0);
        unObjet.put("nombre_de_voitures_assurables", 0);
        unObjet.put("nombre_de_motos_assurables", 0);
        unObjet.put("vehicules_par_marque", getVehiculeParMarque());
    }

    public JSONObject creerUnJsonStat() throws IOException, Exception {
        initialiserStatistiques();
        unObjet = unjson.getStats();
        FileWriter1.ecrire("json/tmpstats.json", unObjet);
        return unObjet;
    }

    public JSONArray retournerMarques(JSONObject ob) {
        JSONArray tab = ob.getJSONArray("vehicules_par_marque");
        JSONArray tab2 = new JSONArray();
        for (int i = 0; i < tab.size(); i++) {
            JSONObject ob1 = tab.getJSONObject(i);
            if (ob1.getInt("nombre") != 0) {
                tab2.add(ob1);
            }
        }
        return tab2;
    }

    public JSONObject copier() {
        JSONObject ob = new JSON_Input().getJsonStats(),ob1 = new JSONObject();
        ob1.put("nombre_de_soumissions", ob.getInt("nombre_de_soumissions"));
        ob1.put("nombre_de_soumissions_non_assurables", ob.getInt("nombre_de_soumissions_non_assurables"));
        ob1.put("nombre_de_soumissions_assurables",ob.getInt("nombre_de_soumissions_assurables"));
        ob1.put("nombre_de_soumissions_hommes", ob.getInt("nombre_de_soumissions_hommes"));
        ob1.put("nombre_de_soumissions_femmes", ob.getInt("nombre_de_soumissions_femmes"));
        ob1.put("nombre_de_vehicules", ob.getInt("nombre_de_vehicules"));
        ob1.put("nombre_de_voitures_assurables", ob.getInt("nombre_de_voitures_assurables"));
        ob1.put("nombre_de_motos_assurables", ob.getInt("nombre_de_motos_assurables"));
        ob1.put("vehicules_par_marque", retournerMarques(ob));
        return ob1;
    }

    public void ecrireStats(String path) throws IOException, Exception {
        JSONObject ob =new JSONObject();
        try {
            ob =copier(); 
            FileWriter1.ecrire(path, ob);
        } catch (Exception e) {
        }
        if (ob.isEmpty()) {
            FileWriter1.ecrire(path, creerUnJsonStat());
        }
    }
}
