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
 
    boolean estReconnusParCAA;
    boolean premierContrat;
    boolean membre_oiq;
    public InfoConducteur(Conducteur conducteur, String dateFinCoursDeConduite,
            boolean estReconnusParCAA, boolean premierContrat,boolean membre_oiq) {
        this.conducteur = conducteur;
        this.dateFinCoursDeConduite = dateFinCoursDeConduite;
        this.estReconnusParCAA = estReconnusParCAA;
        this.premierContrat = premierContrat;
        this.membre_oiq=membre_oiq;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public String getDateFinCoursDeConduite() {
        return dateFinCoursDeConduite;
    }

    public boolean estReconnusParCAA() {
        return estReconnusParCAA;
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

    public void estReconnusParCAA(boolean estReconnusParCAA) {
        this.estReconnusParCAA = estReconnusParCAA;
    }

    public void setPremierContrat(boolean premierContrat) {
        this.premierContrat = premierContrat;
    }
    public boolean estUnMembre_oiq(){
      return membre_oiq;  
    }
}
