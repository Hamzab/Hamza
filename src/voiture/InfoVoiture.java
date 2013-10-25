/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;


public class InfoVoiture {

    Voiture voiture;
    double valeurDesOption;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;
    public InfoVoiture(Voiture voiture, double valeurDesOption, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.voiture = voiture;
        this.valeurDesOption = valeurDesOption;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public double getValeurDesOption() {
        return valeurDesOption;
    }

    public String getBurinage() {
        return burinage;
    }

    public boolean isGarageInterieur() {
        return garageInterieur;
    }

    public boolean isSystemeAlarme() {
        return systemeAlarme;
    }


    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public void setValeurDesOption(double valeurDesOption) {
        this.valeurDesOption = valeurDesOption;
    }

    public void setBurinage(String burinage) {
        this.burinage = burinage;
    }

    public void setGarageInterieur(boolean garageInterieur) {
        this.garageInterieur = garageInterieur;
    }

    public void setSystemeAlarme(boolean systemeAlarme) {
        this.systemeAlarme = systemeAlarme;
    }
}
