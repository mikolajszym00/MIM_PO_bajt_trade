package com.company;

import com.company.produkt.Produkt;

import java.util.ArrayList;

public class Pozycja {
    private Produkt prod;
    private double razem;
    private double cena;

    private ArrayList<Integer> jakosci;
    private ArrayList<Integer> ilosci;

    public Pozycja(Produkt prod, double razem) {

    }

    public Produkt dajProdukt() {
        return prod;
    }
}
