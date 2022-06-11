package com.company.produkt;

public class Diamenty extends Produkt{
    double iloscDiamentow;

    public void zmienIloscDiamentow(double ilosc) {
        iloscDiamentow += ilosc;
    }

    public double ile() {
        return iloscDiamentow;
    }

    public void dodaj(double wartosc) {
        iloscDiamentow += wartosc;
    }

    public void odejmij(double wartosc) {
        iloscDiamentow += wartosc;
    }
}
