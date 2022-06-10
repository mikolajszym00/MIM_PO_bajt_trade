package com.company.produkt;

import com.company.Oferta;

import java.util.ArrayList;

public class Narzedzia extends Produkt {
    private ArrayList<Oferta<Integer, Integer>> narzedzia;

    public void dodajNarzedzia() {
//        narzedzia
    }

    public double dajPremieNarzedzi() {
        double razem = 0;

        for (Oferta<Integer, Integer> narzedziaZJakoscia: narzedzia) {
            int jakosc = narzedziaZJakoscia.dajPierwszy();
            int ilosc = narzedziaZJakoscia.dajDrugi();

            razem += jakosc * ilosc;
        }

        narzedzia.clear(); // usuwamy narzedzia

        return razem/100;
    }
}
