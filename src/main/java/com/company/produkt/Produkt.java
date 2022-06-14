package com.company.produkt;

import com.company.Para;

import java.util.ArrayList;

public abstract class Produkt {
    private final double[] wartoscPoziomu = {0.5, 1.5, 3};
    private int poziom;

    public int dajPoziom() {
        return poziom;
    }

    public abstract ArrayList<Para> ilePosiada();

    public double dajWartoscPoziomu() {
        if (poziom >= 4) { return  3 + poziom * 0.25; }
        return wartoscPoziomu[poziom-1];
    }

}
