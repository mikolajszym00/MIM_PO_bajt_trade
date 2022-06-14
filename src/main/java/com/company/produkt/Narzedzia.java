package com.company.produkt;

import com.company.Para;
import com.company.sciezkaKariery.Inzynier;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;

public class Narzedzia extends Produkt {
    private final SciezkaKariery sciezka = new Inzynier();

    private ArrayList<Para> narzedzia;

    public void dodajNarzedzia() {
//        narzedzia
    }

    public ArrayList<Para> ilePosiada() {
        return narzedzia;
    }

    public double dajPremieNarzedzi() {
        double razem = 0;

        for (Para narzedziaZJakoscia: narzedzia) {
            int jakosc = narzedziaZJakoscia.daj1();
            double ilosc = narzedziaZJakoscia.daj2();

            razem += jakosc * ilosc;
        }

        narzedzia.clear(); // usuwamy narzedzia

        return razem/100;
    }
}
