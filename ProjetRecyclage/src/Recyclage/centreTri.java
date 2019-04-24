package Recyclage;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import Transport.*;
import Planete.*;

public class centreTri {

    private Stack<plutonium> pilePluto;
    private Stack<neptunium> pileNep;
    private Stack<gadolinium> pileGad;
    private Stack<terbium> pileTer;
    private Stack<thulium> pileThu;
    private PriorityQueue<vaisseau> file;
    private int qtHumain;


    public centreTri() {
        this.pilePluto = new Stack<>();
        this.pileNep = new Stack<>();
        this.pileGad = new Stack<>();
        this.pileTer =new Stack<>();
        this.pileThu = new Stack<>();
        this.file = new PriorityQueue<>();
        this.qtHumain = 100;
    }

    public static  centreTri[] creerCentreTris(int nbCentreTris) {
        centreTri[] centreTri = new centreTri[nbCentreTris];
        for (int i = 0 ; i < nbCentreTris ; nbCentreTris++) {
            centreTri[i] = new centreTri();
        }
        return centreTri;
    }

    public void MaxVaisseau(centreTri centreTri, typeA typeA, typeB typeB, typeC typeC, typeD typeD, typeE typeE) {

        Random random = new Random();
        if (centreTri.file.size() >= 10) {

            switch (random.nextInt(5)) {

                case 0 :
                case 1 :
                case 2 :
                case 3 :
                case 4 :
            }
        }
    }

    public void CapaciteMaxPile(centreTri centreTri) {

        if (centreTri.pileGad.capacity() >= 100 || centreTri.pileNep.capacity() >= 100 || centreTri.pilePluto.capacity() >= 100 || centreTri.pileTer.capacity() >= 100 || centreTri.pileThu.capacity() >= 100) {

        }
    }
}