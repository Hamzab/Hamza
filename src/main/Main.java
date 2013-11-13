package main;

import Files.FileWriter1;
import jsonInput.JSONContrat;
import jsonInput.JSONVoiture;
import jsonOutput.JSON_Output;
import date.Date1;
import statistiques.ListeVehicule;
import statistiques.Statistiques;

public class Main {

    public static String tmp[] = new String[3];

    public static boolean validerArgs(String[] args) {
        boolean estValide = false;
        if (args.length == 2) {
            estValide = true;
        }
        return estValide;
    }

    public static void main(String[] args) throws Exception {
        tmp = args;
        if (validerArgs(args)) {
            Statistiques s = new Statistiques();
            JSON_Output unjson = new JSON_Output();
            unjson.initialiser();
            if(!args[0].equals("-L") && !args[0].equals("-S")){
            FileWriter1.ecrire(args[1], unjson.retournerUnJSON());
          }
             ListeVehicule.putObjetJson();
            s.creerUnJsonStat();
        } else {
            System.out.println("Erreur, ce programme doit accepter 2 arguments.");
        }
    }
}
