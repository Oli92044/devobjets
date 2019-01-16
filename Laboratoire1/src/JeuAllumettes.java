import java.util.Random;
import java.util.Scanner;

/**
 * Created by Olivier Blackburn
 */

public class JeuAllumettes {
    static int afficherInterface(String nomjoueur, int nballumettes){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIl reste " +nballumettes + " allumettes." +
                "\n"+ nomjoueur + ", combien d'allumettes (entre 1 et 3) voulez-vous retirer ?");
        boolean choixNb = true;
        int allumettesEnlevees = 0;
        while(choixNb){
            allumettesEnlevees = sc.nextInt();
            if(allumettesEnlevees >=1 && allumettesEnlevees <=3){
                choixNb = false;
            }
            else
                System.out.println("Try again");
        }

        nballumettes = nballumettes - allumettesEnlevees;
        return nballumettes;
    }

    static boolean finDeParti(String nomjoueur, int nballumettes, boolean partiEnCours){
        if(nballumettes<=0){
            Scanner sc = new Scanner(System.in);
            System.out.println(nomjoueur + " remporte la partie !");
            System.out.println("\nVoulez-vous commencer une autre partie ? " +
                    "\n1 - Oui" +
                    "\n2 - Non");
            int autre = sc.nextInt();
            if(autre == 1){
                partiEnCours = false;
            }
            else{
                System.out.println("Au revoir !");
                System.exit(0);
            }
        }
        return partiEnCours;
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

            boolean partiEnCours = true;

            while (partiEnCours) {
                nballumettes = afficherInterface(nomjoueur1,nballumettes);
                partiEnCours = finDeParti(nomjoueur2,nballumettes,partiEnCours);

                if(partiEnCours) {
                    nballumettes = afficherInterface(nomjoueur2, nballumettes);
                    partiEnCours = finDeParti(nomjoueur1,nballumettes,partiEnCours);
                }
            }

        }
    }
}