package Personnages;

import Armes.Masamune;
import Armes.Masse;
import Armes.Sceptre;
import Armes.Épée_lourde;

import java.util.Scanner;

public final class Barbare extends Guerrier{

    public Barbare(){
        setPtsDeDefense(3);
        setPtsDeForce(10);
        setPtsDeVie(100);
        setNom("le Barbare");
    }

    public void afficherMenuArmes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel arme voulez-vous?");
        System.out.println("1 - Masse" +
                "\n2 - Épée lourde" +
                "\n3 - Masamune" +
                "\n4 - Sceptre");
        char choixArme = sc.nextLine().charAt(0);
        switch (choixArme) {
            case '1':
                setArmes(new Masse());
                break;
            case '2':
                setArmes(new Épée_lourde());
                break;
            case '3':
                setArmes(new Masamune());
                break;
            case '4':
                setArmes(new Sceptre());
                break;
            default:
                setArmes(new Masse());
                break;
        }
    }
}
