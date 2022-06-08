package com.company;

import com.company.produkt.Produkt;
import com.company.sciezkaKariery.SciezkaKariery;
import com.company.strategiaDnia.StrategiaDnia;
import com.company.strategiaZmianyKariery.StrategiaZmianyKariery;
import com.company.stratgiaProdukcji.StrategiaProdukcji;

public class Robotnik extends Agent {
    int iloscProd;
    int[] wektorProd; // ile jednostek tego produktu jest w stanie wyprodukować w jednej turze

    StrategiaDnia stDnia;
    StrategiaZmianyKariery stZmianyKariery;
    StrategiaProdukcji stProdukcji;

    public Robotnik(int iloscProd) {
        this.iloscProd = iloscProd;
    }

    public boolean czyPracuje() {
        return stDnia.czyPracuje();
    }

    public double produkujPrzedmioty() {
        Produkt produkt = stZmianyKariery.dajSciezke().dajProdukt();
        return stProdukcji.produkujPrzedmioty(produkt);
    }

    public void wystawSprzedaz(Gielda gielda, double wyprodukowane) {
        gielda.dodajDoSprzedazy(this, stZmianyKariery.dajSciezke().dajProdukt(), wyprodukowane);
    }

    public void wystawKupno(Gielda gielda) {

    }

    public void uczSie() { stZmianyKariery.uczSie(); }
}
