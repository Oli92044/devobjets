package Personnages;

import Armes.*;


public abstract class Guerrier extends Personnage {
    private int ptsDeForce;

    public Guerrier(){
        super(new Épée_lourde());
    }

    public void attaquer(Personnage personnage) {
        System.out.println("\n"+getNom() + " attaque !");

        int degats = (ptsDeForce * 2) - personnage.getPtsDeDefense();
        System.out.print(personnage.getNom() + " perd " + degats + " points de vie. Il lui en reste ");
        personnage.prendreDegats(degats);
        System.out.println(personnage.getPtsDeVie());
    }



    public int getPtsDeForce() {
        return ptsDeForce;
    }

    public void setPtsDeForce(int ptsDeForce) {
        this.ptsDeForce = ptsDeForce;
    }

}