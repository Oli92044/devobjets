package Recyclage;

import java.util.*;

import Transport.*;
import Planete.*;

public class centreTri {

    private Stack<plutonium> pilePluto = new Stack<>();
    private Stack<neptunium> pileNep = new Stack<>();
    private Stack<gadolinium> pileGad = new Stack<>();
    private Stack<terbium> pileTer = new Stack<>();
    private Stack<thulium> pileThu = new Stack<>();
    private LinkedList<vaisseau> file = new LinkedList<>();
    private int qtHumain;
    private int longeurFile;


    public centreTri(int longeurFile) {
        this.qtHumain = 100;
        this.longeurFile = longeurFile;
    }

    public Stack<plutonium> getPilePluto() {
        return pilePluto;
    }

    public Stack<neptunium> getPileNep() {
        return pileNep;
    }

    public Stack<gadolinium> getPileGad() {
        return pileGad;
    }

    public Stack<terbium> getPileTer() {
        return pileTer;
    }

    public Stack<thulium> getPileThu() {
        return pileThu;
    }

    public LinkedList<vaisseau> getFile() {
        return file;
    }

    public int getQtHumain() {
        return qtHumain;
    }

    //

    public static centreTri[] creerCentreTris(int nbCentreTris, int nbShip) {
        centreTri[] centreTri = new centreTri[nbCentreTris];
        //Longueur selon nombre de vaisseaux (reste à voir si constant)
        for (int i = 0; i < nbCentreTris; i++) {
            centreTri[i] = new centreTri(Math.round((float) (nbCentreTris / nbShip)));
        }
        return centreTri;
    }

    public void MaxVaisseau(centreTri centreTri) {

        Random random = new Random();
        if (centreTri.file.size() >= 10) {
            switch (random.nextInt(5)) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
            }
        }
    }

    public boolean verifierPleinFile() {
        boolean plein = false;
        if (file.size() >= this.longeurFile)
            plein = true;
        return plein;
    }

    public boolean verifierPleinDechet() {
        if (pileGad.capacity() == 100 || pileNep.capacity() == 100 || pilePluto.capacity() == 100 || pileTer.capacity() == 100 || pileThu.capacity() == 100) {
            return true;
        } else
            return false;
    }

    public void remplirPiles(ArrayList<dechets> arrayDechets, vaisseau v) {

        for (dechets dechet : arrayDechets) {
            recycler();
            if (dechet instanceof plutonium) {
                pilePluto.add(new plutonium());
            } else if (dechet instanceof neptunium) {
                pileNep.add(new neptunium());
            } else if (dechet instanceof gadolinium) {
                pileGad.add(new gadolinium());
            } else if (dechet instanceof terbium) {
                pileTer.add(new terbium());
            } else if (dechet instanceof thulium) {
                pileThu.add(new thulium());
            }
        }

        /*File est maintenant une LinkedList au lieu d'une PriorityQueue*/
        file.add(v);
    }

    public void envoyerDechetsRejete(ArrayList<dechets> dechets){
        try {
            file.getFirst().ramasserDechetsCentreTri(dechets);
        } catch (NullPointerException ex){
            System.out.println("NullPointerExeption lors de : Ramasser dechets recyclés du centre de tri");
        }
    }

    public void recycler() {
        if (verifierPleinDechet()) {
            //recycler la pile pleine et l'envoyer dans le premier vaisseau de la file vers le prochain centre de tri
            if (pileGad.capacity() <= 100) {
                for(int i = 0;i<100-(new gadolinium().getPctRecycler());i++) {
                    pileGad.pop();
                }
                pileGad.clear();
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileGad);
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileNep.capacity() <= 100) {
                for(int i = 0;i<100-(new neptunium().getPctRecycler());i++) {
                    pileNep.pop();
                }
                pileNep.clear();
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileNep);
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pilePluto.capacity() <= 100) {
                for(int i = 0;i<100-(new plutonium().getPctRecycler());i++) {
                    pilePluto.pop();
                }
                pilePluto.clear();
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pilePluto);
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileTer.capacity() <= 100) {
                for(int i = 0;i<100-(new terbium().getPctRecycler());i++) {
                    pileTer.pop();
                }
                pileTer.clear();
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileTer);
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileThu.capacity() <= 100) {
                for(int i = 0;i<100-(new thulium().getPctRecycler());i++) {
                    pileThu.pop();
                }
                pileThu.clear();
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileThu);
                envoyerDechetsRejete(dechetsArrayList);
            }
        }
    }

}