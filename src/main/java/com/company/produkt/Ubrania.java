package com.company.produkt;

import com.company.Para;
import com.company.sciezkaKariery.Rzemieslnik;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;

public class Ubrania extends Produkt {
    private final SciezkaKariery sciezka = new Rzemieslnik();

    private int iloscUbran;
    private final double karaZaBrakUbran;
    private int jakosc;

    private ArrayList<Para> posiadaneUbrania;

    public Ubrania(double karaZaBrakUbran) {
        this.karaZaBrakUbran = karaZaBrakUbran;
    }

    private void zuzyjUbrania() {

    }

    public ArrayList<Para> ilePosiada() {
        return posiadaneUbrania;
    }

    public double ilePosiadaLacznie() { return iloscUbran; };

    public double dajPremieUbran() {
        zuzyjUbrania();

        if (iloscUbran < 100) {
            return karaZaBrakUbran;
        }
        return 0;
    }
}
