package jsonOutput;

import jsonInput.JSONConducteur;
import jsonInput.JSONContrat;
import jsonInput.JSONVoiture;
import jsonInput.Donnes;
import jsonInput.JSON_Input;
import jsonInput.JSONMotos;
import conducteur.Conducteur;
import conducteur.InfoConducteur;
import contrat.Contrat;
import dateContrat.Date1;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import montantDeLaSoumission.Calcules;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import statistiques.Statistiques;
import voiture.*;

public class JSON_Output {

    JSONConducteur jsonCond = new JSONConducteur();
    JSONContrat jsonContrat = new JSONContrat();
    JSONVoiture jsonVoiture = new JSONVoiture();
    JSONMotos jsonMotos = new JSONMotos();
    JSONArray messages = new JSONArray();
    static Statistiques stats = new Statistiques();
    Donnes lesdonnees = new Donnes();
    static int nombreSoumission = 0;
    static int nombreSoumissionNonAssurable = 0;
    static int nombreSoumissionAssurable = 0;
    static int nombreSoumissionHomme = 0;
    static int nombreSoumissionFemme = 0;
    static int nombreDeVehicules = 0;
    static int nombreVoituresAssurable = 0;
    static int nombreMotosAssurable = 0;
    static int nombrePorsche = 0;
    static int nombreMaserati = 0;
    static int nombreDucati = 0;
    static int nombreFerrari = 0;
    static int tmpNombreDeVehicules = 0;
    static int tmpNombreVoituresAssurable = 0;
    static int tmpNombreMotosAssurable = 0;
    static int tmpNombrePorsche = 0;
    static int tmpNombreMaserati = 0;
    static int tmpNombreDucati = 0;
    static int tmpNombreFerrari = 0;

    public JSON_Output() {
    }

    public void getAncienValeurNombres(JSONObject ob) {
        nombreSoumission = ob.getInt("nombre_de_soumissions");
        nombreSoumissionNonAssurable = ob.getInt("nombre_de_soumissions_non_assurables");
        nombreSoumissionAssurable = ob.getInt("nombre_de_soumissions_assurables");
        nombreSoumissionHomme = ob.getInt("nombre_de_soumissions_hommes");
        nombreSoumissionFemme = ob.getInt("nombre_de_soumissions_femmes");
        nombreDeVehicules = ob.getInt("nombre_de_vehicules");
        nombreVoituresAssurable = ob.getInt("nombre_de_voitures_assurables");
        nombreMotosAssurable = ob.getInt("nombre_de_motos_assurables");
    }

    public void getAncienValeurMarques(JSONArray liste) {
        nombrePorsche = liste.getJSONObject(0).getInt("nombre");
        nombreMaserati = liste.getJSONObject(1).getInt("nombre");
        nombreFerrari = liste.getJSONObject(2).getInt("nombre");
        nombreDucati = liste.getJSONObject(3).getInt("nombre");
    }

    public void initialiser() {
        JSON_Input jsinput = new JSON_Input();
        JSONObject ob = jsinput.getJsonStats();
        if (jsinput.validerStats()) {
            getAncienValeurNombres(ob);
            JSONArray liste = ob.getJSONArray("vehicules_par_marque");
            getAncienValeurMarques(liste);
        }
    }

    public int getSizeVehicules(String type) throws Exception {
        int size = 0;
        if (type.equals("voitures")) {
            size = lesdonnees.getDataVihecules(type).size();
        } else if (type.equals("motos")) {
            size = lesdonnees.getDataVihecules(type).size();
        }
        return size;
    }

    public boolean estExistVehicule(String type, InfoVehicule v) throws Exception {
        int length = getSizeVehicules(type);
        boolean res = false;
        for (int i = 0; i < length; i++) {
            String unModele = lesdonnees.getModeles(type).get(i);
            if (v.estAssurable(lesdonnees.getAnnees(type).get(i), lesdonnees.getMarques(type).get(i), unModele,
                    lesdonnees.getValeur(unModele, type))) {
                res = true;
            }
        }
        return res;
    }

    public boolean estAssurableUneVehicule(String type, InfoVehicule v) throws Exception {
        boolean res = estExistVehicule(type, v);
        if (!res) {
            messages.add("la vehicule " + v.getVehicule().getMarque() + " " + v.getVehicule().getModele()
                    + " " + v.getVehicule().getAnnee() + " n'est pas assurable");
        }
        return res;

    }

