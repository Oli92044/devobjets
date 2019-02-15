import Armes.*;
import Personnages.*;

import java.util.Scanner;

/**
 * Created by Olivier Blackburn
 */

public class Jeu {

    public static void afficherMenuPersonnage(Personnage joueurs[]) {
        Scanner sc = new Scanner(System.in);

        char choixType1;
        for (int i = 0; i < joueurs.length; i++) {

            if (i == 0)
                System.out.println("\nChoisissez un premier personnage :");
            else if (i == 1)
                System.out.println("\nChoisissez un deuxième personnage :");
            System.out.println("\n1 - Barbare" +
                    "\n2 - Paladin" +
                    "\n3 - Magicien noir" +
                    "\n4 - Magicien rouge");
            choixType1 = sc.next().charAt(0);
            switch (choixType1) {
                case '1':
                    joueurs[i] = new Barbare();
                    break;
                case '2':
                    joueurs[i] = new Paladin();
                    break;
                case '3':
                    joueurs[i] = new MagicienNoir();
                    break;
                case '4':
                    joueurs[i] = new MagicienRouge();
                    break;
                default:
                    joueurs[i] = new Barbare();
                    break;
            }
            if (i == 0)
                System.out.println("\nChoisissez l'arme du premier personnage :\n");
            else
                System.out.println("\nChoisissez l'arme du deuxième personnage :\n");
            joueurs[i].afficherMenuArmes();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personnage joueurs[] = new Personnage[2];

        System.out.println("\nBienvenue dans ce jeu de RPG ultra réaliste !");

        afficherMenuPersonnage(joueurs);
        System.out.println("Au combat ! Appuyer sur ENTER pour continuer. ");
        boolean combat = true;
        while (combat) {
            if (!joueurs[0].isStatut() && !joueurs[1].isStatut()) {
                System.out.println("Partie nulle");
                System.exit(0);
            }
            sc.nextLine();

            //Pas capable d'ajouter la fonction trancher, frapper et lancerSort dans la fonction attaquer car ex.armes.trancher ne fonctionne pas

            joueurs[0].attaquer(joueurs[1]);
            if (joueurs[1].getPtsDeVie() <= 0) {
                System.out.println("\nLa partie est terminée " + joueurs[0].getNom() + " a gagné la partie");
                combat = false;
            } else {
                sc.nextLine();
                joueurs[1].attaquer(joueurs[0]);
                if (joueurs[0].getPtsDeVie() <= 0) {
                    System.out.println("La partie est terminée, " + joueurs[1].getNom() + " a gagné la partie");
                    combat = false;
                }
            }
        }
    }
}
