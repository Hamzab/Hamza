package voiture;

public class InfoMoto implements InfoVehicule {

    Vehicule moto;
    double valeurDesOption;
    int valeurCC;
    String burinage;
    boolean garageInterieur;
    boolean systemeAlarme;

    public InfoMoto(Vehicule moto, double valeurDesOption, int valeurCC, String burinage, boolean garageInterieur, boolean systemeAlarme) {
        this.moto = moto;
        this.valeurDesOption = valeurDesOption;
        this.valeurCC = valeurCC;
        this.burinage = burinage;
        this.garageInterieur = garageInterieur;
        this.systemeAlarme = systemeAlarme;
    }

    public Vehicule getVehicule() {
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
 
    public boolean estAssurableVoiturePlusUnMillion(double valeur) {
        boolean res =true;
        if (valeur > 1000000) {
            if (this.systemeAlarme == false || this.garageInterieur == false) {
                res = false;
            }
        }
        return res;
    }
   public boolean estAssurable(int annee, String marque, String modele,double valeur){
        boolean res=false;
        if(moto.estAssurable(annee,marque,modele)&&
               estAssurableVoiturePlusUnMillion(valeur) ){
            res=true;
        }
       return res;
    }
}