    public boolean estAssurablePlusieursVehicules(String type, List<InfoVehicule> vehicules) throws Exception {
        boolean res = true;
        for (int i = 0; i < vehicules.size(); i++) {
            tmpNombreDeVehicules++;
            if (!estAssurableUneVehicule(type, vehicules.get(i))) {
                res = false;
            }
            if (res == false) {
            }
        }
        return res;
    }

    public void incrementerNombresParMarque(String marque) {
        if (marque.equals("Porsche")) {
            tmpNombrePorsche++;
        } else if (marque.equals("Maserati")) {
            tmpNombreMaserati++;
        } else if (marque.equals("Ferrari")) {
            tmpNombreFerrari++;
        }
    }

    public boolean estAssurablePlusieursVoitures() throws Exception {
        List<InfoVehicule> infovoitures = new ArrayList<InfoVehicule>();
        int length = jsonVoiture.getVoitures().size();
        for (int i = 0; i < length; i++) {
            Vehicule v = new Voiture(jsonVoiture.getAnnee(i), jsonVoiture.getMarque(i), jsonVoiture.getModele(i));
            InfoVehicule infov = new InfoVoiture(v, jsonVoiture.getValeurDesOptions(i), 0, jsonVoiture.getBuriange(i),
                    jsonVoiture.getGarageInterieur(i), jsonVoiture.getSystemeAlarme(i));
            tmpNombreVoituresAssurable++;
            incrementerNombresParMarque(jsonVoiture.getMarque(i));
            infovoitures.add(infov);
        }
        return estAssurablePlusieursVehicules("voitures", infovoitures);
    }

    public void incrementerNombreMotosAssurable(int length, List<InfoVehicule> infomotos) throws Exception {
        for (int i = 0; i < length; i++) {
            String modele = jsonMotos.getModele(i);
            int valeurCC = lesdonnees.getValeurCC(modele);
            Vehicule v = new Moto(jsonMotos.getAnnee(i), jsonMotos.getMarque(i), modele);
            tmpNombreMotosAssurable++;
            if (jsonMotos.getMarque(i).equals("Ducati")) {
                tmpNombreDucati++;
            }
            infomotos.add(new InfoMoto(v, jsonMotos.getValeurDesOptions(i), valeurCC, jsonMotos.getBuriange(i),
                    jsonMotos.getGarageInterieur(i), jsonMotos.getSystemeAlarme(i)));
        }
    }

    public boolean estAssurablePlusieursMotos() throws Exception {
        List<InfoVehicule> infomotos = new ArrayList<InfoVehicule>();
        int length = jsonMotos.getMotos().size();
        incrementerNombreMotosAssurable(length, infomotos);
        return estAssurablePlusieursVehicules("motos", infomotos);
    }

    public void ajouterStatsVoiture() {
        nombreVoituresAssurable += tmpNombreVoituresAssurable;
        nombreMotosAssurable += tmpNombreMotosAssurable;
        nombrePorsche += tmpNombrePorsche;
        nombreMaserati += tmpNombreMaserati;
        nombreDucati += tmpNombreDucati;
        nombreFerrari += tmpNombreFerrari;
    }

    public boolean estAssurableToutLesVehicules() throws Exception {
        boolean res = true, estVoitures = estAssurablePlusieursVoitures(), estMotos = estAssurablePlusieursMotos();
        if (estAssurableConducteur()) {
            if (estVoitures && estMotos) {
                ajouterStatsVoiture();
            }
            res = estVoitures && estMotos;
        } else {
            res = false;
        }
        return res;
    }

    public boolean estAssurableConducteur() throws Exception {
        Date1 date = new Date1(jsonCond.getDateDeNaissance());
        int age = date.getAnnees();
        String sexe = jsonCond.getSexe();
        if (sexe.equals("M")) {
            nombreSoumissionHomme++;
        } else {
            nombreSoumissionFemme++;
        }
        String provence = jsonCond.getProvince(), ville = jsonCond.getVille();
        Conducteur cond = new Conducteur(age, provence, ville, sexe);
        return cond.estAssurable();
    }

    public boolean estAssurable() throws Exception {
        boolean estVehicule = estAssurableToutLesVehicules();
        nombreDeVehicules += tmpNombreDeVehicules;
        return estVehicule;
    }

