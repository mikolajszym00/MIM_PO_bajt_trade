package com.company.strategiaDnia;

import com.company.Majatek;
import com.company.gielda.Cennik;

public class Pracus extends StrategiaDnia {

    @Override
    public boolean czyPracuje(Cennik cennik, Majatek majatek, int dzienSymulacji) {
        return true;
    }
}
