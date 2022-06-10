package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Oferta;
import com.company.produkt.Produkt;

public class Chciwy extends StrategiaProdukcji {

    @Override
    public Oferta produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        double maxZysk = 0;
        double maxZyskWyprodukowane = 0;
        Produkt maxZyskProd = majatek.dajJedzenie();

        for (Produkt prod: majatek.dajProdukty()) {
            double wyprodukowane = produkuj(prod, majatek);
            double zysk = cennik.cenaDlaProduktu(prod) * wyprodukowane;

            if (zysk >= maxZysk) {
                maxZysk = zysk;
                maxZyskWyprodukowane = wyprodukowane;
                maxZyskProd = prod;
            }
        }

        return stworzOferte(maxZyskProd, maxZyskWyprodukowane);
    }

}
