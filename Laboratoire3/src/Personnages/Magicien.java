package Personnages;
import java.util.Random;
import java.util.Scanner;

import Armes.*;
import Sorts.Sort;

public abstract class Magicien extends Personnage{
    private int ptsDeMagie;
    private Sort[] tabSorts = new Sort[2];

    public Magicien(){
        super(new Baguette());
        setPtsDeDefense(1);
        setPtsDeVie(60);
    }

    public  void attaquer(Personnage personnage){
        Random generator = new Random();
        if(ptsDeMagie < 2){
            System.out.println(getNom() + "n'a pas assez de points de magie pour continuer.");
            setStatut(false);
        }
        else {
            int sortNumero = generator.nextInt(2);
            if (tabSorts[sortNumero].getCout() > getPtsDeMagie())
                if (sortNumero == 1)
                    sortNumero = 0;
                else
                    sortNumero = 1;
            System.out.println("\n"+getNom() + " attaque ! Il utilise le sort \"" + tabSorts[sortNumero].getNom() + "\", ce qui lui " +
                    "coûte " + tabSorts[sortNumero].getCout() + " points de magie.");
            setPtsDeMagie(getPtsDeMagie() - tabSorts[sortNumero].getCout());
            System.out.println("Il lui reste " + getPtsDeMagie() + " points de magie.");
            int ptsAvant = personnage.getPtsDeVie();
            tabSorts[sortNumero].lancerSort(personnage);
            if(personnage.getPtsDeVie()<0)
                personnage.setPtsDeVie(0);
            System.out.println(personnage.getNom() + " perd " + (ptsAvant - personnage.getPtsDeVie()) + " points de vie. Il lui en reste " + personnage.getPtsDeVie() + ".");
        }
    }

    public void setSorts(Sort sorts, int sortCase) {
        this.tabSorts[sortCase] = sorts;
    }

    public Sort getSorts(int sortCase) {
        return tabSorts[sortCase];
    }

    public int getPtsDeMagie() {
        return ptsDeMagie;
    }

    public void setPtsDeMagie(int ptsDeMagie) {
        this.ptsDeMagie = ptsDeMagie;
    }

    public void afficherMenuArmes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel arme voulez-vous?");
        System.out.println("1 - Baguette" +
                "\n2 - Sceptre" +
                "\n3 - Masamune" +
                "\n4 - Épée magique");
        char choixArme = sc.nextLine().charAt(0);
        switch (choixArme) {
            case '1':
                setArmes(new Baguette());
                break;
            case '2':
                setArmes(new Sceptre());
                break;
            case '3':
                setArmes(new Masamune());
                break;
            case '4':
                setArmes(new Épée_magique());
                break;
            default:
                setArmes(new Baguette());
                break;
        }
    }
}
