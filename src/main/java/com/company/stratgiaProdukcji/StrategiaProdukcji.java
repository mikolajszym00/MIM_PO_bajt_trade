package com.company.stratgiaProdukcji;

import com.company.Para;
import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Produkt;
import com.company.produkt.ProgKomp;

import java.util.Map;

import static java.lang.Math.abs;

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

    protected Oferta dostosujOferte(Produkt prod, Majatek majatek, double wyprodukowane) {
        if (majatek.czyDiamenty(prod) || majatek.czyJedzenie(prod)) {
            Oferta oferta = new Oferta();
            oferta.dodaj(prod, wyprodukowane);

            return oferta;
        } else {
            if (majatek.czyProgKomp(prod)) {
                int poziom = prod.dajPoziom(); // tylko jesli to sciezka programisty inaczej 1

                Oferta oferta = new Oferta();
                oferta.dodaj(prod, wyprodukowane, poziom);

                return oferta;
            } else { // narzedzia ubrania
                return stworzOferte(prod, majatek, wyprodukowane);
            }
        }
    }

    private Oferta stworzOferte(Produkt prod, Majatek majatek, double wyprodukowane) { //podzieli na jakosc jesli narzedzia/ubrania
        ProgKomp progKomp = majatek.dajProgKomp();
        progKomp.posortuj(); // powinny byc posortowane malejaco

        Oferta oferta = new Oferta();

        for(Para jakoscIlosc: progKomp.ilePosiada()) {
            double ilosc = abs(jakoscIlosc.daj2() - wyprodukowane);

            wyprodukowane -= ilosc;
            jakoscIlosc.odejmij2(ilosc);

            oferta.dodaj(prod, ilosc, jakoscIlosc.daj1());

            if (wyprodukowane == 0) {
                break;
            }

            if (jakoscIlosc.daj2() == 0) {
                progKomp.usun(jakoscIlosc);
            }
        }

        return oferta;
    }
}
