package JSONSortie;

import JSONEntree.JSONConducteur;
import JSONEntree.JSONContrat;
import JSONEntree.JSONMotos;
import JSONEntree.JSONVoiture;
import contrat.Contrat;
import net.sf.json.JSONArray;

public class FormatJSON {

    JSONConducteur jscond;
    JSONContrat jscont;
    JSONMotos jsmotos;
    JSONVoiture jsvoit;

    public FormatJSON(JSONConducteur jscond, JSONContrat jscont, JSONMotos jsmotos, JSONVoiture jsvoit) {
        this.jscond = jscond;
        this.jscont = jscont;
        this.jsmotos = jsmotos;
        this.jsvoit = jsvoit;
    }

    public boolean estRespecterLaNormeISO(String uneDate) {
        return uneDate.length() == 10 && uneDate.charAt(4) == '-'
                && uneDate.charAt(7) == '-';
    }

    public boolean estValideMoiJour(int mois, int jour) {
        boolean res = true;
        if (mois < 1 || mois > 12 || jour < 1 || jour > 31) {
            res = false;
        }
        return res;
    }

    public boolean estValideDate(String uneDate) {
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

    public boolean verifierFormatDate(String uneDate) {
        boolean res = true;
        try {
            res = estValideDate(uneDate);
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public boolean verifierLeSexeCond(String sexe) {
        boolean res = true;
        if (!sexe.equals("F") && !sexe.equals("M")) {
            res = false;
        }
        return res;
    }

    public boolean verifierDureeContrat(int duree) {
        Contrat c = new Contrat(duree);
        return c.verifierDureeContrat();
    }

    public JSONArray valider() {
        JSONArray messages = new JSONArray();
        if (!verifierFormatDate(jscont.getDateDebut()) || !verifierFormatDate(jscond.getDateFinCoursDeConduite())
                || !verifierFormatDate(jscond.getDateDeNaissance())) {
            messages.add(" Les dates sont toujours dans le format ISO 8601.");
        }
        if (!verifierLeSexeCond(jscond.getSexe())) {
            messages.add("Le champ conducteur.sexe n'accepte que les valeurs 'M' et 'F'");
        }
        if (!verifierDureeContrat(jscont.getDureeContrat())) {
            messages.add(" Le champ duree_contrat n'accepte que les valeurs 1, 2 et 3.");
        }
        return messages;
    }

    public JSONArray getMessagesConducteur() {
        jscond.getDateDeNaissance();
        jscond.getDateFinCoursDeConduite();
        jscond.estCoursDeConduiteReconnusParCAA();
        jscond.estMembreOiq();
        jscond.estPermierContrat();
        jscond.getVille();
        jscond.getSexe();
        jscond.getProvince();
        return jscond.getMessagesErreurs();
    }

    public JSONArray getMessagesContrat() {
        jscont.getDateDebut();
        jscont.getDureeContrat();
        return jscont.getMessagesErreurs();
    }

    public JSONArray ajouter(JSONArray liste, JSONArray listeAjoutee) {
        for (int i = 0; i < listeAjoutee.size(); i++) {
            liste.add(listeAjoutee.get(i));
        }
        return liste;
    }

    public JSONArray getMessagesErreures() {
        JSONArray listes = new JSONArray();
        JSONArray messagesCond = getMessagesConducteur();
        JSONArray messagesCont = getMessagesContrat();
        if (messagesCond.isEmpty() && messagesCont.isEmpty()) {
            ajouter(listes, valider());
        } else {
            ajouter(listes, messagesCond);
            ajouter(listes, messagesCont);
        }


        return listes;
    }
}
