package Sorts;

import Personnages.Personnage;

import java.util.Random;

public final class MortSubite extends Sort {

    public MortSubite(){
        setCout(10);
        setNom("Mort Subite");
    }
    public void lancerSort(Personnage personnage){
        Random generator = new Random();

        int badluck = generator.nextInt(10);
        if(badluck == 7){
            personnage.setPtsDeVie(0);
        }
    }
}
