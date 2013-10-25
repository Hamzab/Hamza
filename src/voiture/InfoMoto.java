/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;


public class InfoMoto {
    Moto moto;
    double valeurDesOption;
    int valeurCC;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;
    public InfoMoto(Moto moto, double valeurDesOption,int valeurCC, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.moto = moto;
        this.valeurDesOption = valeurDesOption;
        this.valeurCC = valeurCC;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;
    }

    public Moto getMoto() {
        return moto;
    }

    public double getValeurDesOption() {
        return valeurDesOption;
    }

    public int getValeurCC() {
        return valeurCC;
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

}
