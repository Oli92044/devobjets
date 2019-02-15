package Armes;

public final class Baguette  extends Armes implements Magique {

    public Baguette(){
        super("Baguette");
    }

    public int lancerUnSort() {
        return 5;
    }
}
