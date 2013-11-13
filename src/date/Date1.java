package date;

import java.util.Date;

public class Date1 {

     Date maintenant;
     int ceMois;
     int cetteAnnee;
     int annees;
    String dateDeNaissance;
    public Date1(String dateDeNaissance){
        this.dateDeNaissance=dateDeNaissance;
    }
    public int getAnneeDeNaissance() {
        return Integer.parseInt(dateDeNaissance.substring(0, 4));
    }

    public  int getMoisDeNaissance() {
        return Integer.parseInt(dateDeNaissance.substring(5, 7));
    }

    public int getJourDeNaissance() {
        return Integer.parseInt(dateDeNaissance.substring(8, 10));
    }

    public void getParametreDeDate() {
        maintenant = new Date();
        ceMois = maintenant.getMonth() + 1;
        cetteAnnee = maintenant.getYear() + 1900;
        annees = cetteAnnee - getAnneeDeNaissance();
    }

    public  int getAnnees() {
        getParametreDeDate();
        if (getMoisDeNaissance() > ceMois) {
            annees--;
        } else if (getMoisDeNaissance() == ceMois) {
            int aujourdhui = maintenant.getDate();
            if (getJourDeNaissance() > aujourdhui) {
                annees--;
            }
        }
        return annees;
    }
}
