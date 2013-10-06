/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.util.Date;


public class LaDate {

    public static int getAnnees(String dateDeNaissance) {
        int anneeDeNaissance = Integer.parseInt(dateDeNaissance.substring(0, 4));
        int moisDeNaissance = Integer.parseInt(dateDeNaissance.substring(6, 7));
        int jourDeNaissance = Integer.parseInt(dateDeNaissance.substring(9, 10));
        Date maintenant = new Date();
        int ceMois = maintenant.getMonth() + 1;
        int cetteAnnee = maintenant.getYear() + 1900;
        int annees = cetteAnnee - anneeDeNaissance;

        if (moisDeNaissance > ceMois) {
            annees--;
        } else if (moisDeNaissance == ceMois) {
            int aujourdhui = maintenant.getDate();

            if (jourDeNaissance > aujourdhui) {
                annees--;
            }
        }
        return annees;
    }
}
