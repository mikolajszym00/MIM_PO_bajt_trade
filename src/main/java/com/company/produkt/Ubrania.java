package com.company.produkt;

import com.company.Para;

import java.util.ArrayList;

public class Ubrania extends Produkt {
    private int iloscUbran;
    private final double karaZaBrakUbran;
    private int jakosc;

    private ArrayList<Para> posiadaneUbrania;

    // zuzycie ubran to tablica gdzie indeks to jakosc a wartosc to ilosc // arraylist

    public Ubrania(double karaZaBrakUbran) {
        this.karaZaBrakUbran = karaZaBrakUbran;
    }

    private void zuzyjUbrania() {

    }

    public ArrayList<Para> ilePosiada() {
        return posiadaneUbrania;
    }

    public double dajPremieUbran() {
        zuzyjUbrania(); // zuzywanie ubran

        if (iloscUbran < 100) {
            return karaZaBrakUbran;
        }
        return 0;
    }
}
