/*
 *  Created by Olivier Blackburn
 */

import java.util.Scanner;

public class Adresse {
    private String numPorte;
    private String rue;
    private String appart;
    private String ville;
    private String province;
    private String pays;
    private String codePostale;

    public Adresse() {
        numPorte = "0000";
        rue = "Poisson";
        appart = "0";
        ville = "Saguenay";
        province = "Québec";
        pays = "Canada";
        codePostale = "A0B 1C2";
    }

    public String getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(String numPorte) {
        this.numPorte = numPorte;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public void setAdresse(Contact contact, Scanner sc){
        System.out.print("Adresse : " +
                "\n\tNuméro de porte : ");
        contact.getAdresseContact().setNumPorte(sc.next());
        System.out.print("\tRue : ");
        contact.getAdresseContact().setRue(sc.next());
        System.out.print("\tAppartement (zéro si inexistant) : ");
        contact.getAdresseContact().setAppart(sc.next());
        System.out.print("\tCode Postale : ");
        contact.getAdresseContact().setCodePostale(sc.next());
        System.out.print("\tVille : ");
        contact.getAdresseContact().setVille(sc.next());
        System.out.print("\tProvince : ");
        contact.getAdresseContact().setProvince(sc.next());
        System.out.print("\tPays : ");
        contact.getAdresseContact().setPays(sc.next());
    }

    public void getAdresse(){
        System.out.println("\t\tAdresse : " +
                "\n\t\t\tNuméro de porte : " + getNumPorte());
        System.out.println("\t\t\tRue : " + getRue());
        System.out.println("\t\t\tAppartement (zéro si inexistant) : " + getAppart());
        System.out.println("\t\t\tCode Postale : " + getCodePostale());
        System.out.println("\t\t\tVille : " + getVille());
        System.out.println("\t\t\tProvince : " + getProvince());
        System.out.println("\t\t\tPays : " + getPays());
    }
}
