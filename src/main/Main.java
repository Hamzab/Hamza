package main;

import Files.FileWriter1;
import jsonInput.JSONContrat;
import jsonInput.JSONVoiture;
import jsonOutput.JSON_Output;
import dateContrat.Date1;
import java.io.IOException;
import jsonInput.JSON_Input;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
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

    public static void ecrireStats(String path) throws IOException, Exception {
        
        JSONObject ob = new JSONObject();
        try {
            ob = new JSON_Input().getJsonStats();
            
            FileWriter1.ecrire(path, ob);
        } catch (Exception e) {
        }
       if(ob.isEmpty()){
           FileWriter1.ecrire(path, new Statistiques().creerUnJsonStat());; 
       }
    }

    public static void ecrireListe(String path) throws IOException, Exception {
        boolean val = true;
        try {
            String jsonTxt = new JSON_Input().getJsonListe();
            JSONObject ob = (JSONObject) JSONSerializer.toJSON(jsonTxt);
            FileWriter1.ecrire(path, ob);
        } catch (Exception e) {
            val = false;
        }
        
        if (!val) {
             
            JSONObject ob1=new JSONObject();
            ob1.put("assurables", new JSONArray());
            FileWriter1.ecrire(path,ob1);
        }
    }

    public static void main(String[] args) throws Exception {
        tmp = args;
        if (validerArgs(args)) {
            if (!args[0].equals("-L") && !args[0].equals("-S")) {
                Statistiques s = new Statistiques();
                JSON_Output unjson = new JSON_Output();
                unjson.initialiser();
                FileWriter1.ecrire(args[1], unjson.retournerUnJSON());
                ListeVehicule.putObjetJson();
                s.creerUnJsonStat();
            } else if (args[0].equals("-L")) {
                ecrireListe(args[1]);
            } else if (args[0].equals("-S")) {
                ecrireStats(args[1]);
            }
        } else {
            System.out.println("Erreur, ce programme doit accepter 2 arguments.");
        }
    }
}
