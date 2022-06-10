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

    public double ileDiamentow() {
        return majatek.dajDiamenty().ile();
    }

    public boolean czyUmiera() { return majatek.dajJedzenie().czyUmiera(); }

    public boolean czyPracuje() {
        return stDnia.czyPracuje();
    }

    public Oferta produkujPrzedmioty(Gielda gielda) { // co jesli diamenty + rozny poziom zaawansowania
        return stProdukcji.produkujPrzedmioty(majatek, gielda.dajCennik());
    }

    public void wystawSprzedaz(Gielda gielda,  Oferta doSprzedazy) {
        if (Oferta.czyDopuszczony()) {
            gielda.dodajDoSprzedazy(this, doSprzedazy);
        } else {
            // oferta to diamenty, trzeba dodac do zasobow lub dopiero po rundzie !!!
        }
    }

    public void wystawKupno(Gielda gielda) {
        Oferta doKupna = stKupna.coKupuje(majatek);

        gielda.dodajDoKupna(this, doKupna);
    }

    public void uczSie() { stSciezkiKariery.uczSie(majatek); }
}
