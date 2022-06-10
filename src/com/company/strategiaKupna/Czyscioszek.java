package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Para;
import com.company.produkt.Produkt;

public class Czyscioszek extends StrategiaKupna {

    public Para<Produkt, Double> coKupuje(Majatek majatek) { // zle
        return new Para<>(majatek.dajJedzenie(), 100.);
    }
}
