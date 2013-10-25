package lesCalcules;

import date.LaDate;

public class MontantDeLaSoumission {

    double montant;

    public MontantDeLaSoumission(double montant) {

        if (montant > 500000) {
            montant += 2500;
        }

        this.montant = montant;

    }

    public double getMontant() {

        return montant;

    }

    public void setMontant(double montant) {
        this.montant = montant;


    }

    public double getPourcentagePourMontantDeBaseHomme(int age) {
        double res = 0;
        if (age >= 25 && age <= 35) {
            res = 0.15;
        } else if (age >= 36 && age <= 60) {
            res = 0.12;
        } else if (age >= 61 && age <= 75) {
            res = 0.12;
        }

        return res;
    }

    public double getPourcentagePourMontantDeBaseFemme(int age) {
        double res = 0;
        if (age >= 21 && age <= 40) {
            res = 0.11;
        } else if (age >= 41 && age <= 65) {
            res = 0.09;
        } else if (age >= 66 && age <= 75) {
            res = 0.155;
        }
        return res;
    }

    public double getPourcentagePourMontantDeBase(int age, String sexe, String typeVehiCule) {
        double res = 0;
        if (sexe.equals("M")) {
            res = getPourcentagePourMontantDeBaseHomme(age);
        } else {
            res = getPourcentagePourMontantDeBaseFemme(age);
        }
        if (typeVehiCule.equals("motos")) {
            res += 0.14;
        }


        return res;
    }

    public double calculerMontantDeBase(int dureeContrat, int age, String sexe, String typeVehiCule) {
        double res = 0.0;
        double tmp = montant;
        if (dureeContrat == 3) {
            tmp -= tmp * 0.15;
        }
        res = tmp * getPourcentagePourMontantDeBase(age, sexe, typeVehiCule);

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

    public double ajouterPuissanceSuperieur1100cc(int nbrCC, double montantDeBase) {
        if (nbrCC > 1100) {
            montantDeBase += 1000;
        }
        return montantDeBase;
    }

    public double calculerLeRabaisOrdreIngQuebec(boolean membre_oiq, double montantDeBase) {
        if (membre_oiq == true) {
            montantDeBase -= montantDeBase * 0.10;
        }

        return montantDeBase;
    }
}
