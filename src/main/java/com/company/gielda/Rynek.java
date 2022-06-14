package com.company.gielda;

import com.company.Pozycja;
import com.company.Robotnik;
import com.company.spekulant.Spekulant;

import java.util.ArrayList;

import static java.lang.Math.*;

public class Rynek {
    Cennik cennik;

    ArrayList<Pozycja> pozycjeSprzedazySp; // sortowane po jakosci potem cenie??
    ArrayList<Pozycja> pozycjeKupnaSp; // sortowane po jakosci potem cenie??

    public Rynek(Cennik cennik) {
        this.cennik = cennik;
    }

    public void dodajPozycjeSprzedazy(Spekulant sp, Pozycja pozycja) {
        pozycjeSprzedazySp.add(pozycja);
    }

    public void dodajPozycjeKupna(Spekulant sp, Pozycja pozycja) {
        pozycjeKupnaSp.add(pozycja);
    }

    public void dopasujSprzedaz(Robotnik rb, Pozycja pozycjaRb) {
        for(Pozycja pozycjaSp: pozycjeKupnaSp) {
            Spekulant sp = pozycjaSp.sp;

            double maxSpekulantKupi = floor(sp.ileDiamentow()/pozycjaSp.cena);
            double maxIloscWymiany = abs(pozycjaSp.ilosc - pozycjaRb.ilosc);

            double iloscWymiany = min(maxSpekulantKupi, maxIloscWymiany);

            rb.przychod(pozycjaSp.cena * iloscWymiany);

            sp.koszt(pozycjaSp.cena * iloscWymiany);
            sp.przychodProd(new Pozycja(null, pozycjaSp.prod, iloscWymiany, pozycjaRb.jakosc, -1));

            pozycjaRb.ilosc -= iloscWymiany;
            pozycjaSp.ilosc -= iloscWymiany;

            cennik.dodajDoSredniej(pozycjaSp.prod, pozycjaSp.cena, pozycjaSp.ilosc);

            if (pozycjaSp.ilosc == 0) {
                pozycjeKupnaSp.remove(pozycjaSp);
            }

            if (pozycjaRb.ilosc == 0) {
                break;
            }
        }
        if (pozycjaRb.ilosc != 0) {
            rb.przychod(cennik.dajCenaWczoraj(pozycjaRb.prod) * pozycjaRb.ilosc);
        }
    }

    public void dopasujKupno(Robotnik rb, Pozycja pozycjaRb) {
        for(Pozycja pozycjaSp: pozycjeSprzedazySp) {
            Spekulant sp = pozycjaSp.sp;

            double maxRobotnikKupi = floor(rb.ileDiamentow()/pozycjaSp.cena); // mozna wywalic do osobnej funkcji
            double maxIloscWymiany = abs(pozycjaSp.ilosc - pozycjaRb.ilosc);

            double iloscWymiany = min(maxRobotnikKupi, maxIloscWymiany);

            rb.koszt(pozycjaSp.cena * iloscWymiany);
            rb.przychodProd(new Pozycja(null, pozycjaSp.prod, iloscWymiany, pozycjaRb.jakosc, -1));

            sp.przychod(pozycjaSp.cena * iloscWymiany);

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
