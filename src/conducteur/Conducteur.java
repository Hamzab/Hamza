/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conducteur;


public class Conducteur {

    String dateDeNaissance;
    String province;
    String ville;
    String sexe;

    public Conducteur(String dateDeNaissance, String province, String ville, String sexe) {
        this.dateDeNaissance = dateDeNaissance;
        this.province = province;
        this.ville = ville;
        this.sexe = sexe;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getProvince() {
        return province;
    }

    public String getVille() {
        return ville;
    }

    public String getSexe() {
        return sexe;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
