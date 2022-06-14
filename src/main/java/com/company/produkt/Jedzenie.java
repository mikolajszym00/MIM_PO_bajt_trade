package com.company.produkt;

import com.company.Para;
import com.company.sciezkaKariery.Rolnik;
import com.company.sciezkaKariery.SciezkaKariery;

import java.util.ArrayList;

public class Jedzenie extends Produkt {
    private final SciezkaKariery sciezka = new Rolnik();

    private int iloscJedzenia;
    private int dniBezJedzenia;
    private final int[] premiaGlodu = {0, -1, -3};

    public ArrayList<Para> ilePosiada() {
        ArrayList<Para> arr = new ArrayList<>();
        arr.add(new Para(-1, iloscJedzenia));

        return arr;
    }

    public boolean czyUmiera() {
        return dniBezJedzenia >= 3;
    }

    public void usunGlod() {
        dniBezJedzenia = 0;
    }

    public void nakarm() {
        if (iloscJedzenia >= 100) {
            dniBezJedzenia = 0;
            iloscJedzenia -= 100;
        } else {
            iloscJedzenia = 0;
            dodajGlod();
        }
    }

    private void dodajGlod() {
        dniBezJedzenia += 1;
    }

    public int dajPremieGlodu() {
        nakarm();

        return premiaGlodu[dniBezJedzenia];
    }
}
