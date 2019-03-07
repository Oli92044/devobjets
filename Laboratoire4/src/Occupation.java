public class Occupation {
    private String poste;
    private Entreprise occupationEntreprise;

    public Occupation() {
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

    public void getOccupation(Contact contact){
        System.out.println("Occupation : " +
                "\n\tPoste : " + contact.getOccupationContact().getPoste());
        System.out.println("\tEntreprise : " +
                "\n\t\tNom : " + contact.getOccupationContact().getOccupationEntreprise().getNom());
        contact.getOccupationContact().getOccupationEntreprise().getAdresseEntreprise().getAdresse();
    }
}
