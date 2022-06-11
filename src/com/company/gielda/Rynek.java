package com.company.gielda;

import com.company.Pozycja;
import com.company.Robotnik;
import com.company.spekulant.Spekulant;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Rynek {

    ArrayList<Pozycja> pozycjeSprzedazySp; // sortowane po jakosci potem cenie??
    ArrayList<Pozycja> pozycjeKupnaSp; // sortowane po jakosci potem cenie??


    public void dodajPozycjeSprzedazy(Spekulant sp, Pozycja pozycja) {
        pozycjeSprzedazySp.add(pozycja); // trzba dodac spekulanta
    }

    public void dodajPozycjeKupna(Spekulant sp, Pozycja pozycja) {
        pozycjeKupnaSp.add(pozycja); // trzba dodac spekulanta
    }

    public void dopasujSprzedaz(Robotnik rb, Pozycja pozycjaRb) {
        for(Pozycja pozycjaSp: pozycjeKupnaSp) {
            Spekulant sp = pozycjaSp.dajSp(); // mozliwe ze pozycja bedzie miala dwa konstruktory jeden z spekulantem

            double maxSpekulantKupi = floor(sp.dajDiamenty()/cennik.cena());
            double maxIloscWymiany = abs(pozycjaSp.ilosc - pozycjaRb.ilosc);

            double iloscWymiany = min(maxSpekulantKupi, maxIloscWymiany);

            rb.przychod(cennik.cena * iloscWymiany); // nalicza na rachunek ktory po gieldzie sie dodaje

            sp.koszt(cennik.cena * iloscWymiany);
            sp.przychodProd(new Pozycja(pozycjaSp.prod, iloscWymiany, pozycjaRb.jakosc, -1));

            pozycjaRb.ilosc -= iloscWymiany;
            pozycjaSp.ilosc -= iloscWymiany;

            if (pozycjaSp.ilosc == 0) {
                pozycjeKupnaSp.remove(pozycjaSp);
            }

            if (pozycjaRb.ilosc == 0) {
                break;
            }
        }
        if (pozycjaRb.ilosc != 0) {
            rb.przychod(cennik.cena * pozycjaRb.ilosc); // pewnie inna cena
        }
    }

    public void dopasujKupno(Robotnik rb, Pozycja pozycjaRb) {
        for(Pozycja pozycjaSp: pozycjeSprzedazySp) {
            Spekulant sp = pozycjaSp.dajSp();

            double maxRobotnikKupi = floor(rb.ileDiamentow()/cennik.cena()); // mozna wywalic do osobnej funkcji
            double maxIloscWymiany = abs(pozycjaSp.ilosc - pozycjaRb.ilosc);

            double iloscWymiany = min(maxRobotnikKupi, maxIloscWymiany);

            rb.koszt(cennik.cena * iloscWymiany); // nalicza na rachunek ktory po gieldzie sie dodaje
            rb.przychodProd(new Pozycja(pozycjaSp.prod, iloscWymiany, pozycjaRb.jakosc, -1));

            sp.przychod(cennik.cena * iloscWymiany);

            pozycjaRb.ilosc -= iloscWymiany;
            pozycjaSp.ilosc -= iloscWymiany;

            if (pozycjaSp.ilosc == 0) {
                pozycjeSprzedazySp.remove(pozycjaSp);
            }

            if (pozycjaRb.ilosc == 0) {
                break;
            }
        }
    }
}
