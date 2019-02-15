package Armes;

public abstract class Armes{

    private String nom;

    public Armes(String _nom){
        this.nom = _nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}