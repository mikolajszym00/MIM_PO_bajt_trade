package com.company.stratgiaProdukcji;

import com.company.Cennik;
import com.company.sciezkaKariery.SciezkaKariery;
import com.company.strategiaSciezkiKariery.StrategiaSciezkiKariery;

import java.util.Map;

public abstract class StrategiaProdukcji {
    protected Map<SciezkaKariery, Double> produkcjaBazowa;
    public abstract double produkujPrzedmioty(StrategiaSciezkiKariery kariera, Cennik cennik);

    protected double produkuj(StrategiaSciezkiKariery kariera, SciezkaKariery sciezka) { // powinien byc int
        double baza = produkcjaBazowa.get(sciezka);
        double premiaPoziom = kariera.dajWartoscPoziomu(sciezka) * baza;
//        (karazaglod + narzedzia +
//        double premiaProdukt = kariera.dajProdukt().premia();
        return baza + premiaPoziom;
    }
}
