package com.company.produkt;

import com.company.Oferta;
import com.company.Para;

import java.util.ArrayList;

public class Narzedzia extends Produkt {
    private ArrayList<Para> narzedzia;

    public void dodajNarzedzia() {
//        narzedzia
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
