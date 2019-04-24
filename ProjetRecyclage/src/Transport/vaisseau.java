package Transport;

import java.util.*;

import Recyclage.*;
import Planete.*;

public abstract class vaisseau {
    private int quantite;
    private boolean statut;
    private String type;
    private ArrayList<dechets> arrayDechets;

    public vaisseau(int quantite, boolean statut, String type) {
        this.quantite = quantite;
        this.statut = statut;
        this.type = type;
        arrayDechets = new ArrayList<>();
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

    public static vaisseau[] creerVaisseaux(int nbVaisseau, Random generator) {

        vaisseau[] tabVaisseau = new vaisseau[nbVaisseau];

        for (int i = 0; i < tabVaisseau.length; i++) {
            int hazard = generator.nextInt(3);
            if (hazard == 0)
                tabVaisseau[i] = new lightShip();
            else if (hazard == 1)
                tabVaisseau[i] = new mediumShip();
            else if (hazard == 2)
                tabVaisseau[i] = new heavyShip();
        }
        return tabVaisseau;
    }

    public ArrayList<dechets> getArrayDechets() {
        return arrayDechets;
    }

    public void setArrayDechets(ArrayList<dechets> arrayDechets) {
        this.arrayDechets = arrayDechets;
    }

    public void qtDechetRamasser(planete planete) {

        for (int i = 0; i < quantite; i++) {
            Random generator = new Random();
            int quantite = generator.nextInt(100);
            if (quantite < planete.getPctPlutonium()) {
                arrayDechets.add(new plutonium());
            } else if (quantite < planete.getPctThulium()) {
                arrayDechets.add(new thulium());
            } else if (quantite < planete.getPctGadolinium()) {
                arrayDechets.add(new gadolinium());
            } else if (quantite < planete.getPctTerbium()) {
                arrayDechets.add(new terbium());
            } else if (quantite < planete.getPctNeptunium()) {
                arrayDechets.add(new neptunium());
            }
        }
        Collections.sort(arrayDechets);
    }

    public ArrayList<dechets> viderVaisseau(){
        ArrayList<dechets> arrayDonner = arrayDechets;
        arrayDechets.clear();
        return arrayDonner;
    }
}
