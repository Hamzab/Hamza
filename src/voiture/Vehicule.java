/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture;

/**
 *
 * @author Hamza
 */
public interface Vehicule {
    public String getMarque();
    public int getAnnee();
    public String getModele();
    public double getValeurInitiale();
    public boolean estExistAnnee(int annee);
    public boolean estExistMarque(String marque);
    public boolean estExistModele(String modele);
    public boolean estAssurable(int annee,String marque,String modele);
}
