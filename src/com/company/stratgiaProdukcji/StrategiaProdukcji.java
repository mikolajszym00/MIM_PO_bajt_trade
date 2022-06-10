package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Para;
import com.company.produkt.Produkt;

import java.util.Map;

public abstract class StrategiaProdukcji {
    protected Map<Produkt, Double> produkcjaBazowa;
    public abstract Para<Produkt, Double> produkujPrzedmioty(Majatek kariera, Cennik cennik);

    protected double produkuj(Majatek majatek, Produkt prod) { // powinien byc int
        double baza = produkcjaBazowa.get(prod);
        double premiaPoziom = prod.dajWartoscPoziomu() * baza;
        double premiaGlod = majatek.dajJedzenie().dajPremieGlodu() * baza;
        double premiaUbran = majatek.dajUbrania().dajPremieUbran() * baza;
        double premiaNarzedzia = majatek.dajNarzedzia().dajPremieNarzedzi() * baza;

        return baza + premiaPoziom + premiaGlod + premiaUbran + premiaNarzedzia;
    }
}
