package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Jedzenie;
import com.company.produkt.Produkt;

public class Czyscioszek extends StrategiaKupna {

    public Oferta coKupuje(Majatek majatek) {
        return new Oferta(majatek.dajJedzenie(), 100.);
    }
}
