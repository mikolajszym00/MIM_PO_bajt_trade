package com.company;

import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;
import java.util.Collections;

public class Cennik {
    private ArrayList<SciezkaKariery> sciezki;
    private ArrayList<Double> ceny;

    public void dodajCene(SciezkaKariery sciezka, double cena) { // zamiast scizki pewnie powinien byc produkt
        sciezki.add(sciezka);
        ceny.add(cena);
    }

    public double cenaDlaSciezki(SciezkaKariery sciezka) {
        return ceny.get(sciezki.indexOf(sciezka));
    }

    public ArrayList<SciezkaKariery> dajSciezki() {
        return sciezki;
    }

    public SciezkaKariery SciezkaDlaMaxCeny() {
        double maxCena = Collections.max(ceny);
        return sciezki.get(ceny.indexOf(maxCena));
    }
}
