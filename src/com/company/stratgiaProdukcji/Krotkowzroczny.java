package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Para;
import com.company.produkt.Produkt;

public class Krotkowzroczny extends StrategiaProdukcji {

    @Override
    public Para<Produkt, Double> produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        Produkt najlepszyProdukt = cennik.ProduktDlaMaxCeny();

        return new Para<>(najlepszyProdukt, produkuj(majatek, najlepszyProdukt));
    }
}
