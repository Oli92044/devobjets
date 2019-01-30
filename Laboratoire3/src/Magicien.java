public class Magicien extends Personnage {
    private int ptsDeMagie;
    private Sort[] sorts = new Sort[2];

    public Magicien(){
        setPtsDeDefense(1);
        setPtsDeVie(60);
    }

    public static void Attaque(){

    }

    public void setSorts(Sort sorts, int sortCase) {
        this.sorts[sortCase] = sorts;
    }

    public Sort getSorts(int sortCase) {
        return sorts[sortCase];
    }

    public int getPtsDeMagie() {
        return ptsDeMagie;
    }

    public void setPtsDeMagie(int ptsDeMagie) {
        this.ptsDeMagie = ptsDeMagie;
    }
}
