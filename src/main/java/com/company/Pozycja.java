package com.company;

import com.company.produkt.Produkt;
import com.company.spekulant.Spekulant;

public class Pozycja {
    public Spekulant sp;
    public Produkt prod;
    public double ilosc;
    public double cena;
    public int jakosc;

    public Pozycja(Spekulant sp, Produkt prod, double ilosc, int jakosc, double cena) {
        this.sp = sp;
        this.prod = prod;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jakosc = jakosc;
    }
}