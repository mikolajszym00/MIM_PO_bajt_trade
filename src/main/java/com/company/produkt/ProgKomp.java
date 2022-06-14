package com.company.produkt;

import com.company.Para;
import com.company.sciezkaKariery.Programista;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;
import java.util.Comparator;

public class ProgKomp extends Produkt {
    private final SciezkaKariery sciezka = new Programista();

    private ArrayList<Para> posiadaneProgramy;

    public ArrayList<Para> ilePosiada() {
        return posiadaneProgramy;
    }

    public void posortuj() {
        posiadaneProgramy.sort(Comparator.comparingInt(Para::daj1));
    }

    public void usun(Para doUsuniecia) {
        posiadaneProgramy.remove(doUsuniecia);
    }
}
