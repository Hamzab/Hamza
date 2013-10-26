package JSONEntree;

import static JSONEntree.JSONVoiture.getVoitures;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONMotos {

    public static JSONArray getMotos() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonInfo());
        JSONArray voitures = unObjet.getJSONArray("motos");
        return voitures;
    }

    public static int getAnnee(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getInt("annee");
    }

    public static String getMarque(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("marque");
    }

    public static String getModele(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("modele");
    }

    public static double getValeurDesOptions(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getDouble("valeur_des_options");
    }

    public static String getBuriange(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("burinage");
    }

    public static boolean getGarageInterieur(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("garage_interieur");
    }

    public static boolean getSystemeAlarme(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("systeme_alarme");
    }

    public static boolean getValeurCC(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("systeme_alarme");
    }
}
