package voiture;

import JSONEntree.LesDonnes;

public class Voiture implements Vehicule {

    String marque;
    int annee;
    double valeurInitial;
    String modele;

    public Voiture(int annee, String marque, String modele) {
        this.marque = marque;
        this.annee = annee;
        this.modele = modele;
    }

    @Override
    public String getMarque() {
        return marque;
    }

    @Override
    public int getAnnee() {
        return annee;
    }

    @Override
    public String getModele() {
        return modele;
    }

    @Override
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

    @Override
    public boolean estExistAnnee(int annee) {
        boolean res = false;
        if (this.annee == annee) {
            res = true;
        }
        return res;
    }

    @Override
    public boolean estExistMarque(String marque) {
        boolean res = false;
        if ((this.marque).equals(marque)) {
            res = true;
        }
        return res;
    }

    @Override
    public boolean estExistModele(String modele) {
        boolean res = false;
        if ((this.modele).equals(modele)) {
            res = true;
        }
        return res;
    }
 
    @Override
    public boolean estAssurable(int annee, String marque, String modele) {
        boolean log = false;
        if (estExistAnnee(annee) && estExistMarque(marque) && estExistModele(modele)) {
            log = true;
        }
        return log;
    }
}
