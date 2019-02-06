package Personnages;

public abstract class Personnage {
    private int ptsDeVie;
    private int ptsDeDefense;
    private String nom;
    private boolean statut = true;

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
}
