/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONEntree;

import main.Main;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONConducteur {

    public static JSONObject getConducteur() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonInfo());
        JSONObject unConducteur = unObjet.getJSONObject("conducteur");
        return unConducteur;
    }

    public static String getDateDeNaissance() throws Exception {
        return getConducteur().getString("date_de_naissance");
    }

    public static String getProvince() throws Exception {
        return getConducteur().getString("province");
    }

    public static String getVille() throws Exception {
        return getConducteur().getString("ville");
    }

    public static String getSexe() throws Exception {
        return getConducteur().getString("sexe");
    }

    public static String getDateFinCoursDeConduite() throws Exception {
        return getConducteur().getString("date_fin_cours_de_conduite");
    }

    public static boolean estCoursDeConduiteReconnusParCAA() throws Exception {
        return getConducteur().getBoolean("cours_de_conduite_reconnus_par_CAA");
    }

    public static boolean estPermierContrat() throws Exception {
        return getConducteur().getBoolean("premier_contrat");
    }
    public static boolean estMembreOiq() throws Exception{
       return getConducteur().getBoolean("membre_oiq"); 
    }
}
