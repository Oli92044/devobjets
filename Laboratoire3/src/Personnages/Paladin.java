package Personnages;
import Armes.*;

import java.util.Scanner;

public final class Paladin extends Guerrier {
    private Tranchant arme;
    public Paladin(){
        setPtsDeVie(80);
        setPtsDeDefense(5);
        setPtsDeForce(5);
        setNom("le Paladin");
        arme = new Épée();
        int ptsAjouter = arme.trancher();
    }

    public void afficherMenuArmes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel arme voulez-vous?");
        System.out.println("1 - Épée" +
                "\n2 - Épée lourde" +
                "\n3 - Masamune" +
                "\n4 - Épée magique");
        char choixArme = sc.nextLine().charAt(0);
        switch (choixArme) {
            case '1':
                setArmes(new Épée());
                break;
            case '2':
                setArmes(new Épée_lourde());
                break;
            case '3':
                setArmes(new Masamune());
                break;
            case '4':
                setArmes(new Épée_magique());
                break;
            default:
                setArmes(new Épée());
                break;
        }
    }
}
