/*
 *  Created by Olivier Blackburn
 */

import java.util.*;

public class Contact {
    private Adresse adresseContact;
    private Occupation occupationContact;
    private ArrayList<Telephone> telephoneArray = new ArrayList<>();
    private String prenom;
    private String nom;
    private boolean rappel;

    public Contact() {
        prenom = "Boboha";
        nom = "Aloha";
        adresseContact = new Adresse();
        occupationContact = new Occupation();
        for (int i = 0; i < 10; i++) {
            telephoneArray.add(new Telephone());
        }
        rappel = false;
    }

    public Adresse getAdresseContact() {
        return adresseContact;
    }

    public void setAdresseContact(Adresse adresseContact) {
        this.adresseContact = adresseContact;
    }

    public Occupation getOccupationContact() {
        return occupationContact;
    }

    public void setOccupationContact(Occupation occupationContact) {
        this.occupationContact = occupationContact;
    }

    public Telephone getTelephone(int numCase) {
        return telephoneArray.get(numCase);
    }

    public void setTabTelephone(Telephone telephoneContact, int numCase) {
        telephoneArray.set(numCase, telephoneContact);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRappel(boolean rappel) {
        this.rappel = rappel;
    }

    public boolean isRappel() {
        return rappel;
    }

    public static void createNewContact(HashMap<String, Contact> hashMapContact, PriorityQueue<String> rappelArray) {
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\n");

        System.out.println("Quel est la clé du contact");
        String key = sc.nextLine();

        hashMapContact.put(key, new Contact());

        System.out.println("Ce contact sera entré sous la clé de " + (key) +
                ".\nVeuillez entrer les informations suivantes :");

        System.out.print("Prénom : ");
        hashMapContact.get(key).setPrenom(sc.next());
        System.out.print("Nom : ");
        hashMapContact.get(key).setNom(sc.next());
        hashMapContact.get(key).getAdresseContact().setAdresse(hashMapContact.get(key), sc);
        System.out.print("Occupation : " +
                "\n\tPoste : ");
        hashMapContact.get(key).getOccupationContact().setPoste(sc.next());
        System.out.print("\tEntreprise : " +
                "\n\t\tNom : ");
        hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().setNom(sc.next());
        hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setAdresse(hashMapContact.get(key), sc);
        int nbtelephone = 0;
        while (true) {
            hashMapContact.get(key).getTelephone(nbtelephone).setTelephone(hashMapContact.get(key), sc, nbtelephone);
            System.out.println("\nVoulez-vous entrer un nouveau numéro? (o/n) ");
            char ouinon;
            try {
                ouinon = sc.next().charAt(0);
            } catch (Exception ex) {
                ouinon = 'n';
            }
            ouinon = Character.toLowerCase(ouinon);
            if (ouinon == 'o')
                nbtelephone += 1;
            else
                break;
        }
        System.out.println("Voulez-vous l'ajouter à la liste de rappel ? (oui ou non)");
        String rappel = sc.next().toLowerCase();
        if (rappel.charAt(0) == 'o') {
            rappelArray.add(key);
            hashMapContact.get(key).setRappel(true);
        }
    }

    public static void modifVieux(HashMap<String, Contact> hashMapContact, PriorityQueue<String> rappelArray) {
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\n");

        for (Map.Entry contact : hashMapContact.entrySet()) {
            System.out.println("Contact : " + contact.getKey());
        }

        if (hashMapContact.isEmpty()) {
            System.out.println("\nVous n'avez aucun contact");
        } else {

            boolean choix = true;
            String key = "";

            while (choix) {
                System.out.print("\nQuel contact voulez-vous voir ? (entrer la clé)");
                key = sc.nextLine();
                for (Map.Entry contact : hashMapContact.entrySet()) {
                    if (key.equals(contact.getKey()))
                        choix = false;
                }
            }
            String changer;
            System.out.print("Prénom (" + hashMapContact.get(key).getPrenom() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).setPrenom(changer);

            System.out.print("Nom (" + hashMapContact.get(key).getNom() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).setNom(changer);

            System.out.print("Adresse :" +
                    "\n\tNuméro de porte (" + hashMapContact.get(key).getAdresseContact().getNumPorte() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setNumPorte(changer);

            System.out.print("\tRue (" + hashMapContact.get(key).getAdresseContact().getRue() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setRue(changer);

            System.out.print("\tAppartement (zéro si inexistant) (" + hashMapContact.get(key).getAdresseContact().getAppart() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setAppart(changer);

            System.out.print("\tCode Postale (" + hashMapContact.get(key).getAdresseContact().getCodePostale() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setCodePostale(changer);

            System.out.print("\tVille (" + hashMapContact.get(key).getAdresseContact().getVille() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setVille(changer);

            System.out.print("\tProvince (" + hashMapContact.get(key).getAdresseContact().getProvince() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setProvince(changer);

            System.out.print("\tPays (" + hashMapContact.get(key).getAdresseContact().getPays() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getAdresseContact().setPays(changer);

            System.out.print("Occupation :" +
                    "\n\tPoste (" + hashMapContact.get(key).getOccupationContact().getPoste() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().setPoste(changer);

            System.out.print("\tEntreprise :" +
                    "\n\t\tNom (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getNom() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().setNom(changer);

            System.out.print("\t\tAdresse :\n" +
                    "\t\t\tNuméro de porte (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getNumPorte() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setNumPorte(changer);

            System.out.print("\t\t\tRue (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getRue() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setRue(changer);

            System.out.print("\t\t\tAppartement (zéro si inexistant) (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getAppart() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setAppart(changer);

            System.out.print("\t\t\tCode Postale (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getCodePostale() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setCodePostale(changer);

            System.out.print("\t\t\tVille (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getVille() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setVille(changer);

            System.out.print("\t\t\tProvince (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getProvince() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setProvince(changer);

            System.out.print("\t\t\tPays (" + hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getPays() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                hashMapContact.get(key).getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setPays(changer);


            System.out.println("Téléphone :");
            for (int i = 0; i < 10; i++) {
                if (!hashMapContact.get(key).getTelephone(i).getNumero().equals("XXX-XXX-XXXX")) {
                    System.out.print("\tType (" + hashMapContact.get(key).getTelephone(i).getType() + ") :");
                    changer = sc.next();
                    if (!changer.equals(""))
                        hashMapContact.get(key).getTelephone(i).setType(changer);

                    System.out.print("\tNuméro (" + hashMapContact.get(key).getTelephone(i).getNumero() + ") :");
                    changer = sc.next();
                    if (!changer.equals(""))
                        hashMapContact.get(key).getTelephone(i).setNumero(changer);
                    System.out.println();
                } else
                    i = 10;
            }
            String allo;
            if(hashMapContact.get(key).isRappel())
                allo = "oui";
            else
                allo = "non";
            System.out.print("Rappel (" + allo + ") (oui ou non) :");
            String different = sc.next().toLowerCase();
            if (different.charAt(0) == 'o' || different.charAt(0)=='\n') {
                rappelArray.add(key);
                hashMapContact.get(key).setRappel(true);
            } else {
                rappelArray.remove(key);
                hashMapContact.get(key).setRappel(false);
            }
        }
    }

    public static void afficherListe(HashMap<String, Contact> hMapContact, PriorityQueue<String> rappelArray) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        for (Map.Entry contact : hMapContact.entrySet()) {
            System.out.println("Contact : " + contact.getKey());
        }

        if (hMapContact.isEmpty()) {
            System.out.println("\nVous n'avez aucun contact");
        } else {

            boolean choix = true;
            String key = "";

            while (choix) {
                System.out.print("\nQuel contact voulez-vous voir ? (entrer la clé)");
                key = sc.next();
                for (Map.Entry contact : hMapContact.entrySet()) {
                    if (key.equals(contact.getKey()))
                        choix = false;
                }
            }
            System.out.println("Prénom : " + hMapContact.get(key).getPrenom());
            System.out.println("Nom : " + hMapContact.get(key).getNom());
            hMapContact.get(key).getAdresseContact().getAdresse();
            hMapContact.get(key).getOccupationContact().getOccupation(hMapContact.get(key));
            System.out.println("Téléphone :");
            for (int i = 0; i < 10; i++) {
                if (!hMapContact.get(key).getTelephone(i).getNumero().equals("XXX-XXX-XXXX")) {
                    System.out.println("\tType : " + hMapContact.get(key).getTelephone(i).getType());
                    System.out.println("\tNuméro : " + hMapContact.get(key).getTelephone(i).getNumero() + "\n");
                } else
                    i = 10;
            }
            if (rappelArray.contains(key)) {
                System.out.println("\nLe contact est dans la liste de rappel");
            }
        }
    }

    public static void supprimerContact(HashMap<String, Contact> hMapContact, PriorityQueue<String> rappelArray) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        for (Map.Entry contact : hMapContact.entrySet()) {
            System.out.println("Contact : " + contact.getKey());
        }

        if (hMapContact.isEmpty()) {
            System.out.println("\nVous n'avez aucun contact");
        } else {

            boolean choix = true;
            String key = "";

            while (choix) {
                System.out.print("\nQuel contact voulez-vous effacer ? (entrer la clé)");
                key = sc.next();
                for (Map.Entry contact : hMapContact.entrySet()) {
                    if (key.equals(contact.getKey()))
                        choix = false;
                }
            }
            hMapContact.remove(key);
            rappelArray.remove(key);
            System.out.println("Le contact sous la clé " + key + " a été effectué avec succès.");
        }
    }
}
