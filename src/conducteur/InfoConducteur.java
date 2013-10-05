/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conducteur;

/**
 *
 * @author Hamza
 */
public class InfoConducteur {

    Conducteur conducteur;
    String dateFinCoursDeConduite;
    boolean coursDeConduiteReconnusParCAA;
    boolean premierContrat;

    public InfoConducteur(Conducteur conducteur, String dateFinCoursDeConduite,
            boolean coursDeConduiteReconnusParCAA, boolean premierContrat) {
        this.conducteur = conducteur;
        this.dateFinCoursDeConduite = dateFinCoursDeConduite;
        this.coursDeConduiteReconnusParCAA = coursDeConduiteReconnusParCAA;
        this.premierContrat = premierContrat;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public String getDateFinCoursDeConduite() {
        return dateFinCoursDeConduite;
    }

    public boolean isCoursDeConduiteReconnusParCAA() {
        return coursDeConduiteReconnusParCAA;
    }

    public boolean isPremierContrat() {
        return premierContrat;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public void setDateFinCoursDeConduite(String dateFinCoursDeConduite) {
        this.dateFinCoursDeConduite = dateFinCoursDeConduite;
    }

    public void setCoursDeConduiteReconnusParCAA(boolean coursDeConduiteReconnusParCAA) {
        this.coursDeConduiteReconnusParCAA = coursDeConduiteReconnusParCAA;
    }

    public void setPremierContrat(boolean premierContrat) {
        this.premierContrat = premierContrat;
    }
}
