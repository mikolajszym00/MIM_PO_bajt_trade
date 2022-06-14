package com.company.spekulant;

import com.company.Oferta;
import com.company.Para;
import com.company.gielda.Cennik;
import com.company.gielda.Gielda;
import com.company.produkt.Produkt;

import java.util.ArrayList;
import java.util.Map;

public class Sredni extends Spekulant {
    private int historia_spekulanta_sredniego;
    private Map<Produkt, ArrayList<Double>> srednieCeny;

    private double policzCene(ArrayList<Double> ceny) {
        double suma = 0;

        for(double wartosc: ceny) {
            suma += wartosc;
        }

        return suma/historia_spekulanta_sredniego;
    }

    public void wystawSprzedaz(Gielda gielda) {
        Oferta oferta = new Oferta();

        for(Produkt prod: srednieCeny.keySet()){
            double sredniaCena = policzCene(srednieCeny.get(prod));

            for(Para jakoscIlosc: prod.ilePosiada()) {
                oferta.dodaj(this, prod, jakoscIlosc.daj2(), jakoscIlosc.daj1(), sredniaCena * 1.1);
            }
        }

        gielda.dodajdoSprzedazySpekulant(this, oferta);
    }

    public void wystawKupno(Gielda gielda) {
        Oferta oferta = new Oferta();

        for(Produkt prod: srednieCeny.keySet()){
            double sredniaCena = policzCene(srednieCeny.get(prod));

            if (prod.ilePosiada() == null) {
                oferta.dodaj(this, prod, 100, -1, sredniaCena * 0.95);
            } else {
                oferta.dodaj(this, prod, 100, -1, sredniaCena * 0.90);
            }

            gielda.dodajDoKupnaSpekulant(this, oferta);
        }
    }

    public void aktualizujSrednieCeny(Cennik cennik) {
        if (srednieCeny.size() >= historia_spekulanta_sredniego) {
            for(Produkt prod: srednieCeny.keySet()) {
                srednieCeny.get(prod).remove(0);
            }
        }

        for(Produkt prod: srednieCeny.keySet()) {
            srednieCeny.get(prod).add(cennik.dajCenaWczoraj(prod)); // cena aktualna
        }

    }

    public void usunPrzedmioty() {

    }

}
