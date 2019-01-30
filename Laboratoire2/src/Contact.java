import java.util.Scanner;

public class Contact {
    private Adresse adresseContact;
    private Occupation occupationContact;
    private Telephone[] tabTelephone = new Telephone[10];
    private String prenom;
    private String nom;

    public Contact(){
        prenom = "Boboha";
        nom = "Aloha";
        adresseContact = new Adresse();
        occupationContact = new Occupation();
        for(int i = 0; i<10; i++) {
            tabTelephone[i] = new Telephone();
        }
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

    public Telephone getTabTelephone(int numCase) {
        return tabTelephone[numCase];
    }

    public void setTabTelephone(Telephone telephoneContact, int numCase) {
        tabTelephone[numCase] = telephoneContact;
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

    public static void createNewContact(int numCase,Contact tabContacts[]){
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\n");

        System.out.println("Ce contact sera entré à la position #" + (numCase+1) +
                ".\nVeuillez entrer les informations suivantes :");

        System.out.print("Prénom : ");
        tabContacts[numCase].setPrenom(sc.next());
        System.out.print("Nom : ");
        tabContacts[numCase].setNom(sc.next());
        System.out.print("Adresse : "+
                "\n\tNuméro de porte : ");
        tabContacts[numCase].getAdresseContact().setNumPorte(sc.next());
        System.out.print("\tRue : ");
        tabContacts[numCase].getAdresseContact().setRue(sc.next());
        System.out.print("\tAppartement (zéro si inexistant) : ");
        tabContacts[numCase].getAdresseContact().setAppart(sc.next());
        System.out.print("\tCode Postale : ");
        tabContacts[numCase].getAdresseContact().setCodePostale(sc.next());
        System.out.print("\tVille : ");
        tabContacts[numCase].getAdresseContact().setVille(sc.next());
        System.out.print("\tProvince : ");
        tabContacts[numCase].getAdresseContact().setProvince(sc.next());
        System.out.print("\tPays : ");
        tabContacts[numCase].getAdresseContact().setPays(sc.next());
        System.out.print("Occupation : " +
                "\n\tPoste : ");
        tabContacts[numCase].getOccupationContact().setPoste(sc.next());
        System.out.print("\tEntreprise : " +
                "\n\t\tNom : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().setNom(sc.next());
        System.out.print("\t\tAdresse : "+
                "\n\t\t\tNuméro de porte : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setNumPorte(sc.next());
        System.out.print("\t\t\tRue : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setRue(sc.next());
        System.out.print("\t\t\tAppartement (zéro si inexistant) : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setAppart(sc.next());
        System.out.print("\t\t\tCode Postale : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setCodePostale(sc.next());
        System.out.print("\t\t\tVille : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setVille(sc.next());
        System.out.print("\t\t\tProvince : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setProvince(sc.next());
        System.out.print("\t\t\tPays : ");
        tabContacts[numCase].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setPays(sc.next());
        int nbtelephone = 0;
        boolean nvNumero = true;
        while(nvNumero) {
            System.out.print("Téléphone : " +
                    "\n\tType (cellulaire, maison, travail...): ");
            tabContacts[numCase].getTabTelephone(nbtelephone).setType(sc.next());
            System.out.print("\tNuméro (XXX-XXX-XXXX) : ");
            tabContacts[numCase].getTabTelephone(nbtelephone).setNumero(sc.next());
            System.out.println("\nVoulez-vous entrer un nouveau numéro? (o/n) ");
            char ouinon;
            try {
                ouinon = sc.next().charAt(0);
            } catch (Exception ex){
                ouinon = 'n';
            }
            ouinon = Character.toLowerCase(ouinon);
            if(ouinon == 'o')
                nbtelephone += 1;
            else
                nvNumero = false;
        }
    }

    public static void modifVieux(Contact tabContacts[]){
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\n");

        for (int i = 0; i<tabContacts.length; i++){
            if(!tabContacts[i].getNom().equals("Aloha"))
                System.out.print("\nContact #" + (i + 1) + " : " + tabContacts[i].getPrenom() + " " + tabContacts[i].getNom());
            else
                i = tabContacts.length;
        }
        if (tabContacts[0].getNom().equals("Aloha")) {
            System.out.println("\nVous n'avez aucun contact");
        }
        else {
            boolean choixContact = true;
            int contactNumero = 0;

            while (choixContact) {
                System.out.print("\nQuel contact voulez-vous modifier ? (entre 0 et 20)");

                try {
                    contactNumero = sc.nextInt() - 1;
                } catch (Exception ex) {
                    contactNumero = 0;
                }
                if (contactNumero < 0)
                    contactNumero = 0;
                else if (contactNumero > 20)
                    contactNumero = 19;
                else {
                    if (!tabContacts[contactNumero].getNom().equals("Aloha"))
                        choixContact = false;
                }
            }

            System.out.print("Prénom (" + tabContacts[contactNumero].getPrenom() + ") :");
            String changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].setPrenom(changer);

            System.out.print("Nom (" + tabContacts[contactNumero].getNom() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].setNom(changer);

            System.out.print("Adresse :" +
                    "\n\tNuméro de porte " + tabContacts[contactNumero].getAdresseContact().getNumPorte() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setNumPorte(changer);

            System.out.print("\tRue " + tabContacts[contactNumero].getAdresseContact().getRue() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setRue(changer);

            System.out.print("\tAppartement (zéro si inexistant) (" + tabContacts[contactNumero].getAdresseContact().getAppart() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setAppart(changer);

            System.out.print("\tCode Postale (" + tabContacts[contactNumero].getAdresseContact().getCodePostale() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setCodePostale(changer);

            System.out.print("\tVille (" + tabContacts[contactNumero].getAdresseContact().getVille() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setVille(changer);

            System.out.print("\tProvince (" + tabContacts[contactNumero].getAdresseContact().getProvince() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setProvince(changer);

            System.out.print("\tPays (" + tabContacts[contactNumero].getAdresseContact().getPays() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getAdresseContact().setPays(changer);

            System.out.print("Occupation :" +
                    "\n\tPoste (" + tabContacts[contactNumero].getOccupationContact().getPoste() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().setPoste(changer);

            System.out.print("\tEntreprise :" +
                    "\n\t\tNom (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getNom() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().setNom(changer);

            System.out.print("\t\tAdresse :\n" +
                    "\t\t\tNuméro de porte (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getNumPorte() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setNumPorte(changer);

            System.out.print("\t\t\tRue " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getRue() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setRue(changer);

            System.out.print("\t\t\tAppartement (zéro si inexistant) (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getAppart() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setAppart(changer);

            System.out.print("\t\t\tCode Postale (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getCodePostale() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setCodePostale(changer);

            System.out.print("\t\t\tVille (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getVille() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setVille(changer);

            System.out.print("\t\t\tProvince (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getProvince() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setProvince(changer);

            System.out.print("\t\t\tPays (" + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getPays() + ") :");
            changer = sc.next();
            if (!changer.equals(""))
                tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().setPays(changer);


            System.out.println("Téléphone :");
            for (int i = 0; i < 10; i++) {
                if (!tabContacts[contactNumero].getTabTelephone(i).getNumero().equals("XXX-XXX-XXXX")) {
                    System.out.print("\tType (" + tabContacts[contactNumero].getTabTelephone(i).getType() + ") :");
                    changer = sc.next();
                    if (!changer.equals(""))
                        tabContacts[contactNumero].getTabTelephone(i).setType(changer);

                    System.out.print("\tNuméro (" + tabContacts[contactNumero].getTabTelephone(i).getNumero() + ") :");
                    changer = sc.next();
                    if (!changer.equals(""))
                        tabContacts[contactNumero].getTabTelephone(i).setNumero(changer);
                    System.out.println();
                } else
                    i = 10;
            }
        }
    }

    public static void afficherListe(Contact tabContacts[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tabContacts.length; i++) {
            if (!tabContacts[i].getNom().equals("Aloha"))
                System.out.print("\nContact #" + (i + 1) + " : " + tabContacts[i].getPrenom() + " " + tabContacts[i].getNom());
            else
                i = tabContacts.length;
        }

        if (tabContacts[0].getNom().equals("Aloha")) {
            System.out.println("\nVous n'avez aucun contact");
        } else {
            boolean choixContact = true;
            int contactNumero = 0;


            while (choixContact) {
                System.out.print("\nQuel contact voulez-vous voir ? (entre 0 et 20)");
                try {
                    contactNumero = sc.nextInt() - 1;
                } catch (Exception ex) {
                    contactNumero = 0;
                }
                if (contactNumero < 0)
                    contactNumero = 0;
                else if (contactNumero == 41) {
                    contactNumero = 19;
                    choixContact = false;
                } else if (contactNumero > 20)
                    contactNumero = 19;
                else {
                    if (!tabContacts[contactNumero].getNom().equals("Aloha"))
                        choixContact = false;
                }
            }
            System.out.println("Prénom : " + tabContacts[contactNumero].getPrenom());
            System.out.println("Nom : " + tabContacts[contactNumero].getNom());
            System.out.println("Adresse : " +
                    "\n\tNuméro de porte : " + tabContacts[contactNumero].getAdresseContact().getNumPorte());
            System.out.println("\tRue : " + tabContacts[contactNumero].getAdresseContact().getRue());
            System.out.println("\tAppartement (zéro si inexistant) : " + tabContacts[contactNumero].getAdresseContact().getAppart());
            System.out.println("\tCode Postale : " + tabContacts[contactNumero].getAdresseContact().getCodePostale());
            System.out.println("\tVille : " + tabContacts[contactNumero].getAdresseContact().getVille());
            System.out.println("\tProvince : " + tabContacts[contactNumero].getAdresseContact().getProvince());
            System.out.println("\tPays : " + tabContacts[contactNumero].getAdresseContact().getPays());
            System.out.println("Occupation : " +
                    "\n\tPoste : " + tabContacts[contactNumero].getOccupationContact().getPoste());
            System.out.println("\tEntreprise : " +
                    "\n\t\tNom : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getNom());
            System.out.println("\t\tAdresse : " +
                    "\n\t\t\tNuméro de porte : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getNumPorte());
            System.out.println("\t\t\tRue : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getRue());
            System.out.println("\t\t\tAppartement (zéro si inexistant) : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getAppart());
            System.out.println("\t\t\tCode Postale : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getCodePostale());
            System.out.println("\t\t\tVille : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getVille());
            System.out.println("\t\t\tProvince : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getProvince());
            System.out.println("\t\t\tPays : " + tabContacts[contactNumero].getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getPays());

            System.out.println("Téléphone :");
            for (int i = 0; i < 10; i++) {
                if (!tabContacts[contactNumero].getTabTelephone(i).getNumero() .equals("XXX-XXX-XXXX")) {
                    System.out.println("\tType : " + tabContacts[contactNumero].getTabTelephone(i).getType());
                    System.out.println("\tNuméro : " + tabContacts[contactNumero].getTabTelephone(i).getNumero() + "\n");
                } else
                    i = 10;
            }
        }
    }
}
