package Armes;

public final class Sceptre extends Armes implements Contondant, Magique {

    public Sceptre(){
        super("Sceptre");
    }

    public int Frapper(){
        return 3;
    }

    public int lancerUnSort() {
        return 6;
    }
}
