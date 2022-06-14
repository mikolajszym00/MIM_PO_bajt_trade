package com.company.stratgiaProdukcji;

import com.company.Majatek;
import com.company.Oferta;
import com.company.gielda.Cennik;
import com.company.produkt.Jedzenie;
import com.company.produkt.Produkt;

import java.util.ArrayList;
import java.util.Map;

public class Sredniak extends StrategiaProdukcji {
    private int historia_sredniej_produkcji;

    Map<Produkt, ArrayList<Double>> historia;

    private double srednia(ArrayList<Double> arr) {
        double suma = 0;

        for(double cena: arr) {
            suma += cena;
        }

        return suma/arr.size();
    }

    @Override
    public Oferta produkujPrzedmioty(Majatek majatek, Cennik cennik) {
        double sredniaMax = 0;
        Produkt prodMax = majatek.dajJedzenie();

        for(Produkt prod: historia.keySet()) {
            double nowaCena = cennik.dajCenaWczoraj(prod);

            ArrayList<Double> arr = historia.get(prod);
            if (arr.size() >= historia_sredniej_produkcji) {
                arr.remove(0);
            }

            arr.add(nowaCena);

            double nowaSrednia = srednia(arr);

            if (nowaSrednia >= sredniaMax) {
                sredniaMax = nowaSrednia;
                prodMax = prod;
            }
        }

        return dostosujOferte(prodMax, majatek, produkuj(prodMax, majatek));
    }
}
