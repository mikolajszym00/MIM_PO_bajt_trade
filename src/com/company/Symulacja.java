package com.company;

import com.company.gielda.Gielda;
import com.company.produkt.Produkt;

public class Symulacja {
    Robotnik[] robotnicy; // <- trzeba użyć kolekcji
    Spekulant[] spekulanci; // <- trzeba użyć kolekcji
    Gielda gielda;

    private void decyzjeRobotnikow() {
        for (Robotnik rb: robotnicy) {
            if (rb.czyUmiera()) {
//                wywal go z listy
            } else {
                if (rb.czyPracuje()) {
                    Para<Produkt, Double> wyprodukowane = rb.produkujPrzedmioty(gielda);
                    rb.wystawSprzedaz(gielda, wyprodukowane);
                    rb.wystawKupno(gielda);
                } else {
                    rb.uczSie();
                }
            }
        }
    }

    private void decyzjeSpekulantow() {
        for (Spekulant sp: spekulanci) {
            sp.wystawSprzedaz(gielda);
            sp.wystawKupno(gielda);
        }
    }

    private void dopasujOferty() {
        gielda.dopasujOferty();
    }

    private void ZuzywaniePrzedmiotow() {
        for (Robotnik rb: robotnicy) {
            if (rb.czyPracuje()) {
                rb.zuzyjPrzemioty();
            }
        }
    }
}
