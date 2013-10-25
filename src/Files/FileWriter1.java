/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import JSONSortie.UnJSON;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileWriter1 {
 
    public static void creerPrinter(String path) throws IOException, Exception{
       PrintWriter write;
       write = new PrintWriter(new FileWriter(path));
       write.print(UnJSON.retournerUnJSON());
       write.flush();
       write.close();
    }
    public static void ecrire(String path) throws IOException, Exception {
        try {
           creerPrinter(path);
        }//try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
    }//ecrire
}
