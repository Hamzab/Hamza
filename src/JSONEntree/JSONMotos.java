package JSONEntree;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONMotos {
    JSONObject unObjet;
   public JSONMotos(){
       try{
      unObjet = (JSONObject) JSONSerializer.toJSON((new JSON()).getJsonInfo());
       }catch(Exception e){
           
       }
   }
    public  JSONArray getMotos() throws Exception {     
        JSONArray voitures = unObjet.getJSONArray("motos");
        return voitures;
    }

    public  int getAnnee(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getInt("annee");
    }

    public  String getMarque(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("marque");
    }

    public  String getModele(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("modele");
    }

    public  double getValeurDesOptions(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getDouble("valeur_des_options");
    }

    public  String getBuriange(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getString("burinage");
    }

    public  boolean getGarageInterieur(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("garage_interieur");
    }

    public  boolean getSystemeAlarme(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("systeme_alarme");
    }

    public  boolean getValeurCC(int indice) throws Exception {
        return getMotos().getJSONObject(indice).getBoolean("systeme_alarme");
    }
}
