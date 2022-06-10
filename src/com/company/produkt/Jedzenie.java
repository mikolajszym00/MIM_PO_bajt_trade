package com.company.produkt;

public class Jedzenie extends Produkt {
    private int iloscJedzenia;
    private int dniBezJedzenia;
    private final int[] premiaGlodu = {0, -1, -3};

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
//            co jesli pozmiedzy 0 100
        }
    }

    public void dodajGlod() {
        dniBezJedzenia += 1;
    }

    public int dajPremieGlodu() {
        return premiaGlodu[dniBezJedzenia];
    }
}
