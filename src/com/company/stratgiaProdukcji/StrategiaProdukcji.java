package com.company.stratgiaProdukcji;

import com.company.produkt.Produkt;

public abstract class StrategiaProdukcji {
    private double[] wektorProd; // mapa

    public abstract double produkujPrzedmioty(Produkt produkt);
}
