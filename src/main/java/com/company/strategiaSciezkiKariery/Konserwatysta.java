package com.company.strategiaSciezkiKariery;

import com.company.sciezkaKariery.SciezkaKariery;

public class Konserwatysta extends StrategiaSciezkiKariery {

    public Konserwatysta(SciezkaKariery sciezka) {
        super(sciezka);
    }

    public SciezkaKariery wybierzSciezke() {
        return aktualnaSciezka;
    }

    public void ustawSciezke(SciezkaKariery sciezka) {}
}
