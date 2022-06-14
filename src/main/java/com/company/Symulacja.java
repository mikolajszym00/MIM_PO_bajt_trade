package com.company;

import com.company.gielda.Gielda;
import com.company.gielda.Kapitalistyczna;
import com.company.spekulant.Spekulant;

import java.util.ArrayList;
import java.util.Map;

public class Symulacja {
    private int dlugosc;
    private String typGieldy;
    private Map<String, Double> ceny;

    private ArrayList<Robotnik> robotnicy;
    private ArrayList<Spekulant> spekulanci;

    Gielda gielda = stworzGielde(typGieldy, ceny);

    public Gielda stworzGielde(String typ, Map<String, Double> ceny) {
        Gielda gielda = null;

        switch (typ) {
            case "socjalistyczna":
                gielda =  new Kapitalistyczna(); //źle
            case "kapitalistyczna":
                gielda =  new Kapitalistyczna();
            default:
                break;
        }
        return gielda;
    }

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

    private void otworzGielde() {
        gielda.dopasujOferty();
        gielda.zakonczDzien();
    }

//    private void ZuzywaniePrzedmiotow() { // najprwdopodobniej nie potrzebne
//        for (Robotnik rb: robotnicy) {
//            if (rb.czyPracuje()) {
//                rb.zuzyjPrzemioty();
//            }
//        }
//    }

}
