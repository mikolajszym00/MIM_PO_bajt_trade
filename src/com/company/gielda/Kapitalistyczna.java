package com.company.gielda;

import com.company.Robotnik;

import java.util.Comparator;

public class Kapitalistyczna extends Gielda {

    protected void sortuj() {
        listaRobotnikow.sort(Comparator.comparingDouble(Robotnik::ileDiamentow).reversed());
    }

}
