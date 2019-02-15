package Armes;

public final class Épée extends Armes implements Tranchant {

    public Épée(){
        super("Épée");
    }

    public int trancher() {
        return 5;
    }

}
