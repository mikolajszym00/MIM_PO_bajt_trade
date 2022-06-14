package com.company.strategiaDnia;

import com.company.Majatek;
import com.company.gielda.Cennik;

public class Okresowy extends StrategiaDnia {
    private int okresowosc_nauki;

    @Override
    public boolean czyPracuje(Cennik cennik, Majatek majatek, int dzienSymulacji) {
        return dzienSymulacji % okresowosc_nauki != 0;
    }

}
