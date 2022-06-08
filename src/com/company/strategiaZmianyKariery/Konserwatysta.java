package com.company.strategiaZmianyKariery;

import com.company.sciezkaKariery.SciezkaKariery;

public class Konserwatysta extends StrategiaZmianyKariery {

    public Konserwatysta(SciezkaKariery sciezka) {
        super(sciezka);
    }

    public SciezkaKariery wybierzSciezke() {
        return sciezka;
    }

    public void ustawSciezke(SciezkaKariery sciezka) {}
}
