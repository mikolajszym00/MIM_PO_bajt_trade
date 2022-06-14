package com.company.gielda;

import com.company.Robotnik;

import java.util.Comparator;

public class Socjalistyczna extends Gielda {

    public Socjalistyczna() {

    }

    protected void sortuj() {
        listaRobotnikow.sort(Comparator.comparingDouble(Robotnik::ileDiamentow));
    }
}
