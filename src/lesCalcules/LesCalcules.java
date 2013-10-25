/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesCalcules;

import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import java.util.List;
//import JSONSortie.FormatJSON;
import voiture.InfoMoto;
import voiture.InfoVehicule;
import voiture.InfoVoiture;
import voiture.Voiture;

/**
 *
 * @author Hamza
 */
public class LesCalcules {

    InfoVehicule infoVoiture;
    InfoVehicule infoVehicule;
    InfoConducteur infoConducteur;
    InfoMoto infoMoto;
    Contrat contrat;
    double montant;

    public LesCalcules(InfoVehicule infoVehicule, InfoConducteur infoConducteur, Contrat contrat, double montant) {
        this.infoConducteur = infoConducteur;
        this.contrat = contrat;
        this.montant = montant;
        this.infoVehicule=infoVehicule;
    }
    
    
  public String getDateFinCours(){
      return infoConducteur.getDateFinCoursDeConduite();
  }
  public int getAge(){
      return  infoConducteur.getConducteur().getAge();
  }
  public String getSexe(){
      return infoConducteur.getConducteur().getSexe();
  }
  public int getDuree(){
      return contrat.getDureeContrat();
  }
  public boolean estMemebre_oiq(){
      return infoConducteur.estUnMembre_oiq();
  }

  public double appliquer(String typeVehicule) {
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(getDuree(),getAge(),getSexe(),typeVehicule);   
        leMontant = m.ajouterValeursDesOptions(infoVehicule.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoVehicule.getBurinage(), leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoVehicule.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoVehicule.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = m.retirerMontantExperience15Ans(getDateFinCours(), leMontant);
        leMontant=m.calculerLeRabaisOrdreIngQuebec(estMemebre_oiq(), leMontant); 
        return leMontant;
    }
}
