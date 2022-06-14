package com.company;

import com.company.produkt.Diamenty;

public abstract class Agent {
    private int id;

    protected Majatek majatek;

    public double ileDiamentow() {
        return majatek.dajDiamenty().ile();
    }

    public void przychod(double wartosc) {
        Diamenty diamenty = majatek.dajDiamenty();
        diamenty.dodaj(wartosc);
    }

    public void koszt(double wartosc) {
        Diamenty diamenty = majatek.dajDiamenty();
        diamenty.odejmij(wartosc);
    }

    public void przychodProd(Pozycja pozycja) {
        // programy, narzedzia, ubrania odejmuje podczas produkcji
        // jedzenie podczas decyzji czy sie uczy

    }
}
