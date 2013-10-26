
package montantDeLaSoumission;
import conducteur.InfoConducteur;
import contrat.Contrat;
import voiture.InfoMoto;
import voiture.InfoVehicule;


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
  public  MontantDeLaSoumission getMont(){
     return  new MontantDeLaSoumission(montant);
  }
  /*
   * On est dévisé la méthode appliquer en 2 pour réspecter
   * la norme de la limite des nombres de ligne par méthode
   */
  public double appliquer1(String typeVehicule){
       double leMontant = getMont().calculerMontantDeBase(getDuree(),getAge(),getSexe(),typeVehicule);   
        leMontant = getMont().ajouterValeursDesOptions(infoVehicule.getValeurDesOption(), leMontant);
        leMontant = getMont().ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = getMont().retirerMontantBurinage(infoVehicule.getBurinage(), leMontant);
        leMontant = getMont().retirerMontantGarageInterieur(infoVehicule.isGarageInterieur(), leMontant);
        leMontant = getMont().retirerMontantSystemAlarme(infoVehicule.isSystemeAlarme(), leMontant);  
      return leMontant;
  }
  public double appliquer(String typeVehicule) {
        double leMontant =appliquer1(typeVehicule);
        leMontant = getMont().retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = getMont().ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = getMont().retirerMontantExperience15Ans(getDateFinCours(), leMontant);
        leMontant= getMont().ajouterPuissanceSuperieur1100cc(infoVehicule.getValeurCC(),leMontant);
        leMontant=getMont().calculerLeRabaisOrdreIngQuebec(estMemebre_oiq(), leMontant); 
        return leMontant;
    }
}
