package com.company.produkt;

public class Narzedzia extends Produkt {
    private int iloscNarzedzi;
    private int jakosc;

    public double dajPremieNarzedzi() {
        return iloscNarzedzi * jakosc;
    }
}
