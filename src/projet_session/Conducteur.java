/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_session;

/**
 *
 * @author rafikgharsalli
 */
public class Conducteur {
    String dateNaissance ;
    String province;
    String ville;
    String sex;
    String dateFinCours;
    Boolean premierContrat;

    public Conducteur(String dateNaissance, String province, String ville, 
                      String sex, String dateFinCours, Boolean premierContrat){
        this.dateNaissance = dateNaissance;
        this.province = province;
        this.ville = ville;
        this.sex = sex;
        this.dateFinCours = dateFinCours;
        this.premierContrat = premierContrat;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateFinCours() {
        return dateFinCours;
    }

    public void setDateFinCours(String dateFinCours) {
        this.dateFinCours = dateFinCours;
    }

    public Boolean getPremierContrat() {
        return premierContrat;
    }

    public void setPremierContrat(Boolean premierContrat) {
        this.premierContrat = premierContrat;
    }

    @Override
    public String toString() {
        return "Conducteur{" + "dateNaissance=" + dateNaissance + ", province=" + province + ", ville=" + ville + ", sex=" + sex + ", dateFinCours=" + dateFinCours + ", premierContrat=" + premierContrat + '}';
    }
    
    
    
    
    
    
    
    
}
