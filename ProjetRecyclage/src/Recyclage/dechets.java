package Recyclage;

public abstract class dechets implements Comparable<dechets> {

    private String nom;
    private float masseVolumique;
    private int pctRecycler;

    public dechets(String nom, float masseVolumique, int pctRecycler){
        this.nom = nom;
        this.masseVolumique = masseVolumique;
        this.pctRecycler = pctRecycler;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMasseVolumique() {
        return masseVolumique;
    }

    public void setMasseVolumique(float masseVolumique) {
        this.masseVolumique = masseVolumique;
    }

    public int getPctRecycler() {
        return pctRecycler;
    }

    public void setPctRecycler(int pctRecycler) {
        this.pctRecycler = pctRecycler;
    }

    @Override
    public int compareTo(dechets o) {
        if(masseVolumique==o.masseVolumique)
            return 0;
        else if(masseVolumique>o.masseVolumique)
            return 1;
        else
            return -1;
    }
}

