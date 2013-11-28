package main.java.contrat;

public class Contrat {

    int dureeContrat;
    int jourDebut;
    int moisDebut;

    public Contrat(int dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public Contrat(int dureeContrat, int jourDebut, int moisDebut) {
        this.dureeContrat = dureeContrat;
        this.jourDebut = jourDebut;
        this.moisDebut = moisDebut;
    }

    public int getDureeContrat() {
        return dureeContrat;
    }

    public int getJourDebut() {
        return jourDebut;
    }

    public int getMoisDebut() {
        return moisDebut;
    }

    public boolean verifierDureeContrat() {
        boolean res = true;
        if (getDureeContrat() < 1 || getDureeContrat() > 3) {
            res = false;
        }
        return res;
    }
}
