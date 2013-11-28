package Files;

import jsonOutput.JSON_Output;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import net.sf.json.JSONObject;

public class FileWriter1 {

    public static void creerPrinter(String path, JSONObject unObjet) throws IOException, Exception {
        PrintWriter write;
        write = new PrintWriter(new FileWriter(path));
        write.print(unObjet);
        write.flush();
        write.close();
    }

    public static void ecrire(String path, JSONObject unObjet) throws IOException, Exception {
        try {
            creerPrinter(path, unObjet);
        }//try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
    }//ecrire
}
