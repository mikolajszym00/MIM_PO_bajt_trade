package com.company.sciezkaKariery;

import com.company.produkt.Diamenty;
import com.company.produkt.Produkt;

public class Gornik extends SciezkaKariery { // moze byc statyczna ?? // zamiana sciezki z produktem rolami. Wazne co proukuje
    private final Produkt produkt = new Diamenty();

    @Override
    public Produkt dajProdukt() {
        return produkt;
    }
}
