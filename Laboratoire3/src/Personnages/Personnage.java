package Personnages;

import Armes.Armes;

public abstract class Personnage {
    private int ptsDeVie;
    private int ptsDeDefense;
    private String nom;
    private boolean statut = true;
    private Armes armes;

    public Personnage(Armes _armes){
        this.armes = _armes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getPtsDeDefense() {
        return ptsDeDefense;
    }

    public void setPtsDeDefense(int ptsDeDefense) {
        this.ptsDeDefense = ptsDeDefense;
    }

    public int getPtsDeVie() {
        return ptsDeVie;
    }

    public void setPtsDeVie(int ptsDeVie) {
        this.ptsDeVie = ptsDeVie;
    }

    public abstract void attaquer(Personnage personnage);

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Armes getArmes() {
        return armes;
    }

    public void setArmes(Armes armes) {
        this.armes = armes;
    }

    public abstract void afficherMenuArmes();

    public void prendreDegats(int degats){
        setPtsDeVie(getPtsDeVie()-degats);
        if(getPtsDeVie()<0)
            setPtsDeVie(0);
        System.out.println(getPtsDeVie());
    }
}
