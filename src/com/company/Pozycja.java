package com.company;

import com.company.produkt.Produkt;

import java.util.ArrayList;

public class Pozycja {
    public Produkt prod;
    public double ilosc;
    public double cena;
    public int jakosc;


//    public Pozycja(Produkt prod, double razem) {
//        this.prod = prod;
//        this.razem = razem;
//    }
//
//    public Pozycja(Produkt prod, double razem, int jakosc) {
//        this.prod = prod;
//        this.razem = razem;
//        this.jakosc = jakosc;
//    }

    public Pozycja(Produkt prod, double ilosc, int jakosc, double cena) {
        this.prod = prod;
        this.ilosc = ilosc;
        this.cena = cena;
        this.jakosc = jakosc;
    }

//    public Produkt dajProdukt() {
//        return prod;
//    }
//
//    public double dajRazem() {
//        return razem;
//    }
//
//    public double dajCena() {
//        return cena;
//    }
//
//    public int dajJakosc() {
//        return jakosc;
//    }
//
//    public int dajIlosc() {
//        return ilosc;
//    }
//
//    public void zmienProdukt(Produkt prod) {
//        this.prod = prod;
//    }
//
//    public double zmienRazem(double razem) {
//        return razem;
//    }

//    public double zmienCena() {
//        return cena;
//    }
//
//    public int zmienJakosc() {
//        return jakosc;
//    }
//
//    public int zmienIlosc() {
//        return ilosc;
//    }

}
