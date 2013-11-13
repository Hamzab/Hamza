package jsonInput;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Donnes {
    JSONObject unObjet;
    public Donnes(){
        try{
      unObjet = (JSONObject) JSONSerializer.toJSON((new JSON_Input()).getJsonData()); 
        }catch(Exception e){
            
        }
    }
    public JSONObject getData() throws Exception {      
        return unObjet;
    }

    public  JSONArray getDataVihecules(String typeVihecule) throws Exception {
        JSONObject lesDonnees = getData();
        JSONArray lesVihecules = lesDonnees.getJSONArray(typeVihecule);
        return lesVihecules;
    }

    public  List<String> getModeles(String typeVihecule) throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjetv = lesVihecules.getJSONObject(i);
            String modele = unObjetv.getString("modèle");
            uneliste.add(modele);
        }
        return uneliste;
    }

    public  List<String> getMarques(String typeVihecule) throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjetv = lesVihecules.getJSONObject(i);
            String marque = unObjetv.getString("marque");
            uneliste.add(marque);
        }
        return uneliste;
    }

    public List<Integer> getAnnees(String typeVihecule) throws Exception {
        List<Integer> uneliste = new ArrayList<Integer>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);;
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjetv = lesVihecules.getJSONObject(i);
            int annee = unObjetv.getInt("année");
            uneliste.add(annee);
        }
        return uneliste;
    }

    public  double getValeur(String modele, String typeVihecule) throws Exception {
        double res = 0.0;
        List<String> uneliste = getModeles(typeVihecule);
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesVoitures = getDataVihecules(typeVihecule);;
            JSONObject unObjetv = lesVoitures.getJSONObject(pos);
            res = unObjetv.getDouble("valeur_initiale_du_véhicule");
        }
        return res;
    }

    public  int getValeurCC(String modele) throws Exception {
        int res = 0;
        List<String> uneliste = getModeles("motos");
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesVoitures = getDataVihecules("motos");;
            JSONObject unObjetv = lesVoitures.getJSONObject(pos);
            res = unObjetv.getInt("CC");
        }
        return res;
    }
}