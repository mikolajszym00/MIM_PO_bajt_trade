package com.company.strategiaDnia;

import com.company.Majatek;
import com.company.gielda.Cennik;
import com.company.produkt.Jedzenie;

import java.util.ArrayList;

public class Student extends StrategiaDnia {
    int zapas;
    int okres;

    ArrayList<Double> srednieCeny;


//    public Student(Gielda gielda) {
//        this.gielda = gielda;
//    }

    private double srednia() {
        double suma = 0;

        for(double cena: srednieCeny) {
            suma += cena;
        }

        return suma/srednieCeny.size();
    }

    @Override
    public boolean czyPracuje(Cennik cennik, Majatek majatek, int dzienSymulacji) {
        double nowaCena = cennik.dajCenaWczoraj(new Jedzenie());

        if (srednieCeny.size() >= okres) {
            srednieCeny.remove(0);
        }
        srednieCeny.add(nowaCena);

        return zapas * srednia() > majatek.dajDiamenty().ile();
    }
}
