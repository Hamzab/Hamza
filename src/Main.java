/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hamza Farida rim
 */
import java.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimeSheet {

    /**
     * @param args the command line arguments
     */
    public static List<Integer> projetMinutes(JSONObject obJson, String unJour, String travail) throws Exception {
        JSONArray jours = (JSONArray) JSONSerializer.toJSON(obJson.get(unJour));
        List<Integer> perTravail = new ArrayList<Integer>();

        int proMin = 0;
        for (int i = 0; i < jours.size(); i++) {
            JSONObject obJour = jours.getJSONObject(i);
            try {
                proMin = Integer.parseInt(obJour.getString(travail));
            } catch (EmptyStackException e) {
                System.out.println("Erreur");
            }
            perTravail.add(proMin);
        }
        return perTravail;
    }
    public static String verifierTypeEmploye(JSONObject employe) throws Exception {
        String typeEmploye = "";
        String snoEmploye = employe.getString("numero_employe");
        int noEmploye = Integer.parseInt(snoEmploye);
        if (noEmploye >= 1000) {
            typeEmploye = "employé normale";
        } else {
            typeEmploye = "employé de l'administration";
        }
        return typeEmploye;
    }

    public static int teleTravail(JSONObject employe) throws Exception {

        List<Integer> projets = new ArrayList<Integer>();
        List<Integer> munites = new ArrayList<Integer>();
        int sommeMinutes = 0;
        String[] lesJours = {"jour1", "jour2", "jour3", "jour4", "jour5", "weekend1", "weekend2"};
        for (int i = 0; i < lesJours.length; i++) {
            projetMinutes(employe, lesJours[i], "projet");
            projets = projetMinutes(employe, lesJours[i], "projet");
            munites = projetMinutes(employe, lesJours[i], "minutes");
            for (int j = 0; j < projets.size(); j++) {
                if (projets.get(j) > 900) {
                    sommeMinutes += munites.get(j);
                }
            }
        }
         return sommeMinutes;
    }

    public static int totalMinutesTravail(JSONObject employe) throws Exception {
        List<Integer> munites = new ArrayList<Integer>();
        int sommeMinutes = 0;
        String[] lesJours = {"jour1", "jour2", "jour3", "jour4", "jour5", "weekend1", "weekend2"};
        for (int i = 0; i < lesJours.length; i++) {
            munites = projetMinutes(employe, lesJours[i], "minutes");
            for (int j = 0; j < munites.size(); j++) {
                sommeMinutes += munites.get(j);
            }
        }
        return sommeMinutes;
    }

    public static boolean verifierLeNombreHeuresMinimal(JSONObject employe) throws Exception {
        final int MIN_NORMALE = 38;
        final int MIN_ADMINS = 36;
        boolean verifier = true;
        String typeEmploye = verifierTypeEmploye(employe);
        int sommeMin = totalMinutesTravail(employe) - teleTravail(employe);
        if (typeEmploye.compareTo("employé normale") == 0
                && sommeMin < (MIN_NORMALE * 60)
                || typeEmploye.compareTo("employé de l'administration") == 0
                && sommeMin < (MIN_ADMINS * 60)) {
            verifier = false;
         }
        return verifier;
    }

    public static boolean verifierLeNombreHeuresMaximal(JSONObject employe) throws Exception {
        final int MAX = 43;
        boolean verifier = true;
        int sommeMin = totalMinutesTravail(employe) - teleTravail(employe);
        if (sommeMin > MAX * 60) {
            verifier = false;
        }
        return verifier;
    }

    public static boolean verifierLeNombreHeuresTeleTravailMax(JSONObject employe) throws Exception {
        final int MAX = 10;
        boolean verifier = true;
        int sommeMin = teleTravail(employe);
        String typeEmp = verifierTypeEmploye(employe);
        if (typeEmp.compareTo("employé de l'administration") == 0
                && sommeMin > MAX * 60) {
            verifier = false;
        }
        return verifier;
    }

    public static boolean verifierLeNombreHeuresMinmalParJourNorm(JSONObject employe) throws Exception {
        int sommeMinQuo = 0;
        final int MIN = 6;
        boolean verifier = true;
        String[] lesJours = {"jour1", "jour2", "jour3", "jour4", "jour5"};
        String typeEmp = verifierTypeEmploye(employe);
        if (typeEmp.compareTo("employé normale") == 0) {
            for (int i = 0; i < lesJours.length; i++) {
                List<Integer> nombreMin = projetMinutes(employe, lesJours[i], "minutes");
                List<Integer> codeProjet = projetMinutes(employe, lesJours[i], "projet");
                for (int j = 0; j < nombreMin.size(); j++) {
                    if (codeProjet.get(j) <= 900) {
                        sommeMinQuo += nombreMin.get(j);
                    }
                }
                if (sommeMinQuo < MIN * 60) {
                    verifier = false;
                }
                sommeMinQuo = 0;
            }
        }
        return verifier;
    }

    public static boolean verifierLeNombreHeuresMinmalParJourAdmin(JSONObject employe) throws Exception {
        int sommeMinQuo = 0;
        final int MIN = 4;
        boolean verifier = true;
        String[] lesJours = {"jour1", "jour2", "jour3", "jour4", "jour5"};
        String typeEmp = verifierTypeEmploye(employe);
        if (typeEmp.compareTo("employé de l'administration") == 0) {
            for (int i = 0; i < lesJours.length; i++) {
                List<Integer> nombreMin = projetMinutes(employe, lesJours[i], "minutes");
                List<Integer> codeProjet = projetMinutes(employe, lesJours[i], "projet");
                for (int j = 0; j < nombreMin.size(); j++) {
                    if (codeProjet.get(j) <= 900) {
                        sommeMinQuo += nombreMin.get(j);
                    }
                }
                if (sommeMinQuo < MIN * 60) {
                    verifier = false;
                }
                sommeMinQuo = 0;
            }
        }
        return verifier;
    }
    public static String resultatDeVerification(JSONObject employe) throws Exception {
        String lesRemarques = "";  
        String resultat = "[";
        if (!verifierLeNombreHeuresMinimal(employe)) {
            lesRemarques += "\"L'employé n'a pas travaillé le nombre d'heures minimal.\"\n";
        }
        if (!verifierLeNombreHeuresMaximal(employe)) {
            lesRemarques += "\"L'employé a depassé le nombre d'heures maximal\"\n";
        }
        if (!verifierLeNombreHeuresTeleTravailMax(employe)) {
            lesRemarques += "\"L'employé a depassé nombre d'heures maximal pour télétravail\"\n";
        }
        if (!verifierLeNombreHeuresMinmalParJourNorm(employe)) {
            lesRemarques += "\"L'employé n'a pas travaillé le nombre d'heures minimale pour un jour \"\n";
        }
        if (!verifierLeNombreHeuresMinmalParJourAdmin(employe)) {
            lesRemarques += "\"L'employé n'a pas travaillé le nombre d'heures minimale  pour un jour \"\n";
        }
        
        
        for (int i = 0; i < lesRemarques.length() - 1; i++) {
            resultat += lesRemarques.charAt(i);
            if (lesRemarques.charAt(i + 1) == '\n' && i != lesRemarques.length() - 2) {
                resultat += ",";
            } else if (lesRemarques.charAt(i + 1) == '\n' && i == lesRemarques.length() - 2) {
                resultat += "]";
            }
        }

        return resultat;
    }

    public static void ecrireFichierJson(JSONObject employe) throws Exception {
        String cheminDuFichier = "src/message_result.json";

        String contenuJson = resultatDeVerification(employe);
        File unFichier = new File(cheminDuFichier);

        try {
            if (!unFichier.exists()) {
                unFichier.createNewFile();
            }
            FileWriter ecriture = new FileWriter(unFichier);
            ecriture.write(contenuJson);
            ecriture.flush();
            ecriture.close();
        } catch (IOException e) {
            System.out.println("Erreur: impossible de créer le fichier '"
                    + cheminDuFichier + "'");
        }
    }

    public static void main(String[] args) throws Exception {
        String textJson = FileReader.loadFileIntoString("src/inputfile.json");
        JSONObject unEmploye = (JSONObject) JSONSerializer.toJSON(textJson);
        ecrireFichierJson(unEmploye);
    }
}