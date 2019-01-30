public class MagicienRouge extends Magicien {

    public MagicienRouge() {
        setPtsDeMagie(40);
        setSorts(new Empoisonnement(),0);
        setSorts(new MortSubite(),1);
    }


}

