package com.company.strategiaSciezkiKariery;

import com.company.Majatek;
import com.company.sciezkaKariery.SciezkaKariery;

public abstract class StrategiaSciezkiKariery {
    protected SciezkaKariery aktualnaSciezka;

    protected StrategiaSciezkiKariery(SciezkaKariery sciezka) {
        this.aktualnaSciezka = sciezka;
    }

    public abstract SciezkaKariery wybierzSciezke();

    public abstract void ustawSciezke(SciezkaKariery sciezka);

    public void uczSie(Majatek majatek) {
        SciezkaKariery sciezka = wybierzSciezke();

        if (this.aktualnaSciezka == sciezka) {
            // trzeba dodać jeden postepu
            majatek.dajJedzenie().usunGlod(); // moze daj gdzies indziej zbiorowo
        } else {
            ustawSciezke(sciezka);
            majatek.dajJedzenie().nakarm(); //  chyba zle
        }
    }

}
