package com.company.sciezkaKariery;

import com.company.produkt.Jedzenie;
import com.company.produkt.Produkt;

public class Rolnik extends SciezkaKariery {
    private final Produkt produkt = new Jedzenie();

    @Override
    public Produkt dajProdukt() {
        return produkt;
    }
}
