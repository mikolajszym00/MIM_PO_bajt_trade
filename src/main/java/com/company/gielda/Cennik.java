package com.company.gielda;

import com.company.produkt.Produkt;

import java.util.Map;

public class Cennik {
    private Map<Produkt, Double> cenaWczoraj;
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
//        double maxCena = Collections.max(sumaCenDzis);
//        return produkty.get(sumaCenDzis.indexOf(maxCena));

        return null;
    }

    public double dajCenaWczoraj(Produkt prod) {
        return cenaWczoraj.get(prod);
    }

    public void dodajDoSredniej(Produkt prod, double cena, double ilosc) {
        sumaCenDzis.replace(prod, sumaCenDzis.get(prod)+cena*ilosc);
        ++iloscTransakcjiDzis;
    }

    public void aktualizujCeny() {
        for(Produkt prod: cenaWczoraj.keySet()) {
            cenaWczoraj.replace(prod, sumaCenDzis.get(prod)/iloscTransakcjiDzis);

            sumaCenDzis.replace(prod, 0.);
            iloscTransakcjiDzis = 0;
        }
    }
}
