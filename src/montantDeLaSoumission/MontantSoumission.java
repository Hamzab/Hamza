package montantDeLaSoumission;

import date.Date1;

public class MontantSoumission {

    double montant;

    public MontantSoumission(double montant) {

        this.montant = montant;

    }

    public double getMontant() {

        return montant;

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
    /*
     * . Le pourcentage du montant de base est calculé en fonction de 
     *      l'âge et du sexe de l'assuré.
     */

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
         if (montant > 500000) {
             res += 2500;
        } 
        return res;
    }

    public double ajouterValeursDesOptions(double valeurDesOptions, double montantDeBase) {
        montantDeBase += (valeurDesOptions * 0.10);

        return montantDeBase;
    }

    public double ajouterMontantVille(String ville, double montantDeSoumission) {
        if (ville.equals("Montréal") || ville.equals("Longueuil")) {
            montantDeSoumission += 200.0;
        }

        return montantDeSoumission;
    }

    public double retirerMontantBurinage(String burinage, double montantDeSoumission) {
        if (burinage.equals("Sherlock")) {
            montantDeSoumission -= 250.0;
        }

        return montantDeSoumission;
    }

    public double retirerMontantGarageInterieur(boolean estInterieur, double montantDeSoumission) {
        if (estInterieur == true) {
            montantDeSoumission -= 500.0;
        }

        return montantDeSoumission;
    }

    public double retirerMontantSystemAlarme(boolean estSysAlarme, double montantDeSoumission) {

        if (estSysAlarme == true) {
            montantDeSoumission -= 500.0;
        }

        return montantDeSoumission;
    }

    public double retirerMontantCoursCAA(boolean estCoursCAA, double montantDeSoumission) {
        if (estCoursCAA == true) {
            montantDeSoumission -= 100.0;
        }

        return montantDeSoumission;
    }

    public double ajouterMontantPremierContrat(boolean estPremierContrat, double montantDeSoumission) {
        if (estPremierContrat == true) {
            montantDeSoumission += 2000.0;
        }

        return montantDeSoumission;
    }

    public double retirerMontantExperience15Ans(String dateFinCours, double montantDeSoumission) {
        Date1 date=new Date1(dateFinCours);
        int anneesExperience = date.getAnnees();
        if (anneesExperience > 15) {
            montantDeSoumission -= 400.0;
        }

        return montantDeSoumission;
    }

    public double ajouterPuissanceSuperieur1100cc(int nbrCC, double montantDeSoumission) {
        if (nbrCC > 1100) {
            montantDeSoumission += 1000;
        }
        return montantDeSoumission;
    }

    public double calculerLeRabaisOrdreIngQuebec(boolean membre_oiq, double montantDeSoumission) {
        if (membre_oiq == true) {
            montantDeSoumission -= montantDeSoumission * 0.10;
        }

        return montantDeSoumission;
    }

    public double calculerLeRabaisDuNovembre(int jour, int mois, double montantDeSoumission) {
        if (mois == 11 && (jour >= 1 && jour <= 15)) {
            
            montantDeSoumission -= montantDeSoumission * 0.1;
        }
        return montantDeSoumission;
    }

    public double calculerLeRabaisDuFevrier(int jour, int mois, double montantDeSoumission) {
        if (mois == 2 && (jour >= 14 && jour <= 29)) {
            montantDeSoumission -= montantDeSoumission * 0.05;
        }
        if(mois == 3 && (jour >= 1 && jour <= 3)){
           montantDeSoumission -= montantDeSoumission * 0.05;  
        }
        return montantDeSoumission;
    }
}
