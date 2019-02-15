package Armes;

public final class Épée_magique extends Armes implements Tranchant, Magique {

    public Épée_magique(){
        super("Épée magique");
    }

    public int trancher() {
        return 6;
    }

    public int lancerUnSort() {
        return 3;
    }

}
