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

    public static JSONArray getData() throws Exception {
        JSONArray unArray = (JSONArray) JSONSerializer.toJSON(JSON.getJsonData());
        return unArray;
    }

    public static List<String> getModeles() throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesDonnees = getData();
        for (int i = 0; i < lesDonnees.size(); i++) {
            JSONObject unObjet = lesDonnees.getJSONObject(i);
            String modele = unObjet.getString("modèle");
            uneliste.add(modele);
        }
        return uneliste;
    }

    public static double getValeur(String modele) throws Exception {
        double res = 0.0;
        List<String> uneliste = getModeles();
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesDonnees = getData();
            JSONObject unObjet = lesDonnees.getJSONObject(pos);
            res = unObjet.getDouble("valeur_initiale_du_véhicule");
        }
        return res;
    }
}