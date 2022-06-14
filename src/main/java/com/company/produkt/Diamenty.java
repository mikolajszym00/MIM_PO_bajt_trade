package com.company.produkt;

import com.company.Para;
import com.company.sciezkaKariery.Gornik;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;

public class Diamenty extends Produkt{
    private final SciezkaKariery sciezka = new Gornik();

    private double iloscDiamentow;

    public double ile() {
        return iloscDiamentow;
    }

    public ArrayList<Para> ilePosiada() { return null; }

    public void dodaj(double wartosc) {
        iloscDiamentow += wartosc;
    }

    public void odejmij(double wartosc) {
        iloscDiamentow += wartosc;
    }
}
