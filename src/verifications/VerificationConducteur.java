/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verifications;

import conducteur.Conducteur;
import date.LaDate;


public class VerificationConducteur {

    Conducteur conducteur;

    public VerificationConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public boolean estResideAuQuebec() {
        String pro = conducteur.getProvince();
        boolean res = false;
        if (pro.equals("Québec")) {
            res = true;
        }
        return res;
    }

    public boolean estUnHommeMoins25() {
        String dateNaissance = conducteur.getDateDeNaissance();
        boolean res = false;
        if (conducteur.getSexe().equals("M") && LaDate.getAnnees(dateNaissance) < 25) {
            res = true;
        }
        return res;
    }

    public boolean estUneFemmeMoins21() {
        String dateNaissance = conducteur.getDateDeNaissance();
        boolean res = false;
        if (conducteur.getSexe().equals("F") && LaDate.getAnnees(dateNaissance) < 21) {
            res = true;
        }
        return res;
    }

    public boolean estUnePersonnePlus75() {
        String dateNaissance = conducteur.getDateDeNaissance();
        boolean res = false;
        if ((conducteur.getSexe().equals("M") || conducteur.getSexe().equals("F"))
                && LaDate.getAnnees(dateNaissance) > 75) {
            res = true;
        }
        return res;
    }

    public boolean estAssurable() {
        boolean res = true;
        if (estUnHommeMoins25() || estUneFemmeMoins21() || estUnePersonnePlus75()
                || !estResideAuQuebec()) {
            res = false;
        }
        return res;
    }
}
