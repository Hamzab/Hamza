
package JSONEntree;

import Files.FileReader;
import main.Main;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONVoiture {

    public static JSONObject getVoiture() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonInfo());
        JSONObject uneVoiture = unObjet.getJSONObject("voiture");
        return uneVoiture;
    }

    public static int getAnnee() throws Exception {
        return getVoiture().getInt("annee");
    }

    public static String getMarque() throws Exception {
        return getVoiture().getString("marque");
    }

    public static String getModele() throws Exception {
        return getVoiture().getString("modele");
    }

    public static double getValeurDesOptions() throws Exception {
        return getVoiture().getDouble("valeur_des_options");
    }

    public static String getBuriange() throws Exception {
        return getVoiture().getString("burinage");
    }

    public static boolean getGarageInterieur() throws Exception {
        return getVoiture().getBoolean("garage_interieur");
    }

    public static boolean getSystemeAlarme() throws Exception {
        return getVoiture().getBoolean("systeme_alarme");
    }
}