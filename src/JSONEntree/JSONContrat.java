package JSONEntree;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JSONContrat {

    public static int getDureeContrat() throws Exception {
        JSONObject unObjet = (JSONObject) JSONSerializer.toJSON(JSON.getJsonInfo());
        return unObjet.getInt("duree_contrat");
    }
}
