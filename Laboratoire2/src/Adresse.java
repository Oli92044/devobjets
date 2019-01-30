public class Adresse {
    private String numPorte;
    private String rue;
    private String appart;
    private String ville;
    private String province;
    private String pays;
    private String codePostale;

    public Adresse(){
        numPorte = "0000";
        rue = "Poisson";
        appart = "0";
        ville = "Saguenay";
        province = "Québec";
        pays = "Canada";
        codePostale = "A0B 1C2";
    }

    public String  getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(String numPorte) {
        this.numPorte = numPorte;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }
}
