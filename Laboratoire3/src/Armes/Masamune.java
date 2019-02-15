package Armes;

public final class Masamune  extends Armes  implements Tranchant, Contondant, Magique{

    public Masamune(){
        super("Masamune");
    }

    public int trancher() {
        return 6;
    }

    public int Frapper(){
        return 5;
    }

    public int lancerUnSort() {
        return 6;
    }


}