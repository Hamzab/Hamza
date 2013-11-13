package JSONEntree;

import main.Main;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONConducteur {

    JSONObject unObjet;
    JSONArray messagesErreurs = new JSONArray();
    JSONArray existeConducteur = new JSONArray();

    public JSONConducteur() {
        try {
            unObjet = (JSONObject) JSONSerializer.toJSON((new JSON()).getJsonInfo());
        } catch (Exception e) {
        }
    }

    public JSONObject getConducteur() {
        JSONObject unConducteur = new JSONObject();
        try {
            unConducteur = unObjet.getJSONObject("conducteur");
        } catch (Exception e) {
            existeConducteur.add("Erreur fromat json ,le Conducteur n'existe pas");
        }

        return unConducteur;
    }

    public String getDateDeNaissance() {
        String date = "";
        try {
            date = getConducteur().getString("date_de_naissance");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas la date de naissance");
        }
        return date;
    }

    public String getProvince() {
        String provaince = "";
        try {
            provaince = getConducteur().getString("province");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas la provaince");
        }
        return provaince;
    }

    public String getVille() {
        String ville = "";
        try {
            ville = getConducteur().getString("ville");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas la ville");
        }
        return ville;
    }

    public String getSexe() {
        String sexe = "";
        try {
            sexe = getConducteur().getString("sexe");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas le sexe");
        }
        return sexe;
    }

    public String getDateFinCoursDeConduite() {
        String date = "";
        try {
            date = getConducteur().getString("date_fin_cours_de_conduite");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas la date fin cours conduite");
        }

        return date;
    }

    public boolean estCoursDeConduiteReconnusParCAA() {
        boolean caa = false;
        try {
            caa = getConducteur().getBoolean("cours_de_conduite_reconnus_par_CAA");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas s'il a un cours reconnus par CAA");
        }
        return caa;
    }

    public boolean estPermierContrat() {
        boolean premierContrat = false;
        try {
            premierContrat = getConducteur().getBoolean("premier_contrat");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas si c'est le premier contrat");
        }
        return premierContrat;
    }

    public boolean estMembreOiq() {
        boolean estMembre = false;
        try {
            estMembre = getConducteur().getBoolean("membre_oiq");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le conducteur ne contient pas s'il est membre");
        }
        return estMembre;
    }

    public JSONArray getMessagesErreurs() {
        JSONArray mes = new JSONArray();
        if (existeConducteur.isEmpty()) {
            mes = messagesErreurs;
        } else {
            mes = existeConducteur;
        }
        return mes;
    }
}
