package com.company.strategiaDnia;

import com.company.Majatek;

public class Oszczedny extends StrategiaDnia{
    double limitDiamentow;

    public Oszczedny(double limitDiamentow) {
        this.limitDiamentow = limitDiamentow;
    }

    @Override
    public boolean czyPracuje(Majatek kariera) {
        if (kariera.dajDiamenty().ile() > limitDiamentow) {
            return false;
        }

        return true;
    }


}
