package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;

public class Technofob extends StrategiaKupna {

    public Oferta coKupuje(Majatek majatek) {
        Oferta oferta = new Oferta();
        oferta.dodaj(majatek.dajJedzenie(), 100.);
        return oferta;
    }
}
