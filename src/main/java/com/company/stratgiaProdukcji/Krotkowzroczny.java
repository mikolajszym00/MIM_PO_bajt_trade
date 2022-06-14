package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Produkt;

public class Krotkowzroczny extends StrategiaProdukcji {

    @Override
    public Oferta produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        Produkt najlepszyProdukt = cennik.ProduktDlaMaxCeny();

        double wyprodukowane = produkuj(najlepszyProdukt, majatek);

        return dostosujOferte(najlepszyProdukt, majatek, wyprodukowane);
    }
}
