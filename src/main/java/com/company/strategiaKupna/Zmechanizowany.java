package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;

public class Zmechanizowany extends StrategiaKupna {
    private double liczba_narzedzi;

    public Oferta coKupuje(Majatek majatek) {
        Oferta oferta = new Oferta();
        oferta.dodaj(majatek.dajJedzenie(), 100.);
        oferta.dodaj(majatek.dajNarzedzia(), liczba_narzedzi);

        if (majatek.dajUbrania().ilePosiadaLacznie() < 100) {
            oferta.dodaj(majatek.dajUbrania(), 100 - majatek.dajUbrania().ilePosiadaLacznie());
        }

        return oferta;
    }
}
