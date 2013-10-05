/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesCalcules;

import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import java.util.List;
import verifications.VerifierFormatJSON;
import voiture.InfoVoiture;
import voiture.Voiture;


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
        String dateNaissance = infoConducteur.getConducteur().getDateDeNaissance();
        String sexe = infoConducteur.getConducteur().getSexe();
        int duree = contrat.getDureeContrat();
        MontantDeLaSoumission m = new MontantDeLaSoumission(montant);
        double leMontant = m.calculerMontantDeBase(duree);

        leMontant = m.ajouterValeursDesOptions(infoVoiture.getValeurDesOption(), leMontant);
        leMontant = m.ajouterMontantVille(infoConducteur.getConducteur().getVille(), leMontant);
        leMontant = m.retirerMontantBurinage(infoVoiture.getBurinage(), leMontant);
        leMontant = m.retirerMontantFemme(sexe, leMontant);
        leMontant = m.retirerMontantGarageInterieur(infoVoiture.isGarageInterieur(), leMontant);
        leMontant = m.retirerMontantSystemAlarme(infoVoiture.isSystemeAlarme(), leMontant);
        leMontant = m.retirerMontantCoursCAA(infoConducteur.isCoursDeConduiteReconnusParCAA(), leMontant);
        leMontant = m.ajouterMontantMoins35(sexe, dateNaissance, leMontant);
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
