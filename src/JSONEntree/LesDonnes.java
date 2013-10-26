package JSONEntree;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class LesDonnes {

    public static JSONObject getData() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonData());
        return unObjet;
    }

    public static JSONArray getDataVihecules(String typeVihecule) throws Exception {
        JSONObject lesDonnees = getData();
        JSONArray lesVihecules = lesDonnees.getJSONArray(typeVihecule);
        return lesVihecules;
    }

    public static List<String> getModeles(String typeVihecule) throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjet = lesVihecules.getJSONObject(i);
            String modele = unObjet.getString("modèle");
            uneliste.add(modele);
        }
        return uneliste;
    }

    public static List<String> getMarques(String typeVihecule) throws Exception {
        List<String> uneliste = new ArrayList<String>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjet = lesVihecules.getJSONObject(i);
            String marque = unObjet.getString("marque");
            uneliste.add(marque);
        }
        return uneliste;
    }

    public static List<Integer> getAnnees(String typeVihecule) throws Exception {
        List<Integer> uneliste = new ArrayList<Integer>();
        JSONArray lesVihecules = getDataVihecules(typeVihecule);;
        for (int i = 0; i < lesVihecules.size(); i++) {
            JSONObject unObjet = lesVihecules.getJSONObject(i);
            int annee = unObjet.getInt("année");
            uneliste.add(annee);
        }
        return uneliste;
    }

    public static double getValeur(String modele, String typeVihecule) throws Exception {
        double res = 0.0;
        List<String> uneliste = getModeles(typeVihecule);
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesVoitures = getDataVihecules(typeVihecule);;
            JSONObject unObjet = lesVoitures.getJSONObject(pos);
            res = unObjet.getDouble("valeur_initiale_du_véhicule");
        }
        return res;
    }

    public static int getValeurCC(String modele) throws Exception {
        int res = 0;
        List<String> uneliste = getModeles("motos");
        if (uneliste.contains(modele)) {
            int pos = uneliste.indexOf(modele);
            JSONArray lesVoitures = getDataVihecules("motos");;
            JSONObject unObjet = lesVoitures.getJSONObject(pos);
            res = unObjet.getInt("CC");
        }
        return res;
    }
}