package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;

public class Czyscioszek extends StrategiaKupna {

    public Oferta coKupuje(Majatek majatek) {
        Oferta oferta = new Oferta();
        oferta.dodaj(majatek.dajJedzenie(), 100.);

        if (majatek.dajUbrania().ilePosiadaLacznie() < 100) {
            oferta.dodaj(majatek.dajUbrania(), 100 - majatek.dajUbrania().ilePosiadaLacznie());
        }

        return oferta;
    }
}
