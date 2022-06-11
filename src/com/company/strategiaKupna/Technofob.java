package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Jedzenie;
import com.company.produkt.Produkt;

public class Technofob extends StrategiaKupna {

    public Oferta coKupuje(Majatek majatek) {
        Oferta oferta = new Oferta();
        oferta.dodaj(majatek.dajJedzenie(), 100.);
        return oferta;
    }

}
