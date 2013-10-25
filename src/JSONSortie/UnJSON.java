/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayList;
import java.util.List;
import lesCalcules.LesCalcules;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import voiture.InfoVoiture;
import voiture.Moto;
import voiture.Vehicule;
import voiture.Voiture;

/**
 *
 * @author Hamza
 */
public class UnJSON {
    
    public Vehicule getTypeVehicule(String type,int annee ,String marque, String modele){
        Vehicule v=null;
      if(type.equals("voitures")){
          v=new Voiture(annee,marque, modele);
      }else if(type.equals("motos")){
          v= new Moto(annee,marque, modele); 
      }
      return v;
    }
    public static int getSizeVehicules(String type) throws Exception{
        int size=0;
        if(type.equals("voitures")){
           size=LesDonnes.getDataVihecules(type).size(); 
        }else if(type.equals("motos")){
            size=LesDonnes.getDataVihecules(type).size();
        }
        return size;
    }
    public static boolean estAssurableUneVehicule(String type,Vehicule v) throws Exception{
        
        int length= getSizeVehicules(type);
        System.out.println("length="+length);
        boolean res=false;
        for(int i=0;i<length;i++){
            if(v.estAssurable(LesDonnes.getAnnees(type).get(i)
                    ,LesDonnes.getMarques(type).get(i),LesDonnes.getModeles(type).get(i))){
                res=true;
            }
        }
       return res;
        
    }
      public static boolean estAssurablePlusieursVehicules(String type,List<Vehicule> vehicules) throws Exception{
          boolean res=true;
          for(int i=0;i<vehicules.size();i++){
              if(!estAssurableUneVehicule(type,vehicules.get(i))){
                  res=false;                  
              }
          }
          return res;
      }
      public static boolean estAssurablePlusieursVoitures() throws Exception{
          List<Vehicule> voitures=new ArrayList<Vehicule>();
          int length =JSONVoiture.getVoitures().size();
          for(int i=0;i<length;i++){
              Vehicule v=new Voiture(JSONVoiture.getAnnee(i),JSONVoiture.getMarque(i)
                       ,JSONVoiture.getModele(i));
              voitures.add(v);                        
          }
         return estAssurablePlusieursVehicules("voitures",voitures);
      }
       public static boolean estAssurablePlusieursMotos() throws Exception{
          List<Vehicule> motos=new ArrayList<Vehicule>();
          int length =JSONMotos.getMotos().size();
          for(int i=0;i<length;i++){
              Vehicule v=new Moto(JSONMotos.getAnnee(i),JSONMotos.getMarque(i)
                       ,JSONMotos.getModele(i));
              motos.add(v);                        
          }
         return estAssurablePlusieursVehicules("motos",motos);
      }
         public static boolean estAssurableToutLesVehicules() throws Exception{
         boolean estVoitures=estAssurablePlusieursVoitures();
         boolean estMotos=estAssurablePlusieursMotos();
         return estVoitures && estMotos;
      }
       public static boolean estAssurableConducteur() throws Exception{
           int age=LaDate.getAnnees(JSONConducteur.getDateDeNaissance());
           String sexe=JSONConducteur.getSexe();
           String provence=JSONConducteur.getProvince();
           String ville=JSONConducteur.getVille();
           Conducteur cond=new Conducteur(age,provence,ville,sexe);
           return cond.estAssurable();
       }
       public static boolean estAssurable() throws Exception{
           boolean estVehicule=estAssurableToutLesVehicules();
           boolean estConducteur=estAssurableConducteur();
           return estConducteur && estVehicule;
       }
  /*  
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
        Conducteur c = new Conducteur(LaDate.getAnnees(dateNaissance), province, ville, sexe);
        Contrat con = new Contrat(dureeContrat);
        InfoConducteur infoc = new InfoConducteur(c, dateFinCours, estCAA, estPremier);
        InfoVoiture infov = new InfoVoiture(v, valOption, buriange, garInter, sysAlarm);
        LesCalcules a = new LesCalcules(infov, infoc, con, valeur);
        List formats = FormatJSON.getResultats(dateNaissance,
                infoc.getDateFinCoursDeConduite(), c.getSexe(), con.getDureeContrat());
        System.out.println("c.estUneFemmeMoins21()="+c.estUneFemmeMoins21()
                         +"c.estAssurable()="+c.estAssurable());
        if (!formats.isEmpty()) {
            for (int i = 0; i < formats.size(); i++) {
                System.out.println(formats.get(i));
                res.put("méssage " + (i + 1), formats.get(i));
            }
        } else {
            if (c.estAssurable() && v.estAssurable()) {
                res.put("est_assurable", c.estAssurable());
                res.put("montant_annuel", a.appliquer());
                res.put("mensualite", a.calculerMontantMensualite());

            } else {
                res.put("est_assurable", c.estAssurable() && v.estAssurable());
                JSONArray messages = new JSONArray();
                if (!c.estAssurable()) {
                    if (!c.estResideAuQuebec()) {
                        messages.add(" La province du conducteur n'est pas le Québec");
                    }
                    if (c.estUnHommeMoins25()) {
                        messages.add("Le conducteur est un homme de moins de 25 ans");
                    }
                    if (c.estUneFemmeMoins21()) {
                        messages.add("Le conducteur est une femme de moins de 21 ans.");
                    }
                    if (c.estUnePersonnePlus75()) {
                        messages.add("Le conducteur est une personne de plus de 75 ans");
                    }
                }
                if (!v.estAssurable()) {
                    if (!v.verifierAnnee()) {
                        messages.add("L'annee de la voiture doit etre 2014");
                    }
                    if (!v.verifierMarque()) {
                        messages.add("La marque de la voiture doit etre Porsche");
                    }
                    
                }
                res.put("messages ", messages);
            }
            
        }

        return res;
    }*/
}
