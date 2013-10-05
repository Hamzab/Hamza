
package lesCalcules;

import date.LaDate;

public class MontantDeLaSoumission {

    double montant;

    public MontantDeLaSoumission(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double calculerMontantDeBase(int dureeContrat) {
        double res = 0.0;
        double tmp = montant;
        if (dureeContrat == 3) {
            tmp -= tmp * 0.15;
        }
        res = tmp * 0.09;
      
        return res;
    }

    public double ajouterValeursDesOptions(double valeurDesOptions, double montantDeBase) {
        montantDeBase += (valeurDesOptions * 0.10);
      
        return montantDeBase;
    }

    public double ajouterMontantVille(String ville, double montantDeBase) {
        if (ville.equals("Montréal") || ville.equals("Longueuil")) {
            montantDeBase += 200.0;
        }
           
        return montantDeBase;
    }

    public double retirerMontantBurinage(String burinage, double montantDeBase) {
        if (burinage.equals("Sherlock")) {
            montantDeBase -= 250.0;
        }
        
        return montantDeBase;
    }

    public double retirerMontantFemme(String sexe, double montantDeBase) {
        if (sexe.equals("F")) {
            montantDeBase -= 1000.0;
        }
         
        return montantDeBase;
    }

    public double retirerMontantGarageInterieur(boolean estInterieur, double montantDeBase) {
        if (estInterieur == true) {
            montantDeBase -= 500.0;
        }
        
        return montantDeBase;
    }

    public double retirerMontantSystemAlarme(boolean estSysAlarme, double montantDeBase) {
        if (estSysAlarme == true) {
            montantDeBase -= 500.0;
        }
        
        return montantDeBase;
    }

    public double retirerMontantCoursCAA(boolean estCoursCAA, double montantDeBase) {
        if (estCoursCAA == true) {
            montantDeBase -= 100.0;
        }
        
        return montantDeBase;
    }

    public double ajouterMontantMoins35(String sexe,String dateDeNaissance, double montantDeBase) {
        int age = LaDate.getAnnees(dateDeNaissance);
        if (age < 35 && sexe.equals("M")) {
            montantDeBase += 1000.0;
        }
      
        return montantDeBase;
    }

    public double ajouterMontantPremierContrat(boolean estPremierContrat, double montantDeBase) {
        if (estPremierContrat == true) {
            montantDeBase += 2000.0;
        }
         
        return montantDeBase;
    }

    public double retirerMontantExperience15Ans(String dateFinCours, double montantDeBase) {
        int anneesExperience = LaDate.getAnnees(dateFinCours);
        if (anneesExperience > 15) {
            montantDeBase -= 400.0;
        }
        return montantDeBase;
    }
}
