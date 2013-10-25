
package JSONSortie;

import JSONEntree.JSONConducteur;
import JSONEntree.JSONContrat;
import JSONEntree.JSONMotos;
import JSONEntree.JSONVoiture;
import JSONEntree.LesDonnes;
import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import date.LaDate;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import lesCalcules.LesCalcules;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import voiture.*;


public class UnJSON {
    public Vehicule getTypeVehicule(String type, int annee, String marque, String modele) {
        Vehicule v = null;
        if (type.equals("voitures")) {
            v = new Voiture(annee, marque, modele);
        } else if (type.equals("motos")) {
            v = new Moto(annee, marque, modele);
        }
        return v;
    }

    public static int getSizeVehicules(String type) throws Exception {
        int size = 0;
        if (type.equals("voitures")) {
            size = LesDonnes.getDataVihecules(type).size();
        } else if (type.equals("motos")) {
            size = LesDonnes.getDataVihecules(type).size();
        }
        return size;
    }

    public static boolean estAssurableUneVehicule(String type, Vehicule v) throws Exception {

        int length = getSizeVehicules(type);
        boolean res = false;
        for (int i = 0; i < length; i++) {
            if (v.estAssurable(LesDonnes.getAnnees(type).get(i), LesDonnes.getMarques(type).get(i), LesDonnes.getModeles(type).get(i))) {
                res = true;
            }
        }
        return res;

    }

    public static boolean estAssurablePlusieursVehicules(String type, List<Vehicule> vehicules) throws Exception {
        boolean res = true;
        for (int i = 0; i < vehicules.size(); i++) {
            if (!estAssurableUneVehicule(type, vehicules.get(i))) {
                res = false;
            }
        }
        return res;
    }

    public static boolean estAssurablePlusieursVoitures() throws Exception {
        List<Vehicule> voitures = new ArrayList<Vehicule>();
        int length = JSONVoiture.getVoitures().size();
        for (int i = 0; i < length; i++) {
            Vehicule v = new Voiture(JSONVoiture.getAnnee(i), JSONVoiture.getMarque(i), JSONVoiture.getModele(i));
            voitures.add(v);
        }
        return estAssurablePlusieursVehicules("voitures", voitures);
    }

    public static boolean estAssurablePlusieursMotos() throws Exception {
        List<Vehicule> motos = new ArrayList<Vehicule>();
        int length = JSONMotos.getMotos().size();
        for (int i = 0; i < length; i++) {
            Vehicule v = new Moto(JSONMotos.getAnnee(i), JSONMotos.getMarque(i), JSONMotos.getModele(i));
            motos.add(v);
        }
        return estAssurablePlusieursVehicules("motos", motos);
    }

    public static boolean estAssurableToutLesVehicules() throws Exception {
        boolean estVoitures = estAssurablePlusieursVoitures();
        boolean estMotos = estAssurablePlusieursMotos();
        return estVoitures && estMotos;
    }

    public static boolean estAssurableConducteur() throws Exception {
        int age = LaDate.getAnnees(JSONConducteur.getDateDeNaissance());
        String sexe = JSONConducteur.getSexe();
        String provence = JSONConducteur.getProvince();
        String ville = JSONConducteur.getVille();
        Conducteur cond = new Conducteur(age, provence, ville, sexe);
        return cond.estAssurable();
    }

    public static boolean estAssurable() throws Exception {
        boolean estVehicule = estAssurableToutLesVehicules();
        boolean estConducteur = estAssurableConducteur();
        return estConducteur && estVehicule;
    }

    public static InfoConducteur getInfoConducteur() throws Exception {
        String dateNaissance = JSONConducteur.getDateDeNaissance();
        String province = JSONConducteur.getProvince();
        String ville = JSONConducteur.getVille();
        String sexe = JSONConducteur.getSexe();
        String dateFinCours = JSONConducteur.getDateFinCoursDeConduite();
        boolean estCAA = JSONConducteur.estCoursDeConduiteReconnusParCAA();
        boolean estPremier = JSONConducteur.estPermierContrat();
        boolean membre_oiq = JSONConducteur.estMembreOiq();
        Conducteur c = new Conducteur(LaDate.getAnnees(dateNaissance), province, ville, sexe);
        InfoConducteur infoc = new InfoConducteur(c, dateFinCours, estCAA, estPremier, membre_oiq);
        return infoc;
    }

