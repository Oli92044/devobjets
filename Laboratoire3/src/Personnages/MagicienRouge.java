package Personnages;
import Sorts.*;
import Armes.*;
import java.util.Scanner;

public final class MagicienRouge extends Magicien {

    public MagicienRouge() {
        setPtsDeMagie(40);
        setSorts(new Empoisonnement(),0);
        setSorts(new MortSubite(),1);
        setNom("le Magicien Rouge");
    }

}

