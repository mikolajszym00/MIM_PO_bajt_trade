package com.company.strategiaDnia;

import com.company.Majatek;
import com.company.gielda.Cennik;

public class Oszczedny extends StrategiaDnia{
    double limitDiamentow;

    public Oszczedny(double limitDiamentow) {
        this.limitDiamentow = limitDiamentow;
    }

    @Override
    public boolean czyPracuje(Cennik cennik, Majatek majatek, int dzienSymulacji) {
        return !(majatek.dajDiamenty().ile() > limitDiamentow);
    }
}
