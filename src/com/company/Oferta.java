package com.company;

import com.company.produkt.Produkt;

import java.util.ArrayList;

public class Oferta { // moze rozbic na klasy: Jakosciowa, Zwykla, Cenowa
    Produkt prod;
    double razem;

    ArrayList<Integer> jakosci;
    ArrayList<Integer> ilosci;

    public Oferta(Produkt prod, double razem) { // jesli jedzenie
        this.prod = prod;
        this.razem = razem;
    }

    public Oferta(Produkt prod, ArrayList<Integer> jakosci, ArrayList<Integer> ilosci) { // jesli narzedzia, ubrania lub programy
        this.prod = prod;
        this.jakosci = jakosci;
        this.ilosci = ilosci;

    }

    public Oferta(Produkt prod, int jakosc, double ilosc) {

    }

     public dajListePozycji() {

     }



    public boolean czyDopuszczony() {
        return !prod.czyDiamenty();
    }

}
