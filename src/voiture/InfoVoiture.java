/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;


public class InfoVoiture implements InfoVehicule{

    Vehicule voiture;
    double valeurDesOption;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;

    public InfoVoiture(Vehicule voiture, double valeurDesOption,int valeurCC, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.voiture = voiture;
        this.valeurDesOption = valeurDesOption;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;
    }


    public Vehicule getVoiture() {
        return voiture;
    }

    @Override
    public double getValeurDesOption() {
        return valeurDesOption;
    }

    @Override
    public String getBurinage() {
        return burinage;
    }

    @Override
    public boolean isGarageInterieur() {
        return garageInterieur;
    }

    @Override
    public boolean isSystemeAlarme() {
        return systemeAlarme;
    }

      @Override
    public int getValeurCC() {
        return 0;
    }
}
