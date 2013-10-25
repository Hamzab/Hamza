/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Files.FileWriter1;
import JSONEntree.JSONMotos;
import JSONEntree.JSONVoiture;
import JSONEntree.LesDonnes;
import JSONSortie.UnJSON;
import voiture.Voiture;


public class Main {

    public static String tmp[] = new String[3];

    public static void main(String[] args) throws Exception {
        tmp = args;
       // FileWriter1.ecrire(args[1]);
      //  System.out.println("estAssurable = "+UnJSON.estAssurable(new Voiture(2014, "Maserati","Quattroporte Q4 AWD")));
      //System.out.println("estAssurablePlusieursVoitures() "+UnJSON.estAssurablePlusieursVoitures());
       System.out.println(UnJSON.estAssurableToutLesVehicules());
    }
}