    public static InfoVehicule getInfoVoiture(int indice) throws Exception {
        int anneeVoiture = JSONVoiture.getAnnee(indice);
        String marqueVoiture = JSONVoiture.getMarque(indice);
        String modeleVoiture = JSONVoiture.getModele(indice);
        Vehicule v = new Voiture(anneeVoiture, marqueVoiture, modeleVoiture);
        double valOptionVoiture = JSONVoiture.getValeurDesOptions(indice);
        String buriangeVoiture = JSONVoiture.getBuriange(indice);
        boolean garInterVoiture = JSONVoiture.getGarageInterieur(indice);
        boolean sysAlarmVoiture = JSONVoiture.getSystemeAlarme(indice);
        InfoVehicule infov = new InfoVoiture(v, valOptionVoiture, 0, buriangeVoiture, garInterVoiture, sysAlarmVoiture);
        return infov;
    }

    public static InfoVehicule getInfoMoto(int indice) throws Exception {
        double valOptionMoto = JSONMotos.getValeurDesOptions(indice);
        int valeurCC = LesDonnes.getValeurCC(JSONMotos.getModele(indice));
        String buriangeMoto = JSONMotos.getBuriange(indice);
        boolean garInterMoto = JSONMotos.getGarageInterieur(indice);
        boolean sysAlarmMoto = JSONMotos.getSystemeAlarme(indice);
        Vehicule m = new Moto(JSONMotos.getAnnee(indice), JSONMotos.getMarque(indice), JSONMotos.getModele(indice));
        InfoVehicule infoMoto = new InfoMoto(m, valOptionMoto, valeurCC, buriangeMoto, garInterMoto, sysAlarmMoto);
        return infoMoto;
    }

    public static Contrat getInfoContrat() throws Exception {
        int dureeContrat = JSONContrat.getDureeContrat();
        return new Contrat(dureeContrat);
    }

    public static double getCalculeVoitures() throws Exception {
        int taille = JSONVoiture.getVoitures().size();
        double res = 0.0;
        for (int i = 0; i < taille; i++) {
            InfoConducteur infoc = getInfoConducteur();
            Contrat con = getInfoContrat();
            InfoVehicule infov = getInfoVoiture(i);
            double valeurVoiture = LesDonnes.getValeur(JSONVoiture.getModele(i), "voitures");
            LesCalcules lesCalcules = new LesCalcules(infov, infoc, con, valeurVoiture);
            res += lesCalcules.appliquer("voitures");
        }
        return res;
    }

    public static double getCalculeMotos() throws Exception {
        int taille = JSONMotos.getMotos().size();
        double res = 0.0;
        for (int i = 0; i < taille; i++) {
            InfoConducteur infoc = getInfoConducteur();
            Contrat con = getInfoContrat();
            InfoVehicule infov = getInfoMoto(i);
            double valeurMotos = LesDonnes.getValeur(JSONMotos.getModele(i), "motos");
            LesCalcules lesCalcules = new LesCalcules(infov, infoc, con, valeurMotos);
            res += lesCalcules.appliquer("motos");
        }
        return res;
    }

    public static double getCalculeToutVehicules() throws Exception {
        return getCalculeVoitures() + getCalculeMotos();
    }

    public static double calculerMontantMensualite() throws Exception {
        double montant = getCalculeToutVehicules();
        return (montant + montant * 0.015) / 12;
    }

    public static JSONArray getMessagesValidationJSON() throws Exception {
        String dateNaissance = JSONConducteur.getDateDeNaissance();
        String sexe = JSONConducteur.getSexe();
        String dateFinCours = JSONConducteur.getDateFinCoursDeConduite();
        int duree = JSONContrat.getDureeContrat();
        return FormatJSON.getResultats(dateNaissance, dateFinCours, sexe, duree);
    }

    public static JSONObject remplirUnJSON(boolean estAssurable) throws Exception {
        JSONObject res = new JSONObject();
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dcmlFS = new DecimalFormatSymbols();
        dcmlFS.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dcmlFS);
        double resAnnuel = getCalculeToutVehicules();
        double resMonsual = calculerMontantMensualite();
        res.put("est_assurable", estAssurable);
        res.put("montant_annuel", Double.parseDouble(df.format(resAnnuel)));
        res.put("mensualite", Double.parseDouble(df.format(resMonsual)));
        return res;
    }

    public static JSONObject retournerUnJSON() throws Exception {
        JSONObject res = new JSONObject();
        boolean estAssurable = estAssurable();
        JSONArray messages = getMessagesValidationJSON();
        if (messages.size() == 0) {
            if (estAssurable) {
                res = remplirUnJSON(estAssurable);
            }
        } else {
            res.put("messages", messages);
        }
        return res;
    }
}
