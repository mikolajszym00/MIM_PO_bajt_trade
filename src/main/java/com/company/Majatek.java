package com.company;

import com.company.produkt.*;

public class Majatek {
    private final Produkt[] produkty;

    public Majatek(Jedzenie jed, Ubrania ubr, Narzedzia nar, Diamenty dia, ProgKomp pro) {
        produkty = new Produkt[]{jed, ubr, nar, dia, pro};
    }

    public Produkt[] dajProdukty() {
        return produkty;
    }

    public Jedzenie dajJedzenie() { return (Jedzenie) produkty[0]; }

    public Ubrania dajUbrania() {
        return (Ubrania) produkty[1];
    }

    public Narzedzia dajNarzedzia() {
        return (Narzedzia) produkty[2];
    }

    public Diamenty dajDiamenty() { return (Diamenty) produkty[3]; }

    public ProgKomp dajProgKomp() { return (ProgKomp) produkty[4]; }

    public boolean czyJedzenie(Produkt prod) { return prod == (Jedzenie) produkty[0]; }

    public boolean czyDiamenty(Produkt prod) { return prod == (Diamenty) produkty[3]; }

    public boolean czyProgKomp(Produkt prod) { return prod == (ProgKomp) produkty[4]; }
}
