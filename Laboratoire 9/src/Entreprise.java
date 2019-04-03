/*
 *  Created by Olivier Blackburn
 */

public class Entreprise {
    private String nom;
    private Adresse adresseEntreprise;

    public Entreprise() {
        nom = "Walmart";
        adresseEntreprise = new Adresse();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public static String entrepriseToString(Entreprise entreprise){

        String entrepriseString = entreprise.nom + "," + Adresse.adresseToString(entreprise.adresseEntreprise);

        return entrepriseString;
    }
}
