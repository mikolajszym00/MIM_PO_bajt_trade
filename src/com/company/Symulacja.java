package com.company;

import com.company.gielda.Gielda;
import com.company.produkt.Produkt;

import java.util.ArrayList;

public class Symulacja {
    ArrayList<Robotnik> robotnicy;
    ArrayList<Spekulant> spekulanci;
    Gielda gielda;

    private void decyzjeRobotnikow() {
        for (Robotnik rb: robotnicy) {
            if (rb.czyUmiera()) {
                robotnicy.remove(rb);
            } else {
                if (rb.czyPracuje()) {
                    Oferta wyprodukowane = rb.produkujPrzedmioty(gielda);
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
