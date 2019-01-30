import java.util.Scanner;

/**
 * Created by Olivier Blackburn
 */

public class Programme {

    public static char afficherMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Ajouter un contact" +
                "\n2.Modifier un contact" +
                "\n3.Afficher les contacts" +
                "\n4.Quitter" +
                "\n\nQue voulez-vous faire ? ");
        char choixMenu = sc.next().charAt(0);
        return choixMenu;
    }

    public static void livreDeContact(){
        System.out.println("      __...--~~~~~-._   _.-~~~~~--...__\n" +
                "    //               `V'               \\\\ \n" +
                "   //                 |                 \\\\ \n" +
                "  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \n" +
                " //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\n" +
                "====================\\\\|//====================\n" +
                "                    `---`");
    }

    public static void main(String[] args) {

        Contact tabContacts[] = new Contact[20];
        for(int i = 0;i<tabContacts.length ; i++){
            tabContacts[i] = new Contact();
        }

        int numCase = 0;

        System.out.println("\nBienvenue dans ce programme de gestion de contacts !\n");
        System.out.println("Voici le livre des contacts :\n");
        livreDeContact();

        boolean navigation = true;
        while (navigation) {
            char choixMenu = afficherMenu();

            if (choixMenu == '1') {
                Contact.createNewContact(numCase,tabContacts);
                numCase += 1;
            } else if (choixMenu == '2') {
                Contact.modifVieux(tabContacts);
            } else if (choixMenu == '3') {
                Contact.afficherListe(tabContacts);
            } else {
                System.out.println("Au revoir !");
                System.exit(0);
            }
        }
    }
}

