package main.java.conducteur;

import net.sf.json.JSONArray;

public class Conducteur {

    int age;
    String province;
    String ville;
    String sexe;

    public Conducteur(int age, String province, String ville, String sexe) {
        this.age = age;
        this.province = province;
        this.ville = ville;
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public String getProvince() {
        return province;
    }

    public String getVille() {
        return ville;
    }

    public String getSexe() {
        return sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public boolean estResideAuQuebec() {
        String pro = getProvince();
        boolean res = false;
        if (pro.equals("Québec")) {
            res = true;
        }
        return res;
    }

    public boolean estUnHommeMoins25() {
        boolean res = false;
        if (getSexe().equals("M") && age < 25) {
            res = true;
        }
        return res;
    }

    public boolean estUneFemmeMoins21() {
        boolean res = false;
        if (getSexe().equals("F") && age < 21) {
            res = true;
        }
        return res;
    }

    public boolean estUnePersonnePlus75() {
        boolean res = false;
        if ((getSexe().equals("M") || getSexe().equals("F"))
                && age > 75) {
            res = true;
        }
        return res;
    }

    public boolean estAssurable() {
        boolean res = true;
        if (estUnHommeMoins25() || estUneFemmeMoins21() || estUnePersonnePlus75()
                || !estResideAuQuebec()) {
            res = false;
        }
        return res;
    }

    public JSONArray getMessageAssurableAge() {
        JSONArray messages = new JSONArray();
        if (estUnHommeMoins25()) {
            messages.add("Le conducteure est un homme a " + age + ", il est moin de 25 ans");
        }
        if (estUneFemmeMoins21()) {
            messages.add("Le conducteure est une femme a " + age + ", elle est moin de 21 ans");
        }
        if (estUnePersonnePlus75()) {
            messages.add("Le conducteure est une personne a " + age + ", il est plus de 75 ans");
        }
        return messages;
    }

    public JSONArray getMessageAssurable() {
        JSONArray messages = getMessageAssurableAge();
        if (!estResideAuQuebec()) {
            messages.add("Le conducteure est une personne reside à " + province + ", il ne reside pas au Quebec");
        }
        return messages;
    }
}
