package Sorts;

import Personnages.Personnage;

public final class Empoisonnement extends Sort {
    private int ptsDegat;

    public Empoisonnement(){
        setCout(2);
        ptsDegat = 2;
        setNom("Empoisonnement");
    }

    public void lancerSort(Personnage personnage){
        personnage.setPtsDeVie(personnage.getPtsDeVie()-ptsDegat);
        ptsDegat += 2;
    }
}
