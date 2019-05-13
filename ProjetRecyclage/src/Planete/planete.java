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

    public int getPctThulium() {
        return pctThulium;
    }

    public int getPctGadolinium() {
        return pctGadolinium;
    }

    public int getPctTerbium() {
        return pctTerbium;
    }

    public int getPctNeptunium() {
        return pctNeptunium;
    }

    public void setPctPlutonium(int pctPlutonium) {
        this.pctPlutonium = pctPlutonium;
    }

    public void setPctThulium(int pctThulium) {
        this.pctThulium = pctThulium;
    }

    public void setPctGadolinium(int pctGadolinium) {
        this.pctGadolinium = pctGadolinium;
    }

    public void setPctTerbium(int pctTerbium) {
        this.pctTerbium = pctTerbium;
    }

    public void setPctNeptunium(int pctNeptunium) {
        this.pctNeptunium = pctNeptunium;
    }

    public int qtHumain(int capacite) {
        int humainRamasser;
        humainRamasser = capacite;
        return humainRamasser;
    }
}