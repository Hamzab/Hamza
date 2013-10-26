
package voiture;

public class InfoMoto implements InfoVehicule{
    Vehicule moto;
    double valeurDesOption;
    int valeurCC;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;
    public InfoMoto(Vehicule moto, double valeurDesOption,int valeurCC, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.moto = moto;
        this.valeurDesOption = valeurDesOption;
        this.valeurCC = valeurCC;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;      
    }


    public Vehicule getMoto() {
        return moto;
    }

    @Override
    public double getValeurDesOption() {
        return valeurDesOption;
    }

    @Override
    public int getValeurCC() {
        return valeurCC;
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

}
