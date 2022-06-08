package com.company.strategiaDnia;

import com.company.Gielda;

public class Student extends StrategiaDnia {
    int zapas;
    int okres;

    int[] srednieCeny; //stos wielkosci okres

    Gielda gielda;

    public Student(Gielda gielda) {
        this.gielda = gielda;
    }

    @Override
    public boolean czyPracuje() {
        int[] noweCeny = gielda.dajCeny();

        srednieCeny.usunNajstrasze();
        srednieCeny.dodaj(srednia(noweCeny));

        return zapas * srednia(srednieCeny) > majatek; // co to majatek
    }
}
