/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_session;


import java.io.*;
import net.sf.json.*;
//import java.util.*;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;

/**
 *
 * @author rafikgharsalli
 */
public class Projet_session {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException , JSONException{
        
        
         BufferedReader br = new BufferedReader(
                new FileReader (
                new File("library.json" )));
        // TODO code application logic here
        String jSonText = "";
        String line = "";
        while((line = br.readLine()) != null){
            jSonText+= line;
            
        }
        // JSONArray root = (JSONArray) JSONSerializer.toJSON(jSonText);
         //JSONObject document = root.getJSONObject(0);
         //System.out.println(document);
         //System.out.println(document.getString("annee"));
       // System.out.println(jSonText);
        //document.getString("voiture");
         //String mystring = JSONObject(jSonText.toString()); 

      
        
        
        
    }
}
