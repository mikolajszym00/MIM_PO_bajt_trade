package com.company;

import com.company.gielda.Gielda;
import com.company.produkt.Produkt;
import com.company.strategiaDnia.StrategiaDnia;
import com.company.strategiaKupna.StrategiaKupna;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;
import com.company.stratgiaProdukcji.StrategiaProdukcji;

public class Robotnik extends Agent {
    StrategiaDnia stDnia;
    StrategiaSciezkiKariery stSciezkiKariery;
    StrategiaProdukcji stProdukcji;
    StrategiaKupna stKupna;

    public Robotnik(StrategiaDnia stDnia,
                    StrategiaSciezkiKariery stSciezkiKariery,
                    Majatek majatek,
                    StrategiaProdukcji stProdukcji) {

        this.stDnia = stDnia;
        this.stSciezkiKariery = stSciezkiKariery;
        this.majatek = majatek;
        this.stProdukcji = stProdukcji;
    }

    public boolean czyUmiera() { return majatek.dajJedzenie().czyUmiera(); }

    public boolean czyPracuje(Gielda gielda, int dzienSymulacji) {
        return stDnia.czyPracuje(gielda.dajCennik(), majatek, dzienSymulacji);
    }

    public Oferta produkujPrzedmioty(Gielda gielda) {
        return stProdukcji.produkujPrzedmioty(majatek, gielda.dajCennik());
    }

    public void wystawSprzedaz(Gielda gielda, Oferta doSprzedazy) {
        if (!doSprzedazy.czyDiamenty(majatek)) {
            gielda.dodajDoSprzedazy(this, doSprzedazy);
        } else {
            przychod(doSprzedazy.dajListePozycji().get(0).ilosc); // diamenty
        }
    }

    public void wystawKupno(Gielda gielda) {
        Oferta doKupna = stKupna.coKupuje(majatek);

        gielda.dodajDoKupna(this, doKupna);
    }

    public void uczSie() { stSciezkiKariery.uczSie(majatek); }
}
