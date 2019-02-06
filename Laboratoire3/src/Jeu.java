import Personnages.*;

import java.util.Scanner;

/**
 * Created by Olivier Blackburn
 */

public class Jeu {

    public static void afficherMenu(Personnage joueurs[]) {
        Scanner sc = new Scanner(System.in);

        char choixType1;
        for (int i = 0; i < joueurs.length; i++) {
            boolean choix1 = true;
            while (choix1) {
                if (i == 0)
                    System.out.println("\nChoisissez un premier personnage :");
                else if (i == 1)
                    System.out.println("\nChoisissez un deuxième personnage :");
                System.out.println("\n1 - Personnages.Barbare" +
                        "\n2 - Personnages.Paladin" +
                        "\n3 - Personnages.Magicien noir" +
                        "\n4 - Personnages.Magicien rouge");
                choixType1 = sc.next().charAt(0);
                if (choixType1 == '1' || choixType1 == '2' || choixType1 == '3' || choixType1 == '4') {
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
                    choix1 = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personnage joueurs[] = new Personnage[2];

        System.out.println("\nBienvenue dans ce jeu de RPG ultra réaliste !");

        afficherMenu(joueurs);
        System.out.println("Au combat ! Appuyer sur ENTER pour continuer. ");
        boolean combat = true;
        while (combat) {
            if(!joueurs[0].isStatut() && !joueurs[1].isStatut()){
                System.out.println("Partie nulle");
                System.exit(0);
            }
            sc.nextLine();
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
