/*
 *  Created by Olivier Blackburn
 */

import java.io.*;
import java.util.*;

public class Programme {

    public static char afficherMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n1.Ajouter un contact" +
                "\n2.Modifier un contact" +
                "\n3.Afficher les contacts" +
                "\n4.Supprimer un contact" +
                "\n5.Charger la liste de contact" +
                "\n6.Quitter" +
                "\n\nQue voulez-vous faire ? ");
        return sc.next().charAt(0);
    }

    public static void livreDeContact() {
        System.out.println("      __...--~~~~~-._   _.-~~~~~--...__\n" +
                "    //               `V'               \\\\ \n" +
                "   //                 |                 \\\\ \n" +
                "  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \n" +
                " //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\n" +
                "====================\\\\|//====================\n" +
                "                    `---`");
    }

    public static void main(String[] args) throws IOException {

        HashMap<String, Contact> hashMapContacts = new HashMap<>();

        System.out.println("\nBienvenue dans ce programme de gestion de contacts !\n");
        System.out.println("Voici le livre des contacts :\n");
        livreDeContact();

        PriorityQueue<String> rappelPriority = new PriorityQueue<>();

        File doc = new File("Doc1.txt");
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(doc, true));
        FileReader reader = new FileReader("Doc1.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        Scanner lecteur = new Scanner(doc);
        Scanner sc = new Scanner(System.in);


        while (true) {
            char choixMenu = afficherMenu();

            if (choixMenu == '1') {
                Contact.createNewContact(hashMapContacts, rappelPriority);
            } else if (choixMenu == '2') {
                Contact.modifVieux(hashMapContacts, rappelPriority);
            } else if (choixMenu == '3') {
                Contact.afficherListe(hashMapContacts, rappelPriority);
            } else if (choixMenu == '4') {
                Contact.supprimerContact(hashMapContacts, rappelPriority);
            } else if (choixMenu == '5') {
                String[] tabContact = new String[1000];
                int a = 0;
                while (lecteur.hasNextLine()) {
                    tabContact[a] = lecteur.nextLine();
                    a++;
                }
                if (bufferedReader.readLine() != null)
                    try {
                        Contact.chargerContacts(bufferedReader, hashMapContacts, tabContact);
                        System.out.println("Liste de contact chargée");
                    } catch (IOException ex) {
                        System.out.println("Chargement impossible");
                    }
                else
                    System.out.println("Chargement impossible");
            } else if (choixMenu == 'a') {
                Contact.contactPreFaite(hashMapContacts);
            } else if (choixMenu == '6') {
                System.out.println("Voulez-vous enregistrer la liste de contacts ? (oui ou non)");
                if (sc.nextLine().toLowerCase().charAt(0) == 'o') {
                    try {
                        Contact.sauvergarderContact(hashMapContacts, printWriter);
                        System.out.println("Sauvegarde effectuée");
                    } catch (Exception ex) {
                        System.out.println("Sauvegarde impossible");
                    }
                }
                System.out.println("Au revoir !");
                System.exit(0);
            } else
                System.out.println("Choix invalide.");
            if (rappelPriority.size()!=0) {
                System.out.println("Liste de rappel : ");
                for (int i = 0; i < rappelPriority.toArray().length; i++) {
                    System.out.println("#" + (i + 1) + " " + rappelPriority.toArray()[i]);
                }
            }
        }
    }
}
/*
Liste des problèmes à règler :

1-Sauvergarde toute les contacts même si ils sont déja sauvegarder

2-Impossible d'effacer un contact du document texte

3-L'utilisateur peut entrer n'importe quel sorte de caractère (Pas de validation de caractères spéciaux)

4-La classe Contact.modifVieux est vraiment pas optimisée et devrait être refaite

 */
