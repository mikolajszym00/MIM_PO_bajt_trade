package com.company.produkt;

public abstract class Produkt {
    private final double[] wartoscPoziomu = {0.5, 1.5, 3};
    int poziom;

    public int dajPoziom() {
        return poziom;
    }

    public double dajWartoscPoziomu() {
        if (poziom >= 4) { return  3 + poziom * 0.25; }
        return wartoscPoziomu[poziom-1];
    }

}
