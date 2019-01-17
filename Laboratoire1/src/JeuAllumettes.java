import java.util.Random;
import java.util.Scanner;

/**
 * Created by Olivier Blackburn
 */

public class JeuAllumettes {
    private static int afficherInterface(String nomjoueur, int nballumettes, int tabJoueur[], int nbcoups) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIl reste " + nballumettes + " allumettes." +
                "\n" + nomjoueur + ", combien d'allumettes (entre 1 et 3) voulez-vous retirer ?");
        boolean choixNb = true;
        int allumettesEnlevees = 0;
        while (choixNb) {
            allumettesEnlevees = sc.nextInt();
            if (allumettesEnlevees >= 1 && allumettesEnlevees <= 3) {
                choixNb = false;
            } else
                System.out.println("Try again");
        }
        nballumettes = nballumettes - allumettesEnlevees;

        return nballumettes;
    }

    private static boolean finDeParti(String nomjoueur, int nballumettes, boolean partiEnCours, String nomjoueur1, String nomjoueur2, int tabjoueur1[], int tabjoueur2[]) {
        if (nballumettes <= 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n" + nomjoueur + " remporte la partie !");
            decisions(nomjoueur1, tabjoueur1);
            decisions(nomjoueur2, tabjoueur2);
            System.out.println("\nVoulez-vous commencer une autre partie ? " +
                    "\n1 - Oui" +
                    "\n2 - Non");
            int autre = sc.nextInt();
            if (autre == 1) {
                partiEnCours = false;
            } else {
                System.out.println("Au revoir !");
                System.exit(0);
            }
        }
        return partiEnCours;
    }

    private static void decisions(String nom, int tabJoueur[]) {
        System.out.println("Décisions " + nom + ":");
        for (int i = 0; i < tabJoueur.length; i++) {
            if (tabJoueur[i] != 0)
                System.out.print(tabJoueur[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Bienvenue dans le jeu des allumettes !\n");

        boolean jeu = true;

        while (jeu) {
            String nomjoueur1, nomjoueur2;

            System.out.println("Joueur 1, veuillez entrer votre nom :");
            nomjoueur1 = sc.nextLine();
            System.out.println("\nJoueur 2, veuillez entrer votre nom :");
            nomjoueur2 = sc.nextLine();

            int nballumettes = generator.nextInt(80)+20;
            int tabjoueur1[] = new int[50];
            int tabjoueur2[] = new int[50];

            boolean partiEnCours = true;
            int nbcoups = 0;

            while (partiEnCours) {
                nbcoups += 1;
                int allumettesInitial = nballumettes;
                nballumettes = afficherInterface(nomjoueur1, nballumettes, tabjoueur1, nbcoups);
                tabjoueur1[nbcoups] = allumettesInitial - nballumettes;
                partiEnCours = finDeParti(nomjoueur2, nballumettes, partiEnCours, nomjoueur1, nomjoueur2, tabjoueur1, tabjoueur2);

                if (partiEnCours) {
                    allumettesInitial = nballumettes;
                    nballumettes = afficherInterface(nomjoueur2, nballumettes, tabjoueur2, nbcoups);
                    tabjoueur2[nbcoups] = allumettesInitial - nballumettes;
                    partiEnCours = finDeParti(nomjoueur1, nballumettes, partiEnCours, nomjoueur1, nomjoueur2, tabjoueur1, tabjoueur2);
                }
            }
        }
    }
}