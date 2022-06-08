package com.company.stratgiaProdukcji;

import com.company.Cennik;
import com.company.sciezkaKariery.SciezkaKariery;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;

public class Krotkowzroczny extends StrategiaProdukcji {

    @Override
    public double produkujPrzedmioty(StrategiaSciezkiKariery kariera, Cennik cennik) {
        SciezkaKariery najlepszaSciezka = cennik.SciezkaDlaMaxCeny();

        return produkuj(kariera, najlepszaSciezka);
    }
}
