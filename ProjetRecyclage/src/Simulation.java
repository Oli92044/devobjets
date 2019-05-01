import Planete.*;
import Recyclage.*;
import Transport.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private static void afficherVaisseau() throws InterruptedException {
        System.out.println("\nLancement de la simulation dans ...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("       !\n" +
                "       !\n" +
                "       ^\n" +
                "      / \\\n" +
                "     /___\\\n" +
                "    |=   =|\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "    |     |\n" +
                "   /|##!##|\\\n" +
                "  / |##!##| \\\n" +
                " /  |##!##|  \\\n" +
                "|  / ^ | ^ \\  |\n" +
                "| /  ( | )  \\ |\n" +
                "|/   ( | )   \\|\n" +
                "    ((   ))\n" +
                "   ((  :  ))\n" +
                "   ((  :  ))\n" +
                "    ((   ))\n" +
                "     (( ))\n" +
                "      ( )\n" +
                "       .\n" +
                "       .\n" +
                "       .");
    }

    private static int obtenirValeur(int limiteInf, int limiteSup, String nom, Scanner sc) {
        int valeur;
        System.out.print("Combien de " + nom + " voulez-vous envoyer pour sauver l'espace ? Nombre de " + nom + " : ");
        while (true) {
            try {
                valeur = sc.nextInt();
                if (valeur <= limiteSup && valeur >= limiteInf)
                    break;
                else
                    System.out.println("Entrez un nombre entre " + limiteInf + " et " + limiteSup);
            } catch (InputMismatchException ex) {
                System.out.println("Invalide, Entrez un nombre entre " + limiteInf + " et " + limiteSup);
                sc.next();
            }
        }
        return valeur;
    }

    public static void infoVaisseau(vaisseau[] tab) {
        for (int i = 0; i < tab.length; i++)
            System.out.println("#" + (i + 1) + " -> Type : " + tab[i].getType() + "(" + tab[i].getQuantite() + ")");
    }

    private static void associerPlaneteVaisseau(vaisseau vaisseau, Random generator) {
        if (vaisseau.isStatut()) {
            int typePlanete = generator.nextInt(5) + 1;
            switch (typePlanete) {
                case 1:
                    vaisseau.associerPlanete(new typeA());
                    break;
                case 2:
                    vaisseau.associerPlanete(new typeB());
                    break;
                case 3:
                    vaisseau.associerPlanete(new typeC());
                    break;
                case 4:
                    vaisseau.associerPlanete(new typeD());
                    break;
                case 5:
                    vaisseau.associerPlanete(new typeE());
                    break;

                default:
                    vaisseau.associerPlanete(new typeA());
                    break;
            }
        }
    }

    private static boolean finSimulation(int nbShip, int nbCentreTri, centreTri[] tabCentreTri, vaisseau[] tabVaisseaux) {
        boolean simulation = true;
        int c = 0;
        int v = 0;
        for (centreTri centreTri : tabCentreTri) {
            if (centreTri.verifierPleinFile())
                c++;
        }
        for (vaisseau vaisseau : tabVaisseaux) {
            if (!vaisseau.isStatut())
                v++;
        }
        if (c == nbCentreTri || v == nbShip)
            simulation = false;
        return simulation;
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("\nBienvenue dans la simulation de [...] Opération Déchet [...]\n\n");

        //Quantité de vaisseaux et centres de tri
        int nbShip = obtenirValeur(1, 1000, "vaisseaux", sc);
        System.out.println();
        int nbCentreTri = obtenirValeur(1, 100, "centres de tri", sc);

        //Création des objets nécessaires
        vaisseau[] tabVaisseaux = vaisseau.creerVaisseaux(nbShip, generator);
        centreTri[] tabCentreTri = centreTri.creerCentreTris(nbCentreTri, nbShip);

        //Affichage (facultatif)
        //afficherVaisseau();

        //Lancement
        boolean simulation = true;

        while (simulation) {

            for (vaisseau vaisseau : tabVaisseaux) {
                associerPlaneteVaisseau(vaisseau, generator);
                System.out.println("associer");
                vaisseau.ramasserDechetsPlanete();
                System.out.println("ramasser");
                vaisseau.viderVaisseau(tabCentreTri);
                System.out.println("vider");
            }

            simulation = finSimulation(nbShip, nbCentreTri, tabCentreTri, tabVaisseaux);
        }
        System.out.println("Merci d'avoir utiliser ce programme de simulation de sauvetage intergalactique ");

    }
}
