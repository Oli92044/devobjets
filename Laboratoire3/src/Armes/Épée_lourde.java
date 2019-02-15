package Armes;

public final class Épée_lourde extends Armes implements Tranchant, Contondant {

    public Épée_lourde(){
        super("Épée lourde");
    }

    public int trancher() {
        return 6;
    }

    public int Frapper(){
        return 3;
    }


}
