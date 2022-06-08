package com.company.stratgiaProdukcji;

import com.company.Cennik;
import com.company.sciezkaKariery.SciezkaKariery;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;

public class Chciwy extends StrategiaProdukcji {

    public double produkujPrzedmioty(StrategiaSciezkiKariery kariera, Cennik cennik) {
        double maxZysk = 0;
        double maxZyskWyprodukowane = 0;
        for (SciezkaKariery sciezka: cennik.dajSciezki()) {
            double wyprodukowane = produkuj(kariera, sciezka);
            double zysk = cennik.cenaDlaSciezki(sciezka) * wyprodukowane;

            if (zysk > maxZysk) {
                maxZysk = zysk;
                maxZyskWyprodukowane = wyprodukowane;
            }
        }

        return maxZyskWyprodukowane;
    }

}
