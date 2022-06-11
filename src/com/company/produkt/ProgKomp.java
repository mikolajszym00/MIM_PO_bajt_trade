package com.company.produkt;

import com.company.Para;

import java.util.ArrayList;
import java.util.Comparator;

public class ProgKomp extends Produkt {
    // tablica gdzie indeks to poziom programu a wartosc to ilosc takich

    private ArrayList<Para> posiadaneProgramy;

    public ArrayList<Para> dajposiadaneProgramy() {
        return posiadaneProgramy;
    }

    public void posortuj() {
        posiadaneProgramy.sort(Comparator.comparingInt(Para::daj1));
    }

    public void usun(Para doUsuniecia) {
        posiadaneProgramy.remove(doUsuniecia);
    }
}
