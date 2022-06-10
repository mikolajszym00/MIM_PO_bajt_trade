package com.company.stratgiaProdukcji;

import com.company.gielda.Cennik;
import com.company.Majatek;
import com.company.Para;
import com.company.produkt.Produkt;

public class Chciwy extends StrategiaProdukcji {

    public Para<Produkt, Double> produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        double maxZysk = 0;
        double maxZyskWyprodukowane = 0;
        Produkt maxZyskProd = majatek.dajJedzenie();

        for (Produkt prod: majatek.dajProdukty()) {
            double wyprodukowane = produkuj(majatek, prod);
            double zysk = cennik.cenaDlaProduktu(prod) * wyprodukowane;

            if (zysk >= maxZysk) {
                maxZysk = zysk;
                maxZyskWyprodukowane = wyprodukowane;
                maxZyskProd = prod;
            }
        }

//        majatek.dajProgKomp().usunProgramy()
        return new Para<>(maxZyskProd, maxZyskWyprodukowane);
    }

}
