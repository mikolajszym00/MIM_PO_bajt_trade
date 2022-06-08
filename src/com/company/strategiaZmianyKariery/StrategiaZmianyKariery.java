package com.company.strategiaZmianyKariery;

import com.company.sciezkaKariery.SciezkaKariery;

public abstract class StrategiaZmianyKariery {
    protected SciezkaKariery sciezka;

    protected StrategiaZmianyKariery(SciezkaKariery sciezka) {
        this.sciezka = sciezka;
    }

    public SciezkaKariery dajSciezke() {
        return sciezka;
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
