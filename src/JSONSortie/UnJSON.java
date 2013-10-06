/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSortie;

import JSONEntree.JSONConducteur;
import JSONEntree.JSONContrat;
import JSONEntree.JSONVoiture;
import JSONEntree.LesDonnes;
import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import java.util.List;
import lesCalcules.LesCalcules;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import verifications.VerificationConducteur;
import verifications.VerificationFormatJSON;
import verifications.VerificationVoiture;
import voiture.InfoVoiture;
import voiture.Voiture;


public class UnJSON {

    public static JSONObject remplir() throws Exception {
        JSONObject res = new JSONObject();
        String marque = JSONVoiture.getMarque();
        int anneeVoiture = JSONVoiture.getAnnee();
        String modeleVoiture = JSONVoiture.getModele();
        double valeur = LesDonnes.getValeur(JSONVoiture.getModele());
        String dateNaissance = JSONConducteur.getDateDeNaissance();
        String province = JSONConducteur.getProvince();
        String ville = JSONConducteur.getVille();
        String sexe = JSONConducteur.getSexe();
        int dureeContrat = JSONContrat.getDureeContrat();
        String dateFinCours = JSONConducteur.getDateFinCoursDeConduite();
        boolean estCAA = JSONConducteur.estCoursDeConduiteReconnusParCAA();
        boolean estPremier = JSONConducteur.estPermierContrat();
        double valOption = JSONVoiture.getValeurDesOptions();
        String buriange = JSONVoiture.getBuriange();
        boolean garInter = JSONVoiture.getGarageInterieur();
        boolean sysAlarm = JSONVoiture.getSystemeAlarme();

        Voiture v = new Voiture(marque, anneeVoiture, modeleVoiture);
        Conducteur c = new Conducteur(dateNaissance, province, ville, sexe);
        Contrat con = new Contrat(dureeContrat);
        InfoConducteur infoc = new InfoConducteur(c, dateFinCours, estCAA, estPremier);
        InfoVoiture infov = new InfoVoiture(v, valOption, buriange, garInter, sysAlarm);

        VerificationConducteur vc = new VerificationConducteur(c);
        VerificationVoiture vv = new VerificationVoiture(v);
        LesCalcules a = new LesCalcules(infov, infoc, con, valeur);
        List formats = VerificationFormatJSON.getResultats(c.getDateDeNaissance(),
                infoc.getDateFinCoursDeConduite(), c.getSexe(), con.getDureeContrat());
        if (!formats.isEmpty()) {
            for (int i = 0; i < formats.size(); i++) {
                System.out.println(formats.get(i));
                res.put("méssage " + (i + 1), formats.get(i));
            }
        } else {
            if (vc.estAssurable() && vv.estAssurable()) {
                res.put("est_assurable", vc.estAssurable());
                res.put("montant_annuel", a.appliquer());
                res.put("mensualite", a.calculerMontantMensualite());

            } else {
                res.put("est_assurable", vc.estAssurable() && vv.estAssurable());
                JSONArray messages = new JSONArray();
                if (!vc.estAssurable()) {
                    if (!vc.estResideAuQuebec()) {
                        messages.add(" La province du conducteur n'est pas le Québec");
                    }
                    if (vc.estUnHommeMoins25()) {
                        messages.add("Le conducteur est un homme de moins de 25 ans");
                    }
                    if (vc.estUneFemmeMoins21()) {
                        messages.add("Le conducteur est une femme de moins de 21 ans.");
                    }
                    if (vc.estUnePersonnePlus75()) {
                        messages.add("Le conducteur est une personne de plus de 75 ans");
                    }
                }
                if (!vv.estAssurable()) {
                    if (!vv.verifierAnnee()) {
                        messages.add("L'annee de la voiture doit etre 2014");
                    }
                    if (!vv.verifierMarque()) {
                        messages.add("La marque de la voiture doit etre Porsche");
                    }
                    res.put("messages ", messages);
                }
            }
        }

        return res;
    }
}
