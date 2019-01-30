public class Telephone {
    private String numero;
    private String type;

    public Telephone(){
        numero = "XXX-XXX-XXXX";
        type = "Cellulaire";
    }

    public String getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setType(String type) {
        this.type = type;
    }
}
