package com.company.produkt;

public class Ubrania extends Produkt {
    private int iloscUbran;
    private final double karaZaBrakUbran;
    private int jakosc;

    // zuzycie ubran to tablica gdzie indeks to jakosc a wartosc to ilosc // arraylist

    public Ubrania(double karaZaBrakUbran) {
        this.karaZaBrakUbran = karaZaBrakUbran;
    }

    public void zuzyjUbrania() {


    }

    public double dajPremieUbran() {
        if (iloscUbran < 100) {
            return karaZaBrakUbran;
        }
        return 0;
    }
}
