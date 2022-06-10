package com.company.gielda;

import com.company.Oferta;
import com.company.Pozycja;
import com.company.Robotnik;
import com.company.produkt.Produkt;
import com.company.spekulant.Spekulant;

import java.util.ArrayList;
import java.util.Map;

public abstract class Gielda {
    private Cennik cennik;

    protected ArrayList<Robotnik> listaRobotnikow;
    private Map<Robotnik, Oferta> ofertySprzedazy;
    private Map<Robotnik, Oferta> ofertyKupna;

    private Map<Produkt, Rynek> rynkiProduktow;

    protected abstract void sortuj();

    public Cennik dajCennik() {
        return cennik;
    }

    public void dodajDoSprzedazy(Robotnik rb, Oferta oferta) {
        ofertySprzedazy.put(rb, oferta);
    }

    public void dodajDoKupna(Robotnik rb, Oferta oferta) {
        ofertyKupna.put(rb, oferta);
    }

    public void dodajdoSprzedazySpekulant(Spekulant sp, Oferta oferta) {
        for (Pozycja pozycja: oferta.dajListePozycji()) {
            Rynek rynek = rynkiProduktow.get(pozycja.dajProdukt());
            rynek.dodajOferteSprzedazy(sp, pozycja);
        }
    }

    public void dodajDoKupnaSpekulant(Spekulant sp, Oferta oferta) {
        for (Pozycja pozycja: oferta.dajListePozycji()) {
            Rynek rynek = rynkiProduktow.get(pozycja.dajProdukt());
            rynek.dodajOferteKupna(sp, pozycja);
        }
    }

    private void dopasujSprzedaz(Robotnik rb, Oferta oferta) {
        Pozycja pozycja = oferta.dajPierwszaPozycje();
        Rynek rynek = rynkiProduktow.get(pozycja.dajProdukt());
        rynek.dopasujSprzedaz(rb, pozycja);
    }

    private void dopasujKupno(Robotnik rb, Oferta oferta) {
        for (Pozycja pozycja: oferta.dajListePozycji()) {
            Rynek rynek = rynkiProduktow.get(pozycja.dajProdukt());
            rynek.dopasujKupno(rb, pozycja);
        }
    }

    public void dopasujOferty() {
        sortuj();

        for (Robotnik rb: listaRobotnikow) {
            dopasujSprzedaz(rb, ofertySprzedazy.get(rb));
            dopasujKupno(rb, ofertyKupna.get(rb));
        }
    }

}
