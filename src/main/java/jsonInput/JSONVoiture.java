package main.java.jsonInput;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONVoiture {

    JSONObject unObjet;
    JSONArray messagesErreurs = new JSONArray();
    JSONArray existeVoitures = new JSONArray();

    public JSONVoiture() {
        try {
            unObjet = (JSONObject) JSONSerializer.toJSON((new JSON_Input()).getJsonInfo());
        } catch (Exception e) {
        }
    }

    public JSONArray getVoitures() {
        JSONArray voitures = new JSONArray();
        try {
            voitures = unObjet.getJSONArray("voitures");
        } catch (Exception e) {
            existeVoitures.add("Erreur fromat json ,les voitures n'existent pas");
        }
        return voitures;
    }

    public int getAnnee(int indice) {
        int annee = 0;
        try {
            annee = getVoitures().getJSONObject(indice).getInt("annee");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas l'annee");
        }
        return annee;
    }

    public String getMarque(int indice) {
        String marque = "";
        try {
            marque = getVoitures().getJSONObject(indice).getString("marque");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas la marque");
        }
        return marque;
    }

    public String getModele(int indice) {
        String modele = "";
        try {
            modele = getVoitures().getJSONObject(indice).getString("modele");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas le modele");
        }
        return modele;
    }

    public double getValeurDesOptions(int indice) {
        double valeur = 0;
        try {
            valeur = getVoitures().getJSONObject(indice).getDouble("valeur_des_options");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas la valeur des options");
        }
        return valeur;
    }

    public String getBuriange(int indice) {
        String burinage = "";
        try {
            burinage = getVoitures().getJSONObject(indice).getString("burinage");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas le burinage");
        }
        return burinage;
    }

    public boolean getGarageInterieur(int indice) {
        boolean garageInter = false;
        try {
            garageInter = getVoitures().getJSONObject(indice).getBoolean("garage_interieur");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas s'il y a un garage interieur");
        }
        return garageInter;
    }

    public boolean getSystemeAlarme(int indice) {
        boolean systemAlarm = false;
        try {
            systemAlarm = getVoitures().getJSONObject(indice).getBoolean("systeme_alarme");
        } catch (Exception e) {
            messagesErreurs.add("Erreur fromat json ,la voiture de l'indice " + indice + " ne contient pas s'il y a un system d'alarme");
        }
        return systemAlarm;
    }

    public JSONArray getMessagesErreures() {
        JSONArray mes = new JSONArray();
        if (existeVoitures.isEmpty()) {
            mes = messagesErreurs;
        } else {
            mes = existeVoitures;
        }
        return mes;
    }
}