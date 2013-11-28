package voiture;

public interface InfoVehicule {

    public double getValeurDesOption();

    public String getBurinage();

    public boolean isGarageInterieur();

    public boolean isSystemeAlarme();

    public int getValeurCC();

    public boolean estAssurable(int annee, String marque, String modele, double valeur);

    public Vehicule getVehicule();
}
