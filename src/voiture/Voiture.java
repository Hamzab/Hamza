/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;

import JSONEntree.LesDonnes;


public class Voiture implements Vehicule {

    String marque;
    int annee;
    double valeurInitial;
    String modele;

    public Voiture(int annee,String marque,String modele) {
        this.marque = marque;
        this.annee = annee;
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public int getAnnee() {
        return annee;
    }

    public String getModele() {
        return modele;
    }

    public double getValeurInitiale() {

        return valeurInitial;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public boolean estExistAnnee(int annee) {
        boolean res = false;
        if (this.annee == annee) {
            res = true;
        }
        return res;
    }

    public boolean estExistMarque(String marque) {
        boolean res = false;
        if ((this.marque).equals(marque)) {
            res = true;
        }
        return res;
    }
    public boolean estExistModele(String modele){
         boolean res = false;
        if ((this.modele).equals(modele)) {
            res = true;
        }
        return res;  
    }

    public boolean estAssurable(int annee,String marque,String modele) {
       // double valeur = LesDonnes.getValeur(getModele());
        boolean log = false;
        if(estExistAnnee(annee)&& estExistMarque(marque)&& estExistModele(modele)){ 
            log = true;
        }
        return log;
    }
}
