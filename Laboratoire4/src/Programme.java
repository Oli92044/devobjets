/*
 *  Created by Olivier Blackburn
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Programme {

    public static char afficherMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n1.Ajouter un contact" +
                "\n2.Modifier un contact" +
                "\n3.Afficher les contacts" +
                "\n4.Supprimer un contact" +
                "\n5.Quitter" +
                "\n\nQue voulez-vous faire ? ");
        char choixMenu = sc.next().charAt(0);
        return choixMenu;
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

    public static void main(String[] args) {

        HashMap<String, Contact> hashMapContacts = new HashMap<>(); //->String aurait pu être changer en Integer qui aurait été bcp plus simple

        System.out.println("\nBienvenue dans ce programme de gestion de contacts !\n");
        System.out.println("Voici le livre des contacts :\n");
        livreDeContact();

        String key = "key";

        PriorityQueue<String> rappelPriority = new PriorityQueue<>();

        boolean navigation = true;
        while (navigation) {
            char choixMenu = afficherMenu();

            if (choixMenu == '1') {
                Contact.createNewContact(hashMapContacts, rappelPriority);
            } else if (choixMenu == '2') {
                Contact.modifVieux(hashMapContacts, rappelPriority);
            } else if (choixMenu == '3') {
                Contact.afficherListe(hashMapContacts, rappelPriority);
            } else if (choixMenu == '4') {
                Contact.supprimerContact(hashMapContacts, rappelPriority);
            } else {
                navigation = false;
                System.out.println("Au revoir !");
                System.exit(0);
            }
            System.out.println("Liste de rappel : ");
            for(int i = 0; i<rappelPriority.toArray().length; i++){
                System.out.println("#" + (i+1) + " " + rappelPriority.toArray()[i]);
            }
        }
    }
}

