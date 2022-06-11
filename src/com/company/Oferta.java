package com.company;

import com.company.produkt.Produkt;

import java.util.ArrayList;

public class Oferta {
    private ArrayList<Pozycja> pozycje;

    public void dodaj(Produkt prod, double ilosc) {
        Pozycja pozycja = new Pozycja(prod, ilosc, -1, -1);

        pozycje.add(pozycja);
    }

    public void dodaj(Produkt prod, double ilosc, int jakosc) {
        Pozycja pozycja = new Pozycja(prod, ilosc, jakosc, -1);

        pozycje.add(pozycja);
    }

     public ArrayList<Pozycja> dajListePozycji() {
        return pozycje;
     }

     public boolean czyDiamenty(Majatek majatek) {
        return majatek.czyDiamenty(pozycje.get(0).prod);
     }
}
