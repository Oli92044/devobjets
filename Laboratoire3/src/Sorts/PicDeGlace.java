package Sorts;

import Personnages.Personnage;

public final class PicDeGlace extends Sort {

    public PicDeGlace(){
        setCout(5);
        setNom("Pic de Glace");
    }

    public void lancerSort(Personnage personnage){
        personnage.setPtsDeVie(personnage.getPtsDeVie()-(7-personnage.getPtsDeDefense()));
    }
}
