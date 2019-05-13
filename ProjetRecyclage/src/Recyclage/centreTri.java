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
    private boolean statut;
    private Random generator = new Random();


    public centreTri() {
        this.qtHumain = 0;
        this.statut = true;
    }

    public LinkedList<vaisseau> getFile() {
        return file;
    }

    public void setQtHumain(int qtHumain) {
        this.qtHumain += qtHumain;
    }

    public boolean isStatut(){
        return statut;
    }

    //

    public static LinkedList<centreTri> creerCentreTris(int nbCentreTris) {
        LinkedList<centreTri> linkCentreTri = new LinkedList<>();
        for (int i = 0; i < nbCentreTris; i++) {
            linkCentreTri.add(new centreTri());
        }
        return linkCentreTri;
    }

    public void verifierPlein() {
        if (pileGad.size() == 100 || pileNep.size() == 100 || pilePluto.size() == 100 || pileTer.size() == 100 || pileThu.size() == 100 || qtHumain==10000) {
            statut = false;
        }

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

        file.add(v);
        if(file.size()==10)
            filePleine();

    }

    public void envoyerDechetsRejete(ArrayList<dechets> dechets){
        try {
            file.getFirst().ramasserDechetsCentreTri(dechets);
            file.getFirst().associerPlanete(generator);
            file.pollFirst();
        } catch (NullPointerException ex){
            System.out.println("NullPointerExeption lors de : Ramasser dechets recyclés du centre de tri");
        } catch (EmptyStackException ex){
            System.out.println("EmptyStack lors de : Ramasser dechets recyclés du centre de tri");
        }
    }

    public void filePleine(){
        file.getFirst().associerPlanete(generator);
        file.pollFirst();
    }

    public void recycler() {
        verifierPlein();
        if (!statut) {
            if (pileGad.size() == 100) {
                for(int i = 0;i<100-(new gadolinium().getPctRecycler());i++) {
                    pileGad.pop();
                }
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileGad);
                pileGad.clear();
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileNep.size() == 100) {
                for(int i = 0;i<100-(new neptunium().getPctRecycler());i++) {
                    pileNep.pop();
                }
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileNep);
                pileNep.clear();
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pilePluto.size() == 100) {
                for(int i = 0;i<100-(new plutonium().getPctRecycler());i++) {
                    pilePluto.pop();
                }
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pilePluto);
                pilePluto.clear();
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileTer.size() == 100) {
                for(int i = 0;i<100-(new terbium().getPctRecycler());i++) {
                    pileTer.pop();
                }
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileTer);
                pileTer.clear();
                envoyerDechetsRejete(dechetsArrayList);
            } else if (pileThu.size() == 100) {
                for(int i = 0;i<100-(new thulium().getPctRecycler());i++) {
                    pileThu.pop();
                }
                ArrayList<dechets> dechetsArrayList = new ArrayList<>(pileThu);
                pileThu.clear();
                envoyerDechetsRejete(dechetsArrayList);
            }
        }
    }

    public void combienDeDechets(){
        System.out.println("Nombre de gadolinium : " + pileGad.size());
        System.out.println("Nombre de neptunium : " + pileNep.size());
        System.out.println("Nombre de plutonium : " + pilePluto.size());
        System.out.println("Nombre de terbium : " + pileTer.size());
        System.out.println("Nombre de thulium : " + pileThu.size());
        System.out.println("Nombre d'humains : " + qtHumain);
    }

    public int[] tabNombreDechet(){
        int[] tabQuantite = new int[7];
        tabQuantite[0] = pileGad.size();
        tabQuantite[1] = pileNep.size();
        tabQuantite[2] = pilePluto.size();
        tabQuantite[3] = pileTer.size();
        tabQuantite[4] = pileThu.size();
        tabQuantite[5] = qtHumain;
        tabQuantite[6] = pileGad.size()+pileNep.size()+pilePluto.size()+pileTer.size()+pileThu.size();

        return tabQuantite;
    }


}