    public InfoConducteur getInfoConducteur() throws Exception {
        String dateNaissance = jsonCond.getDateDeNaissance(), province = jsonCond.getProvince();
        String ville = jsonCond.getVille(), sexe = jsonCond.getSexe();
        Date1 date = new Date1(dateNaissance);
        String dateFinCours = jsonCond.getDateFinCoursDeConduite();
        boolean estCAA = jsonCond.estCoursDeConduiteReconnusParCAA();
        boolean estPremier = jsonCond.estPermierContrat();
        boolean membre_oiq = jsonCond.estMembreOiq();
        Conducteur c = new Conducteur(date.getAnnees(), province, ville, sexe);
        InfoConducteur infoc = new InfoConducteur(c, dateFinCours, estCAA, estPremier, membre_oiq);
        return infoc;
    }

    public InfoVehicule getInfoVoiture(int indice) throws Exception {
        int anneeVoiture = jsonVoiture.getAnnee(indice);
        String marqueVoiture = jsonVoiture.getMarque(indice);
        String modeleVoiture = jsonVoiture.getModele(indice);
        Vehicule v = new Voiture(anneeVoiture, marqueVoiture, modeleVoiture);
        double valOptionVoiture = jsonVoiture.getValeurDesOptions(indice);
        String buriangeVoiture = jsonVoiture.getBuriange(indice);
        boolean garInterVoiture = jsonVoiture.getGarageInterieur(indice);
        boolean sysAlarmVoiture = jsonVoiture.getSystemeAlarme(indice);
        InfoVehicule infov = new InfoVoiture(v, valOptionVoiture, 0, buriangeVoiture, garInterVoiture, sysAlarmVoiture);
        return infov;
    }

    public InfoVehicule getInfoMoto(int indice) throws Exception {
        double valOptionMoto = jsonMotos.getValeurDesOptions(indice);
        int valeurCC = lesdonnees.getValeurCC(jsonMotos.getModele(indice));
        String buriangeMoto = jsonMotos.getBuriange(indice);
        boolean garInterMoto = jsonMotos.getGarageInterieur(indice);
        boolean sysAlarmMoto = jsonMotos.getSystemeAlarme(indice);
        Vehicule m = new Moto(jsonMotos.getAnnee(indice), jsonMotos.getMarque(indice), jsonMotos.getModele(indice));
        InfoVehicule infoMoto = new InfoMoto(m, valOptionMoto, valeurCC, buriangeMoto, garInterMoto, sysAlarmMoto);
        return infoMoto;
    }

    public Contrat getInfoContrat() throws Exception {
        int dureeContrat = jsonContrat.getDureeContrat();
        Date1 date = new Date1(jsonContrat.getDateDebut());
        int jourDebut = date.getJourDeNaissance();
        int moisDebut = date.getMoisDeNaissance();
        return new Contrat(dureeContrat, jourDebut, moisDebut);
    }

    public double getCalculeVoitures() throws Exception {
        int taille = jsonVoiture.getVoitures().size();
        double res = 0.0;
        for (int i = 0; i < taille; i++) {
            InfoConducteur infoc = getInfoConducteur();
            Contrat con = getInfoContrat();
            InfoVehicule infov = getInfoVoiture(i);
            double valeurVoiture = lesdonnees.getValeur(jsonVoiture.getModele(i), "voitures");
            Calcules lesCalcules = new Calcules(infov, infoc, con, valeurVoiture);
            res += lesCalcules.appliquer("voitures");
        }
        return res;
    }

    public double getCalculeMotos() throws Exception {
        int taille = jsonMotos.getMotos().size();
        double res = 0.0;
        for (int i = 0; i < taille; i++) {
            InfoConducteur infoc = getInfoConducteur();
            Contrat con = getInfoContrat();
            InfoVehicule infov = getInfoMoto(i);
            double valeurMotos = lesdonnees.getValeur(jsonMotos.getModele(i), "motos");
            Calcules lesCalcules = new Calcules(infov, infoc, con, valeurMotos);
            res += lesCalcules.appliquer("motos");
        }
        return res;
    }

    public double getCalculeToutVehicules() throws Exception {
        return getCalculeVoitures() + getCalculeMotos();
    }

    public JSONArray getMessagesValidationJSON() throws Exception {
        FormatJSON jsf = new FormatJSON(jsonCond, jsonContrat, jsonMotos, jsonVoiture);
        return jsf.getMessagesErreures();
    }

