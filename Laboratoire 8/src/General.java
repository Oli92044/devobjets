/*
 *  Created by Olivier Blackburn
 */

import java.util.*;

public class General {

    public static char afficherMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nComment voulez-vous mettre la liste en ordre ?" +
                "\n1-Algorithm de selection" +
                "\n2-Collections.sort en Comparable" +
                "\n3-Collections.sort en Comparator" +
                "\n4-TreeSet par année" +
                "\n5-TreeSet par comparator" +
                "\n6-Quitter");
        return sc.nextLine().charAt(0);
    }

    public static void main(String[] args) {

        while (true) {

            Livre[] listLivre = Livre.creerListe();
            ArrayList<Livre> list = Livre.toArrayLivre(listLivre);
            char choix;

            try {
                choix = afficherMenu();
            } catch (Exception ex){
                choix = 7;
            }

            if (choix == '1') {
                listLivre = Livre.selection(listLivre);
                Livre.show(listLivre);

            } else if (choix == '2') {
                Collections.sort(list);
                Livre.show(list);

            } else if (choix == '3') {
                Collections.sort(list, new ComparatorMaisonEd());
                Livre.show(list);

            } else if (choix == '4') {
                TreeSet<Livre> treeSet = new TreeSet<>(new ComparatorAnnee());
                treeSet.addAll(list);
                list.clear();
                list.addAll(treeSet);
                Livre.show(list);

            } else if (choix == '5') {
                TreeSet<Livre> treeSet = new TreeSet<>(new ComparatorMaisonEd());
                treeSet.addAll(list);
                list.clear();
                list.addAll(treeSet);
                Livre.show(list);

            } else if (choix == '6') {
                System.out.println("Au revoir !");
                break;

            } else {
                System.out.println("Choix non valide.");

            }
        }
    }
}
