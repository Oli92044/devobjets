package Sorts;

import Personnages.Personnage;

public final class BouleDeFeu extends Sort {

    public BouleDeFeu(){
        setCout(5);
        setNom("Boule de Feu");
    }

    public void lancerSort(Personnage personnage){
        personnage.setPtsDeVie(personnage.getPtsDeVie()-5);
    }
}
