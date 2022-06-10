package com.company.strategiaKupna;

import com.company.Majatek;
import com.company.Para;
import com.company.produkt.Produkt;

public abstract class StrategiaKupna {

    public abstract Para<Produkt, Double> coKupuje(Majatek majatek);
}
