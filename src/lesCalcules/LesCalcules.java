/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesCalcules;

import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import java.util.List;
import JSONSortie.FormatJSON;
import voiture.InfoMoto;
import voiture.InfoVehicule;
import voiture.InfoVoiture;
import voiture.Voiture;


public class LesCalcules {

    InfoVehicule infoVoiture;
    InfoVehicule infoVehicule;
    InfoConducteur infoConducteur;
    InfoMoto infoMoto;
    Contrat contrat;
    double montant;

    public LesCalcules(InfoVehicule infoVehicule, InfoConducteur infoConducteur, Contrat contrat, double montant) {
              
        //this.infoVoiture = infoVoiture;
        this.infoConducteur = infoConducteur;
        this.contrat = contrat;
        this.montant = montant;
        this.infoVehicule=infoVehicule;
       // this.infoMoto=infoMoto;
    }
  public double appliquer(String typeVehicule) {

        String dateConduite = infoConducteur.getDateFinCoursDeConduite();
        int  age = infoConducteur.getConducteur().getAge();
        String sexe = infoConducteur.getConducteur().getSexe();
        int duree = contrat.getDureeContrat();
        boolean estMembre=infoConducteur.estUnMembre_oiq();
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(duree,age,sexe,typeVehicule);   
        System.out.println("estMembre="+estMembre);
        leMontant = m.ajouterValeursDesOptions(infoVehicule.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoVehicule.getBurinage(), leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoVehicule.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoVehicule.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = m.retirerMontantExperience15Ans(dateConduite, leMontant);
        leMontant=m.calculerLeRabaisOrdreIngQuebec(estMembre, leMontant);

        
        
        return leMontant;
    }
    
    /*
    public double appliquerVoiture() {

        String dateConduite = infoConducteur.getDateFinCoursDeConduite();
        int  age = infoConducteur.getConducteur().getAge();
        String sexe = infoConducteur.getConducteur().getSexe();
        int duree = contrat.getDureeContrat();
        boolean estMembre=infoConducteur.estUnMembre_oiq();
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(duree,age,sexe,"voitures");   
        System.out.println("estMembre="+estMembre);
        leMontant = m.ajouterValeursDesOptions(infoVoiture.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoVoiture.getBurinage(), leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoVoiture.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoVoiture.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = m.retirerMontantExperience15Ans(dateConduite, leMontant);
        leMontant=m.calculerLeRabaisOrdreIngQuebec(estMembre, leMontant);

        
        
        return leMontant;
    }
     public double appliquerMoto() {

        String dateConduite = infoConducteur.getDateFinCoursDeConduite();
        int  age = infoConducteur.getConducteur().getAge();
        String sexe = infoConducteur.getConducteur().getSexe();
        int duree = contrat.getDureeContrat();
        boolean estMembre=infoConducteur.estUnMembre_oiq();
        int valeurCC=infoMoto.getValeurCC();
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(duree,age,sexe,"motos");   
        System.out.println("estMembre="+estMembre);
        leMontant = m.ajouterValeursDesOptions(infoMoto.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoMoto.getBurinage(), leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoMoto.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoMoto.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = m.retirerMontantExperience15Ans(dateConduite, leMontant);
        leMontant=m.ajouterPuissanceSuperieur1100cc(valeurCC, leMontant);
        leMontant=m.calculerLeRabaisOrdreIngQuebec(estMembre, leMontant);
        
        
        
        return leMontant;
    }*/
   /* public double appliquerMon(String typeVehicule){
         double montantDeBase = 0;
        if(typeVehicule.equals("voitures")){
         montantDeBase = appliquerVoiture();
        }else{
             montantDeBase = appliquerMoto();
        } 
        return montantDeBase;
    }*/
    public double calculerMontantMensualite(String typeVehicule) {
        double montantDeBase = appliquer(typeVehicule);

        double montant = (montantDeBase + montantDeBase * 0.015) / 12;
        return montant;
    }
}
