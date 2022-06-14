package com.company.stratgiaProdukcji;

import com.company.Majatek;
import com.company.Oferta;
import com.company.gielda.Cennik;
import com.company.produkt.Produkt;

import java.util.Random;

public class Losowy extends StrategiaProdukcji {

    @Override
    public Oferta produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        Produkt[] produkty = majatek.dajProdukty();

        int rnd = new Random().nextInt(produkty.length);

        return dostosujOferte(produkty[rnd], majatek, produkuj(produkty[rnd], majatek));
    }
}
