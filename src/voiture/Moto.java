/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;


public class Moto implements Vehicule{
    String marque;
    int annee;
    double valeurInitial;
    String modele;
    double cc;
   public Moto(int annee,String marque,String modele){
     this.annee=annee;
     this.marque=marque;
     this.modele=modele;
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
    public double getValeurInitiale(){
        
        return valeurInitial;
    }
    public double getCC(){        
        return cc;
    }
        public boolean estExistAnnee(int annee) {
        boolean res = false;
        if (this.annee == annee) {
            res = true;
        }
        return res;
    }

    public boolean estExistMarque(String marque) {
        boolean res = false;
        if ((this.marque).equals(marque)) {
            res = true;
        }
        return res;
    }
    public boolean estExistModele(String modele){
         boolean res = false;
        if ((this.modele).equals(modele)) {
            res = true;
        }
        return res;  
    }
       public boolean estAssurable(int annee,String marque,String modele) {
        boolean log = false;
        if(estExistAnnee(annee)&& estExistMarque(marque)&& estExistModele(modele)){ 
            log = true;
        }
        return log;
    }
}
