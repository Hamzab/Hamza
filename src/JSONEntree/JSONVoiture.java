package JSONEntree;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONVoiture {
  JSONObject unObjet ;
  public JSONVoiture(){
      try{
      unObjet = (JSONObject) JSONSerializer.toJSON((new JSON()).getJsonInfo());
      }catch(Exception e){
          
      }
  }
    public JSONArray getVoitures() throws Exception {       
        JSONArray voitures = unObjet.getJSONArray("voitures");
        return voitures;
    }

    public int getAnnee(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getInt("annee");
    }

    public  String getMarque(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("marque");
    }

    public String getModele(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("modele");
    }

    public double getValeurDesOptions(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getDouble("valeur_des_options");
    }

    public String getBuriange(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getString("burinage");
    }

    public boolean getGarageInterieur(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getBoolean("garage_interieur");
    }

    public boolean getSystemeAlarme(int indice) throws Exception {
        return getVoitures().getJSONObject(indice).getBoolean("systeme_alarme");
    }
}