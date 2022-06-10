package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Produkt;

import java.util.Map;

public abstract class StrategiaProdukcji {
    protected Map<Produkt, Double> produkcjaBazowa;
    public abstract Oferta produkujPrzedmioty(Majatek kariera, Cennik cennik);

    protected double produkuj(Produkt prod, Majatek majatek) { // powinien byc int
        double baza = produkcjaBazowa.get(prod);
        double premiaPoziom = prod.dajWartoscPoziomu() * baza;
        double premiaGlod = majatek.dajJedzenie().dajPremieGlodu() * baza;
        double premiaUbran = majatek.dajUbrania().dajPremieUbran() * baza;
        double premiaNarzedzia = majatek.dajNarzedzia().dajPremieNarzedzi() * baza;

        double razem = baza + premiaPoziom + premiaGlod + premiaUbran + premiaNarzedzia;

        if (razem < 0) { return 0; }
        return razem;
    }

    protected Oferta stworzOferte(Produkt prod, double wyprodukowane) {
        if (czyDiamenty() || czyJedznie()) {
            return new Oferta(prod, wyprodukowane);
        } else {
            if (czyProgKomp()) {
                int poziom = prod.dajPoziom(); // tylko jesli to sciezka programisty inaczej 1

                return new Oferta(prod, poziom, wyprodukowane);
            } else {
                return dostosujOferte(prod, wyprodukowane);
            }
        }
    }

    private Oferta dostosujOferte(Produkt prod, double wyprodukowane) { //podzieli na jakosc jesli narzedzia/ubrania
        return new Oferta(prod, wyprodukowane); // zle

//        musi usunac zuzyte programy
    }

}
