package jsonOutput;

import jsonInput.JSONConducteur;
import jsonInput.JSONContrat;
import jsonInput.JSONMotos;
import jsonInput.JSONVoiture;
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

    public boolean verifierBixetille(int annee, int mois, int jour) {
        boolean log = true;
        if (mois == 2 && jour > 28) {
            if (jour == 29) {
                if (annee % 4 != 0) {
                    log = false;
                }
            } else {
                log = false;
            }
        }
        return log;
    }

    public boolean estValideDate1(String date) {
        boolean res = true;
        int annee = Integer.parseInt(date.substring(0, 4));
        int mois = Integer.parseInt(date.substring(5, 7));
        int jour = Integer.parseInt(date.substring(8, 10));
        if (verifierBixetille(annee, mois, jour)) {
            res = estValideMoiJour(mois, jour);
        } else {
            res = false;
        }
        return res;
    }

    public boolean estValideDate(String date) {
        boolean res = true;
        if (estRespecterLaNormeISO(date)) {
            res = estValideDate1(date);
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

    public boolean estValide() {
        return !verifierFormatDate(jscont.getDateDebut()) || !verifierFormatDate(jscond.getDateFinCoursDeConduite())
                || !verifierFormatDate(jscond.getDateDeNaissance());
    }

    public JSONArray getMessagesValidation() {
        JSONArray messages = new JSONArray();
        if (estValide()) {
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

    public JSONArray getMessagesMotos() {
        for (int i = 0; i < jsmotos.getMotos().size(); i++) {
            jsmotos.getAnnee(i);
            jsmotos.getBuriange(i);
            jsmotos.getGarageInterieur(i);
            jsmotos.getModele(i);
            jsmotos.getMarque(i);
            jsmotos.getSystemeAlarme(i);
            jsmotos.getValeurDesOptions(i);
        }
        return jsmotos.getMessagesErreures();
    }

    public JSONArray getMessagesVoitures() {
        int size = jsvoit.getVoitures().size();
        for (int i = 0; i < size; i++) {
            jsvoit.getAnnee(i);
            jsvoit.getBuriange(i);
            jsvoit.getGarageInterieur(i);
            jsvoit.getModele(i);
            jsvoit.getMarque(i);
            jsvoit.getSystemeAlarme(i);
            jsvoit.getValeurDesOptions(i);
        }
        return jsvoit.getMessagesErreures();
    }

    public JSONArray ajouter(JSONArray liste, JSONArray listeAjoutee) {
        for (int i = 0; i < listeAjoutee.size(); i++) {
            liste.add(listeAjoutee.get(i));
        }
        return liste;
    }

    public JSONArray getMessagesErreures() {
        JSONArray listes = new JSONArray(), messagesCond = getMessagesConducteur(), messagesCont = getMessagesContrat();
        JSONArray messagesMotos = getMessagesMotos(), messagesVoitures = getMessagesVoitures();
        if (messagesCond.isEmpty() && messagesCont.isEmpty() && messagesMotos.isEmpty() && messagesVoitures.isEmpty()) {
            ajouter(listes, getMessagesValidation());
        } else {
            ajouter(listes, messagesCond);
            ajouter(listes, messagesCont);
            ajouter(listes, messagesMotos);
            ajouter(listes, messagesVoitures);
        }
        return listes;
    }
}
