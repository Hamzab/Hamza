/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONEntree;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author Hamza
 */
public class LesDonnes {
    
    public static JSONObject getData() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonData());
        return unObjet;
    }
    public static JSONArray getDataVoitures() throws Exception {
        JSONObject lesDonnees = getData();
        JSONArray lesVoitures=lesDonnees.getJSONArray("voitures");
        return lesVoitures;
    }  
    public static List<String> getModeles() throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVoitures = getDataVoitures();
        for (int i = 0; i < lesVoitures.size(); i++) {
            JSONObject unObjet = lesVoitures.getJSONObject(i);
            String modele = unObjet.getString("modèle");
            uneliste.add(modele);
        }
        return uneliste;
    }
    public static List<String> getMarques() throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVoitures = getDataVoitures();
        for (int i = 0; i < lesVoitures.size(); i++) {
            JSONObject unObjet = lesVoitures.getJSONObject(i);
            String marque = unObjet.getString("marque");
            uneliste.add(marque);
        }
        return uneliste;
    }
    public static List<Integer> getAnnees() throws Exception {
        List<Integer> uneliste = new ArrayList<Integer>();
        JSONArray lesVoitures = getDataVoitures();
        for (int i = 0; i < lesVoitures.size(); i++) {
            JSONObject unObjet = lesVoitures.getJSONObject(i);
            int annee = unObjet.getInt("année");
            uneliste.add(annee);
        }
        return uneliste;
    }
    public static double getValeur(String modele) throws Exception {
        double res = 0.0;
        List<String> uneliste = getModeles();
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesVoitures = getDataVoitures();
            JSONObject unObjet = lesVoitures.getJSONObject(pos);
            res = unObjet.getDouble("valeur_initiale_du_véhicule");
        }
        return res;
    }
}