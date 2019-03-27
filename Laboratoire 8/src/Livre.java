/*
 *  Created by Olivier Blackburn
 */

import java.util.ArrayList;
import java.util.Random;

public class Livre implements Comparable<Livre>{
    String ISBN, titre, sousTitre, auteur, maisonEdition;
    int anneePub;

    public Livre(String _auteur, String _maisonEdition, int _anneePub){
        auteur = _auteur;
        anneePub = _anneePub;
        maisonEdition = _maisonEdition;
    }

    public static Livre[] creerListe(){
        Livre[] listLivre = new Livre[10];
        Random generator = new Random();

        for (int i = 0; i < listLivre.length; i++) {
            String auteur = Livre.obtenirNom();
            String maison = Livre.obtenirMaison();
            int anne = generator.nextInt(2019);

            listLivre[i] = new Livre(auteur, maison, anne);
        }
        return listLivre;
    }

    public static void show(Livre[] listLivre){
        for (int i = 0; i < listLivre.length; i++){
            System.out.println(listLivre[i].auteur +", " + listLivre[i].maisonEdition +", ("+ listLivre[i].anneePub + ")");
        }
    }

    public static void show(ArrayList<Livre> listLivre){
        for (int i = 0; i < listLivre.size(); i++){
            System.out.println(listLivre.get(i).auteur +", " + listLivre.get(i).maisonEdition +", ("+ listLivre.get(i).anneePub + ")");
        }
    }

    public static ArrayList<Livre> toArrayLivre(Livre[] listLivre){
        ArrayList<Livre> list = new ArrayList<>();
        for (int i = 0; i < listLivre.length; i++){
            list.add(listLivre[i]);
        }
        return list;
    }

    public static String obtenirNom(){
        Random generator = new Random();
        String nomJoueur = "Adam Alex Alexandre Alexis Anthony Antoine Benjamin Cedric Charles Christopher David Dylann Edouard Elliot Emile Etienne Felix Gabriel Guillaume Hugo Isaac Jacob Jeremy Jonathan Julien Justin Leo Logan Loic Louis Lucas Ludovic Malik Mathieu Mathis Maxime Michael Nathan Nicolas Noah Olivier Philippe Raphael Samuel Simon Thomas Tommy Tristan Arnold Schwarzenegger";
        String tabNom[] = nomJoueur.split(" ");
        return tabNom[generator.nextInt(tabNom.length)];
    }

    public static String obtenirMaison(){
        Random generator = new Random();
        String nomMaison = "Alire Akuma Boomerang ERPI Merlin Pastèque Varia XYZ Veuve";
        String tabMaison[] = nomMaison.split(" ");
        return tabMaison[generator.nextInt(tabMaison.length)];
    }

    public static Livre[] selection(Livre[] tabLivre) {

        for (int i = 0; i < tabLivre.length - 1; i++)
        {
            int index = i;
            for (int a = i + 1; a < tabLivre.length; a++)
                if (tabLivre[a].anneePub < tabLivre[index].anneePub)
                    index = a;

            Livre plusPetit = tabLivre[index];
            tabLivre[index] = tabLivre[i];
            tabLivre[i] = plusPetit;
        }
        return tabLivre;
    }

    @Override
    public int compareTo(Livre livre){
        if(anneePub==livre.anneePub)
            return 0;
        else if(anneePub>livre.anneePub)
            return 1;
        else
            return -1;
    }
}
