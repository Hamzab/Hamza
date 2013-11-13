package jsonInput;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONMotos {

    JSONObject unObjet;
    JSONArray messagesErreurs = new JSONArray();
    JSONArray existeMotos = new JSONArray();

    public JSONMotos() {
        try {
            unObjet = (JSONObject) JSONSerializer.toJSON((new JSON_Input()).getJsonInfo());
        } catch (Exception e) {
        }
    }

    public JSONArray getMotos() {
        JSONArray voitures = new JSONArray();
        try {
            voitures = unObjet.getJSONArray("motos");
        } catch (Exception e) {
            if (existeMotos.isEmpty()) {
                existeMotos.add("Erreur fromat json ,les motos n'existent pas");
            }
        }
        return voitures;
    }

    public int getAnnee(int indice) {
        int annee = 0;
        try {
            annee = getMotos().getJSONObject(indice).getInt("annee");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas l'annee");
        }
        return annee;
    }

    public String getMarque(int indice) {
        String marque = "";
        try {
            marque = getMotos().getJSONObject(indice).getString("marque");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas la marque");
        }
        return marque;
    }

    public String getModele(int indice) {
        String modele = "";
        try {
            modele = getMotos().getJSONObject(indice).getString("modele");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas le modele");
        }
        return modele;
    }

    public double getValeurDesOptions(int indice) {
        double valeur = 0;
        try {
            valeur = getMotos().getJSONObject(indice).getDouble("valeur_des_options");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas la valeur des options");
        }
        return valeur;
    }

    public String getBuriange(int indice) {
        String burinage = "";
        try {
            burinage = getMotos().getJSONObject(indice).getString("burinage");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas le burinage");
        }
        return burinage;
    }

    public boolean getGarageInterieur(int indice) {
        boolean garageInt = false;
        try {
            garageInt = getMotos().getJSONObject(indice).getBoolean("garage_interieur");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas s'il y a un garage interieur");
        }
        return garageInt;
    }

    public boolean getSystemeAlarme(int indice) {
        boolean systemAlarm = false;
        try {
            systemAlarm = getMotos().getJSONObject(indice).getBoolean("systeme_alarme");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,le moto de l'indice "+indice+" ne contient pas s'il y a un system d'alarme");
        }
        return systemAlarm;
    }


    public JSONArray getMessagesErreures() {
        JSONArray mes = new JSONArray();
        if (existeMotos.isEmpty()) {
            mes = messagesErreurs;
        } else {
            mes = existeMotos;
        }
        return mes;
    }
}
