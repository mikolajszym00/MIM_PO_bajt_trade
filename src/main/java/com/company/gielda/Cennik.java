package com.company.gielda;

import com.company.produkt.Produkt;

import java.util.Collections;
import java.util.Map;

public class Cennik {
    private Map<Produkt, Double> cenaWczoraj;
    private Map<Produkt, Double> sredniaCenaWczoraj; // Wczoraj/Stara
    private Map<Produkt, Double> sumaCenDzis;
    private int iloscTransakcjiDzis;

    public Cennik(Map<Produkt, Double> ceny) {
        cenaWczoraj = ceny;
    }
//    private ArrayList<Produkt> produkty;
//    private ArrayList<Double> ceny;

//    public void dodajCene(Produkt prod, double cena) {
//        produkty.add(prod);
//        ceny.add(cena);
//    }

    public Produkt ProduktDlaMaxCeny() { // naprawic
        double maxCena = Collections.max(ceny);
        return produkty.get(ceny.indexOf(maxCena));
    }

    public double dajCenaWczoraj(Produkt prod) {
        return cenaWczoraj.get(prod);
    }

    public void dodajDoSredniej(Produkt prod, double cena, double ilosc) {
        sumaCenDzis.replace(prod, sumaCenDzis.get(prod)+cena*ilosc);
        ++iloscTransakcjiDzis;
    }

    // trzeba jeszcze ustwic nowe ceny
}
