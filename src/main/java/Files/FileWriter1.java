package Files;
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

    public static boolean ecrire(String path, JSONObject unObjet) throws IOException, Exception {
        boolean res=false;
        try {
            creerPrinter(path, unObjet);
            res=true;
        }//try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
       return res;
    }//ecrire
    
}
