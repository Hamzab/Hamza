package contrat;

public class Contrat {

    int dureeContrat;

    public Contrat(int dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public int getDureeContrat() {
        return dureeContrat;
    }

    public boolean verifierDureeContrat() {
        boolean res = true;
        if (getDureeContrat() < 1 || getDureeContrat() > 3) {
            res = false;
        }
        return res;
    }
}
