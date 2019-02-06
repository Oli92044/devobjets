package Personnages;

public abstract class Guerrier extends Personnage {
    private int ptsDeForce;

    public void attaquer(Personnage personnage) {
        System.out.println("\n"+getNom() + " attaque !");
        System.out.print(personnage.getNom() + " perd " + ((ptsDeForce * 2) - personnage.getPtsDeDefense()) + " points de vie. Il lui en reste ");
        personnage.setPtsDeVie(personnage.getPtsDeVie() - ((ptsDeForce * 2) - personnage.getPtsDeDefense()));
        if(personnage.getPtsDeVie()<0)
            personnage.setPtsDeVie(0);
        System.out.println(personnage.getPtsDeVie());
    }

    public int getPtsDeForce() {
        return ptsDeForce;
    }

    public void setPtsDeForce(int ptsDeForce) {
        this.ptsDeForce = ptsDeForce;
    }
}
