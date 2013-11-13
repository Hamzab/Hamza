package voiture;

public class InfoVoiture implements InfoVehicule {

    Vehicule voiture;
    double valeurDesOption;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;

    public InfoVoiture(Vehicule voiture, double valeurDesOption, int valeurCC, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.voiture = voiture;
        this.valeurDesOption = valeurDesOption;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;
    }

    @Override
    public Vehicule getVehicule() {
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

    public boolean estAssurableVoiturePlusUnMillion(double valeur) {
        boolean res = true;
        if (valeur > 1000000) {
            if (this.systemeAlarme == false || this.garageInterieur == false) {
                res = false;
            }
        }
        return res;
    }
    public boolean estAssurable(int annee, String marque, String modele,double valeur){
        boolean res=false;
        if(voiture.estAssurable(annee,marque,modele)&&
               estAssurableVoiturePlusUnMillion(valeur) ){
            res=true;
        }
       return res;
    }
}
