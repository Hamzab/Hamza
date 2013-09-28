/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_session;

/**
 *
 * @author rafikgharsalli
 */
public class Voiture {
    
    int annee;
    String marque; 
    String modele;
    int valeurOption;
    String burinage;
    Boolean garageInt;
    Boolean systemeAlarme;

    public Voiture(int annee, String marque, String modele, int valeurOption, 
                   String burinage, Boolean garageInt, Boolean systemeAlarme){
        this.annee = annee;
        this.marque = marque;
        this.modele = modele;
        this.valeurOption = valeurOption;
        this.burinage = burinage;
        this.garageInt = garageInt;
        this.systemeAlarme = systemeAlarme;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getValeurOption() {
        return valeurOption;
    }

    public void setValeurOption(int valeurOption) {
        this.valeurOption = valeurOption;
    }

    public String getBurinage() {
        return burinage;
    }

    public void setBurinage(String burinage) {
        this.burinage = burinage;
    }

    public Boolean getGarageInt() {
        return garageInt;
    }

    public void setGarageInt(Boolean garageInt) {
        this.garageInt = garageInt;
    }

    public Boolean getSystemeAlarme() {
        return systemeAlarme;
    }

    public void setSystemeAlarme(Boolean systemeAlarme) {
        this.systemeAlarme = systemeAlarme;
    }

   
    @Override
    public String toString() {
        return "Voiture{" + "Annee=" + annee + ", Marque=" + marque + ", Modele=" + modele + ", valeurOption=" + valeurOption + ", burinage=" + burinage + ", garageInt=" + garageInt + ", systemeAlarme=" + systemeAlarme + '}';
    }

  
    
    
    
    
    
    
    
    
    
    
    
}