    public JSONObject remplirUnJSON(boolean estAssurable) throws Exception {
        JSONObject res = new JSONObject();
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dcmlFS = new DecimalFormatSymbols();
        dcmlFS.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dcmlFS);
        double resAnnuel = getCalculeToutVehicules();
        double resMonsual = (resAnnuel + resAnnuel * 0.015) / 12;
        res.put("assurable", estAssurable);
        res.put("montant_annuel", Double.parseDouble(df.format(resAnnuel)));
        res.put("mensualite", Double.parseDouble(df.format(resMonsual)));
        return res;
    }

    public JSONArray getMessagesAssurableConducteur() {
        Conducteur c = new Conducteur(new Date1(jsonCond.getDateDeNaissance()).getAnnees(),
                jsonCond.getProvince(), jsonCond.getVille(), jsonCond.getSexe());
        JSONArray messageCond = c.getMessageAssurable();

        return messageCond;
    }

    public JSONArray ajouterMessages(JSONArray liste, JSONArray liseAjoutee) {
        for (int i = 0; i < liseAjoutee.size(); i++) {
            liste.add(liseAjoutee.get(i));
            System.out.println("mm " + liseAjoutee.get(i));
        }
        return liste;
    }

    public JSONArray getMessagesAssurable() throws Exception {
        JSONArray messageCond = getMessagesAssurableConducteur();
        ajouterMessages(messages, messageCond);
        return messages;
    }

    public JSONObject incrementerNombresSoumissionsAssur(boolean estAssurable) throws Exception {
        nombreSoumissionAssurable++;
        return remplirUnJSON(estAssurable);
    }

    public JSONObject getResultat() throws Exception {
        JSONObject res = new JSONObject();
        boolean estAssurable = estAssurable();
        nombreSoumission++;
        if (estAssurable) {
            res = incrementerNombresSoumissionsAssur(estAssurable);
        } else {
            nombreSoumissionNonAssurable++;
            res.put("assurable", estAssurable);
            res.put("messages", getMessagesAssurable());
        }
        return res;
    }

    public JSONObject retournerUnJSON() throws Exception {
        JSONObject res = new JSONObject();
        JSONArray messages = getMessagesValidationJSON();
        if (messages.isEmpty()) {
            res = getResultat();
        } else {
            res.put("messages", messages); // un json n'est pas valide
        }
        return res;
    }

    public void putStats(JSONObject statsModifer) {
        statsModifer.put("nombre_de_soumissions", nombreSoumission);
        statsModifer.put("nombre_de_soumissions_non_assurables", nombreSoumissionNonAssurable);
        statsModifer.put("nombre_de_soumissions_assurables", nombreSoumissionAssurable);
        statsModifer.put("nombre_de_soumissions_hommes", nombreSoumissionHomme);
        statsModifer.put("nombre_de_soumissions_femmes", nombreSoumissionFemme);
        statsModifer.put("nombre_de_vehicules", nombreDeVehicules);
        statsModifer.put("nombre_de_voitures_assurables", nombreVoituresAssurable);
        statsModifer.put("nombre_de_motos_assurables", nombreMotosAssurable);
    }

    public void putStatsVehicule(JSONObject porsche, JSONObject maseratie,
            JSONObject ducati, JSONObject ferrari) {
        porsche.put("marque", "Porsche");
        porsche.put("nombre", nombrePorsche);
        maseratie.put("marque", "Maserati");
        maseratie.put("nombre", nombreMaserati);
        ducati.put("marque", "Ducati");
        ducati.put("nombre", nombreDucati);
        ferrari.put("marque", "Ferrari");
        ferrari.put("nombre", nombreFerrari);
    }

    public void putMarquesListe(JSONArray listeMarques, JSONObject porsche,
            JSONObject maseratie, JSONObject ducati, JSONObject ferrari) {
        listeMarques.add(porsche);
        listeMarques.add(maseratie);
        listeMarques.add(ferrari);
        listeMarques.add(ducati);
    }

    public JSONObject getStats() {
        JSONObject statsModifer = new JSONObject(), porsche = new JSONObject(),
                maseratie = new JSONObject();
        JSONObject ducati = new JSONObject(), ferrari = new JSONObject();
        JSONArray listeMarques = new JSONArray();
        putStatsVehicule(porsche, maseratie, ducati, ferrari);
        putMarquesListe(listeMarques, porsche, maseratie, ducati, ferrari);
        putStats(statsModifer);
        statsModifer.put("vehicules_par_marque", listeMarques);
        return statsModifer;
    }
}
