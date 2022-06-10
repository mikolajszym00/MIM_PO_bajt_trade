package com.company.gielda;

import com.company.produkt.Produkt;

import java.util.ArrayList;
import java.util.Collections;

public class Cennik {
    private ArrayList<Produkt> produkty;
    private ArrayList<Double> ceny;

    public void dodajCene(Produkt prod, double cena) {
        produkty.add(prod);
        ceny.add(cena);
    }

    public double cenaDlaProduktu(Produkt prod) {
        return ceny.get(produkty.indexOf(prod));
    }

    public Produkt ProduktDlaMaxCeny() {
        double maxCena = Collections.max(ceny);
        return produkty.get(ceny.indexOf(maxCena));
    }
}
