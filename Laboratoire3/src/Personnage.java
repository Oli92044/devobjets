import java.util.Random;

public class Personnage {
    private int ptsDeVie;
    private int ptsDeDefense;
    private String nom;

    /*public Personnage(){
        Random generator = new Random();
        ptsDeDefense = generator.nextInt(50)+50;
        ptsDeDefense = generator.nextInt(50)+50;;
        nom = "Super-Banane";
    }*/

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

}
