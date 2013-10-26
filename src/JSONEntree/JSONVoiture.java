
package JSONEntree;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONVoiture {

    public static JSONArray getVoitures() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonInfo());
        JSONArray voitures = unObjet.getJSONArray("voitures");
        return voitures;
    }

    public static int getAnnee(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getInt("annee"); 
    }

    public static String getMarque(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("marque");
    }

    public static String getModele(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("modele");
    }

    public static double getValeurDesOptions(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getDouble("valeur_des_options");
    }

    public static String getBuriange(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("burinage");
    }

    public static boolean getGarageInterieur(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getBoolean("garage_interieur");
    }

    public static boolean getSystemeAlarme(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getBoolean("systeme_alarme");
    }
}