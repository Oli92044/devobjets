public class Occupation {
    private String poste;
    private Entreprise occupationEntreprise;

    public Occupation(){
        poste = "Gérant";
        occupationEntreprise = new Entreprise();
    }

    public Entreprise getOccupationEntreprise() {
        return occupationEntreprise;
    }

    public void setOccupationEntreprise(Entreprise occupationEntreprise) {
        this.occupationEntreprise = occupationEntreprise;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
