package com.company;

import com.company.strategiaDnia.StrategiaDnia;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;
import com.company.stratgiaProdukcji.StrategiaProdukcji;

public class Robotnik extends Agent {
    int iloscProd;

    StrategiaDnia stDnia;
    StrategiaSciezkiKariery kariera;
    StrategiaProdukcji stProdukcji;

    public Robotnik(int iloscProd,
                    StrategiaDnia stDnia,
                    StrategiaSciezkiKariery kariera,
                    StrategiaProdukcji stProdukcji) {
        this.iloscProd = iloscProd;

        this.stDnia = stDnia;
        this.kariera = kariera;
        this.stProdukcji = stProdukcji;
    }

    public boolean czyPracuje() {
        return stDnia.czyPracuje();
    }

    public double produkujPrzedmioty(Gielda gielda) {
        return stProdukcji.produkujPrzedmioty(kariera, gielda.dajCennik());
    }

    public void wystawSprzedaz(Gielda gielda, double wyprodukowane) {
        gielda.dodajDoSprzedazy(this, kariera.dajSciezke().dajProdukt(), wyprodukowane); // jeszcze chyba jakość będzie
    }

    public void wystawKupno(Gielda gielda) {

    }

    public void uczSie() { kariera.uczSie(); }
}
