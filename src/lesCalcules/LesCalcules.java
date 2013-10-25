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
import voiture.InfoVoiture;
import voiture.Voiture;

/**
 *
 * @author Hamza
 */
public class LesCalcules {

    InfoVoiture infoVoiture;
    InfoConducteur infoConducteur;
    Contrat contrat;
    double montant;

    public LesCalcules(InfoVoiture infoVoiture, InfoConducteur infoConducteur, Contrat contrat, double montant) {
        this.infoVoiture = infoVoiture;
        this.infoConducteur = infoConducteur;
        this.contrat = contrat;
        this.montant = montant;
    }

    public double appliquer() {

        String dateConduite = infoConducteur.getDateFinCoursDeConduite();
        int  age = infoConducteur.getConducteur().getAge();
        String sexe = infoConducteur.getConducteur().getSexe();
        int duree = contrat.getDureeContrat();
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(duree,age,sexe);   
        leMontant = m.ajouterValeursDesOptions(infoVoiture.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoVoiture.getBurinage(), leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoVoiture.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoVoiture.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.estReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantPremierContrat(infoConducteur.isPremierContrat(), leMontant);
        leMontant = m.retirerMontantExperience15Ans(dateConduite, leMontant);

        return leMontant;
    }

    public double calculerMontantMensualite() {
        double montantDeBase = appliquer();
        double montant = (montantDeBase + montantDeBase * 0.015) / 12;
        return montant;
    }
}
