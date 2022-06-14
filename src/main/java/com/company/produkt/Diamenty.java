package com.company.produkt;

import com.company.Para;

import java.util.ArrayList;

public class Diamenty extends Produkt{
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
