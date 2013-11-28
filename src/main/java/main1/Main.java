package main.java.main1;

import main.java.Files.FileReader;
import main.java.Files.FileWriter1;
import main.java.jsonOutput.JSON_Output;
import main.java.statistiques.ListeVehicule;
import main.java.statistiques.Statistiques;

public class Main {

    public static String tmp[] = new String[3];

    public static boolean validerArgs(String[] args) {
        boolean estValide = false;
        if (args.length == 2) {
            estValide = true;
        }
        return estValide;
    }

    public static void signerContrat(String path) throws Exception {
        Statistiques s = new Statistiques();
        JSON_Output unjson = new JSON_Output();
        unjson.initialiser();
        FileWriter1.ecrire(path, unjson.retournerUnJSON());
        s.creerUnJsonStat();
    }

    public static void appliquer(String[] args) throws Exception {
        if (!args[0].equals("-L") && !args[0].equals("-S")) {
            if (!FileReader.loadFileIntoString(args[0], "UTF-8").equals("")) {
                signerContrat(args[1]);
            }
        } else if (args[0].equals("-L")) {
            new ListeVehicule().ecrireListe(args[1]);
        } else if (args[0].equals("-S")) {
            new Statistiques().ecrireStats(args[1]);
        }
    }

    public static void main(String[] args) throws Exception {
        tmp = args;
        if (validerArgs(args)) {
            appliquer(args);
        } else {
            System.out.println("Erreur, ce programme doit accepter 2 arguments.");
        }
    }
}
