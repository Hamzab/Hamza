package main.java.statistiques;

import main.java.Files.FileWriter1;
import java.io.IOException;
import main.java.jsonInput.Donnes;
import main.java.jsonInput.JSONMotos;
import main.java.jsonInput.JSONVoiture;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListeVehicule {  

    public ListeVehicule() {
    }
    static JSONMotos jsonMotos = new JSONMotos();
    static JSONVoiture jsonVoiture = new JSONVoiture();

    public JSONObject ajouterVehicule(String marque, String modele, int annee, String type) {
        JSONObject jo = new JSONObject();
        jo.put("marque", marque);
        jo.put("modele", modele);
        jo.put("annee", annee);
        jo.put("type", type);
        return jo;
    }

    public JSONArray getListeVehicules(String type) throws Exception {
        JSONArray uneliste = new JSONArray();
        Donnes d = new Donnes();
        JSONArray voitures = d.getDataVihecules(type);
        for (int i = 0; i < voitures.size(); i++) {
            String marque = d.getMarques(type).get(i);
            String modele = d.getModeles(type).get(i);
            int annee = d.getAnnees(type).get(i);
            uneliste.add(ajouterVehicule(marque, modele, annee, type));
        }
        return uneliste;
    }

    public JSONArray getListe() throws Exception {
        JSONArray liste = getListeVehicules("voitures");
        JSONArray listeTmp = getListeVehicules("motos");
        JSONObject jo = new JSONObject();
        for (int i = 0; i < listeTmp.size(); i++) {
            liste.add(listeTmp.get(i));
        }
        // jo.put("assurables", liste);
        return liste;
    }

    public void copierListe(JSONArray liste, String marques[], String modeles[], int annees[], String types[]) {
        for (int i = 0; i < liste.size(); i++) {
            marques[i] = liste.getJSONObject(i).getString("marque");
            modeles[i] = liste.getJSONObject(i).getString("modele");
            annees[i] = liste.getJSONObject(i).getInt("annee");
            types[i] = liste.getJSONObject(i).getString("type");
        }

    }

    public void changerValeursTable(String marques[], String modeles[], int annees[], String types[], int i, int j) {
        String tmpMarque = marques[i], tmpModele = modeles[i], tmpType = types[i];
        int tmpAnnee = annees[i];
        marques[i] = marques[j];
        modeles[i] = modeles[j];
        annees[i] = annees[j];
        types[i] = types[j];
        marques[j] = tmpMarque;
        modeles[j] = tmpModele;
        annees[j] = tmpAnnee;
        types[j] = tmpType;
    }

    public void trieListeMarqueModele(JSONArray liste, String marques[], String modeles[], int annees[], String types[]) {
        for (int i = 0; i < liste.size() - 1; i++) {
            for (int j = i + 1; j < liste.size(); j++) {
                if (marques[i].compareTo(marques[j]) > 0) {
                    changerValeursTable(marques, modeles, annees, types, i, j);
                } else if (marques[i].compareTo(marques[j]) == 0) {
                    if (modeles[i].compareTo(modeles[j]) > 0) {
                        changerValeursTable(marques, modeles, annees, types, i, j);
                    }
                }
            }
        }
    }

    public void getListeTrieeMarqueModele(JSONArray liste, String marques[], String modeles[], int annees[], String types[]) {
        copierListe(liste, marques, modeles, annees, types);
        trieListeMarqueModele(liste, marques, modeles, annees, types);
    }

    public JSONArray putListeTriee(JSONArray liste, String marques[], String modeles[], int annees[], String types[]) {
        JSONArray liste2 = new JSONArray();
        for (int i = 0; i < liste.size(); i++) {
            JSONObject js = new JSONObject();
            js.put("marque", marques[i]);
            js.put("modele", modeles[i]);
            js.put("annee", annees[i]);
            js.put("type", types[i]);
            liste2.add(js);
        }
        return liste2;
    }

    public JSONObject getListeTriee() throws Exception {
        JSONObject jo = new JSONObject();
        JSONArray liste = getListe();
        String marques[] = new String[liste.size()], modeles[] = new String[liste.size()], types[] = new String[liste.size()];
        int annees[] = new int[liste.size()];
        getListeTrieeMarqueModele(liste, marques, modeles, annees, types);
        JSONArray liste2 = putListeTriee(liste, marques, modeles, annees, types);
        jo.put("assurables", liste2);
        return jo;
    }

    public void ecrireListe(String path) throws IOException, Exception {
        JSONObject ob = getListeTriee();
        FileWriter1.ecrire(path, ob);
    }
}
