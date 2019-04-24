package Transport;

import java.util.Random;

public abstract class vaisseau {
    private int quantite;
    private boolean statut;
    private String type;

    public vaisseau(int quantite, boolean statut, String type){
        this.quantite = quantite;
        this.statut = statut;
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getType() {
        return type;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public static vaisseau[] creerVaisseaux(int nbVaisseau, Random generator){

        vaisseau tabVaisseau[] = new vaisseau[nbVaisseau];

        for(int i = 0;i<tabVaisseau.length;i++){
            int hazard = generator.nextInt(3);
            if(hazard == 0)
                tabVaisseau[i] = new lightShip();
            else if(hazard == 1)
                tabVaisseau[i] = new mediumShip();
            else if(hazard == 2)
                tabVaisseau[i] = new heavyShip();
        }
        return tabVaisseau;
    }
}
