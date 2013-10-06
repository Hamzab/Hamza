/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;


public class Voiture {

    String marque;
    int annee;
    String modele;

    public Voiture(String marque, int annee, String modele) {
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

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}
