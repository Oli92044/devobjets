public class MagicienNoir extends Magicien {

    public MagicienNoir(){
        setPtsDeMagie(50);

        setSorts(new BouleDeFeu(),0);
        setSorts(new PicDeGlace(),1);
    }
}
