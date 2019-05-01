package Transport;

import java.util.*;

import Recyclage.*;
import Planete.*;

public abstract class vaisseau {
    private int quantite;
    private boolean statut;
    private String type;
    private ArrayList<dechets> arrayDechets;
    private planete planeteAssocier;

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

    public void ramasserDechetsPlanete() {

        for (int i = 0; i < quantite; i++) {
            Random generator = new Random();
            int quantite = generator.nextInt(100);
            if (quantite < planeteAssocier.getPctPlutonium()) {
                arrayDechets.add(new plutonium());
            } else if (quantite < planeteAssocier.getPctThulium()) {
                arrayDechets.add(new thulium());
            } else if (quantite < planeteAssocier.getPctGadolinium()) {
                arrayDechets.add(new gadolinium());
            } else if (quantite < planeteAssocier.getPctTerbium()) {
                arrayDechets.add(new terbium());
            } else if (quantite < planeteAssocier.getPctNeptunium()) {
                arrayDechets.add(new neptunium());
            }
        }

    }

    public void ramasserDechetsCentreTri(ArrayList<dechets> arrayDechetsTri){
        statut = true;
        this.arrayDechets = arrayDechetsTri;
        statut = false;
    }

    public void viderVaisseau(centreTri[] tabCentreTri){
        statut = false;
        int positionTableau = 0;
        for (int i = 0; i<tabCentreTri.length;i++){
            if (!tabCentreTri[i].verifierPleinDechet()){
                positionTableau = i;
                break;
            }
        }
        tabCentreTri[positionTableau].remplirPiles(arrayDechets,this);
        arrayDechets.clear();
    }

    public void associerPlanete(planete planeteAssocier) {
        this.planeteAssocier = planeteAssocier;
    }

}
