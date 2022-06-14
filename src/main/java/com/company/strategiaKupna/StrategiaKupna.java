package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Produkt;

public abstract class StrategiaKupna {
    public abstract Oferta coKupuje(Majatek majatek);
}
