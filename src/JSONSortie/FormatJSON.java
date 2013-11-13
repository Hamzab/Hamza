package JSONSortie;

import contrat.Contrat;
import net.sf.json.JSONArray;

public class FormatJSON {

    public static boolean estRespecterLaNormeISO(String uneDate) {
        return uneDate.length() == 10 && uneDate.charAt(4) == '-'
                && uneDate.charAt(7) == '-';
    }

    public static boolean estValideMoiJour(int mois, int jour) {
        boolean res = true;
        if (mois < 1 || mois > 12 || jour < 1 || jour > 31) {
            res = false;
        }
        return res;
    }

    public static boolean estValideDate(String uneDate) {
        boolean res = true;
        if (estRespecterLaNormeISO(uneDate)) {
            int annee = Integer.parseInt(uneDate.substring(0, 4));
            int mois = Integer.parseInt(uneDate.substring(5, 7));
            int jour = Integer.parseInt(uneDate.substring(8, 10));
            res = estValideMoiJour(mois, jour);
        } else {
            res = false;
        }
        return res;
    }

    public static boolean verifierFormatDate(String uneDate) {
        boolean res = true;
        try {
            res = estValideDate(uneDate);
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static boolean verifierLeSexeCond(String sexe) {
        boolean res = true;
        if (!sexe.equals("F") && !sexe.equals("M")) {
            res = false;
        }
        return res;
    }

    public static boolean verifierDureeContrat(int duree) {
        Contrat c = new Contrat(duree);
        return c.verifierDureeContrat();
    }

    public static JSONArray getMessagesErreures(String dateDebut,String dateNaissance, String dateFinCours, String sexe, int duree) {
        JSONArray messages = new JSONArray();
        if (!verifierFormatDate(dateDebut) || !verifierFormatDate(dateFinCours)
                || !verifierFormatDate(dateNaissance)) {
            messages.add(" Les dates sont toujours dans le format ISO 8601.");
        }
        if (!verifierLeSexeCond(sexe)) {
            messages.add("Le champ conducteur.sexe n'accepte que les valeurs 'M' et 'F'");
        }
        if (!verifierDureeContrat(duree)) {
            messages.add(" Le champ duree_contrat n'accepte que les valeurs 1, 2 et 3.");
        }
        return messages;
    }
}
