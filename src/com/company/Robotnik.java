package com.company;

import com.company.gielda.Gielda;
import com.company.produkt.Produkt;
import com.company.strategiaDnia.StrategiaDnia;
import com.company.strategiaKupna.StrategiaKupna;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;
import com.company.stratgiaProdukcji.StrategiaProdukcji;

public class Robotnik extends Agent {
    int iloscProd;

    Majatek majatek;

    StrategiaDnia stDnia;
    StrategiaSciezkiKariery stSciezkiKariery;
    StrategiaProdukcji stProdukcji;
    StrategiaKupna stKupna;

    public Robotnik(int iloscProd,
                    StrategiaDnia stDnia,
                    StrategiaSciezkiKariery stSciezkiKariery,
                    Majatek majatek,
                    StrategiaProdukcji stProdukcji) {
        this.iloscProd = iloscProd;

        this.stDnia = stDnia;
        this.majatek = majatek;
        this.stProdukcji = stProdukcji;
    }

    public boolean czyUmiera() { return majatek.dajJedzenie().czyUmiera(); }

    public boolean czyPracuje() {
        return stDnia.czyPracuje();
    }

    public  Para<Produkt, Double> produkujPrzedmioty(Gielda gielda) {
        return stProdukcji.produkujPrzedmioty(majatek, gielda.dajCennik());
    }

    public void wystawSprzedaz(Gielda gielda,  Para<Produkt, Double> doSprzedazy) {
        gielda.dodajDoSprzedazy(this, doSprzedazy);
    }

    public void wystawKupno(Gielda gielda) {
        Para<Produkt, Double> doKupna = stKupna.coKupuje(majatek);

        gielda.dodajDoKupna(this, doKupna);
    }

    public void uczSie() { stSciezkiKariery.uczSie(majatek); }
}
