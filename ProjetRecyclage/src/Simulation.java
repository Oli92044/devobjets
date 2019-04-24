import Planete.*;
import Recyclage.*;
import Transport.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Simulation {

    public static void afficherVaisseau()throws InterruptedException{
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

    public static int obtenirValeur(int limiteInf, int limiteSup, String nom, Scanner sc){
        int valeur;
        System.out.print("Combien de "+nom +" voulez-vous envoyer pour sauver l'espace ? Nombre de "+ nom +" : ");
        while (true){
            try{
                valeur = sc.nextInt();
                if(valeur<=limiteSup && valeur >=limiteInf)
                    break;
                else
                    System.out.println("Entrez un nombre entre "+limiteInf+" et " + limiteSup);
            } catch (InputMismatchException ex) {
                System.out.println("Invalide, Entrez un nombre entre "+ limiteInf +" et " + limiteSup);
                sc.next();
            }
        }
        return valeur;
    }

    public static void infoVaisseau(vaisseau[] tab){
        for(int i = 0; i<tab.length;i++)
            System.out.println("#" + (i+1) + " -> Type : " + tab[i].getType() + "(" + tab[i].getQuantite() + ")");
    }

    public static void main(String[] args) throws InterruptedException{

        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("\nBienvenue dans la simulation de [...] Opération Déchet [...]\n\n");

        int nbShip = obtenirValeur(1,1000,"vaisseaux",sc);
        System.out.println();
        int nbCentreTri = obtenirValeur(1,100,"centres de tri", sc);

        vaisseau[] tabVaisseaux = vaisseau.creerVaisseaux(nbShip,generator);

        centreTri[] tabCentreTri = centreTri.creerCentreTris(nbCentreTri);

        //infoVaisseau(tabVaisseaux);

        //afficherVaisseau();

        //typeA typeA = new typeA();

        //ArrayList<dechets> arrayDechets = typeA.qtDechetRamasser(tabVaisseaux[1]);

        //Collections.sort(arrayDechets);

    }
}
