/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verifications;

import JSONEntree.LesDonnes;
import voiture.Voiture;


public class VerifierVoiture {

    Voiture uneVoiture;

    public VerifierVoiture(Voiture uneVoiture) {
        this.uneVoiture = uneVoiture;
    }
    public boolean verifierAnnee(){
        boolean res=false;
        if(uneVoiture.getAnnee()==2014){
            res=true;
        }
       return res;
    }
    public boolean verifierMarque(){
        boolean res=false;
        if(uneVoiture.getMarque().equals("Porsche")){
            res=true;
        }
        return res;
    }
    public boolean estAssurable() throws Exception {
        double valeur = LesDonnes.getValeur(uneVoiture.getModele());
        boolean log = false;
        if (valeur != 0.0 && verifierAnnee()
                && verifierMarque()) {
            log = true;
        }
        return log;
    }
}
