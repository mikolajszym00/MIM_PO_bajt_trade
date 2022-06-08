package com.company.strategiaSciezkiKariery;

import com.company.produkt.Produkt;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.Map;

public abstract class StrategiaSciezkiKariery {
    protected SciezkaKariery sciezka;

    private Map<SciezkaKariery, Integer> poziomSciezek;
    private final double[] wartoscPoziomu = {0.5, 1.5, 3};

    protected StrategiaSciezkiKariery(SciezkaKariery sciezka) {
        this.sciezka = sciezka;
    }

    public SciezkaKariery dajSciezke() {
        return sciezka;
    }

    public double dajWartoscPoziomu(SciezkaKariery sciezka) {
        int poziom = poziomSciezek.get(sciezka);

        if (poziom >= 4) { return  3 + poziom * 0.25; }
        return wartoscPoziomu[poziom-1];
    }

    public Produkt dajProdukt() {
        return sciezka.dajProdukt();
    }

    public abstract SciezkaKariery wybierzSciezke();

    public abstract void ustawSciezke(SciezkaKariery sciezka);

    public void uczSie() {
        SciezkaKariery sciezka = wybierzSciezke();

        if (this.sciezka == sciezka) {
            // trzeba dodać jeden postepu
        } else {
            ustawSciezke(sciezka);
        }
    }

}
