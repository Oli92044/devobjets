package Planete;

import java.util.ArrayList;
import java.util.Random;
import Recyclage.*;
import Transport.*;

public abstract class planete {

    private int pctPlutonium, pctThulium, pctGadolinium, pctTerbium, pctNeptunium;

    public planete(int pctPlutonium, int pctThulium, int pctGadolinium, int pctTerbium, int pctNeptunium) {
        this.pctPlutonium = pctPlutonium;
        this.pctThulium = pctThulium;
        this.pctGadolinium = pctGadolinium;
        this.pctTerbium = pctTerbium;
        this.pctNeptunium = pctNeptunium;
    }

    public int getPctPlutonium() {
        return pctPlutonium;

    }

    public void setPctPlutonium(int pctPlutonium) {
        this.pctPlutonium = pctPlutonium;
    }

    public int getPctThulium() {
        return pctThulium;
    }

    public void setPctThulium(int pctThulium) {
        this.pctThulium = pctThulium;
    }

    public int getPctGadolinium() {
        return pctGadolinium;
    }

    public void setPctGadolinium(int pctGadolinium) {
        this.pctGadolinium = pctGadolinium;
    }

    public int getPctTerbium() {
        return pctTerbium;
    }

    public void setPctTerbium(int pctTerbium) {
        this.pctTerbium = pctTerbium;
    }

    public int getPctNeptunium() {
        return pctNeptunium;
    }

    public void setPctNeptunium(int pctNeptunium) {
        this.pctNeptunium = pctNeptunium;
    }

    public int[] genererTypePlanete(Random rand){
        int typeA =0; int typeB =0; int typeC = 0; int typeD =0; int typeE=0;
        for (int i =0; i< rand.nextInt(150); i++){
            int newPlanete = rand.nextInt(5);
            if (newPlanete ==0)
                typeA++;
            else if (newPlanete == 1)
                typeB++;
            else if (newPlanete == 2)
                typeC++;
            else if (newPlanete ==3)
                typeD++;
            else if (newPlanete ==4)
                typeE++;
        }
        int[] tabPlanete = new int[5];
        tabPlanete[0] = typeA;
        tabPlanete[1] = typeB;
        tabPlanete[2] = typeC;
        tabPlanete[3] = typeD;
        tabPlanete[4] = typeE;

        return tabPlanete;
    }

    public int qtHumain(int capacite) {
        int humainRamasser;
        humainRamasser = capacite;
        return humainRamasser;
    }
}