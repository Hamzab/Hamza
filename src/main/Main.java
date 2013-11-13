package main;

import Files.FileWriter1;
import JSONEntree.JSONContrat;
import JSONEntree.JSONVoiture;
import JSONSortie.UnJSON;
import date.LaDate;
import statistiques.ListeDeVehicule;
import statistiques.Statistiques;

public class Main {

    public static String tmp[] = new String[3];

    public static void main(String[] args) throws Exception {
        tmp = args;
        Statistiques s=new Statistiques();
        UnJSON unjson=new UnJSON();
        unjson.initialiser();
        FileWriter1.ecrire(args[1],unjson.retournerUnJSON());
        FileWriter1.ecrire("json/liste.json",ListeDeVehicule.putObjetJson());
         s.creerUnJsonStat();
    }
}
