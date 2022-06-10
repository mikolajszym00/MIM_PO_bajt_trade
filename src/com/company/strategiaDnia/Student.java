package com.company.strategiaDnia;

import com.company.gielda.Cennik;

public class Student extends StrategiaDnia {
    int zapas;
    int okres;

    int[] srednieCeny; //stos wielkosci okres


//    public Student(Gielda gielda) {
//        this.gielda = gielda;
//    }

    @Override
    public boolean czyPracuje(Cennik cennik) {
        int[] noweCeny = cennik; // zle

        srednieCeny.usunNajstrasze();
        srednieCeny.dodaj(srednia(noweCeny));

        return zapas * srednia(srednieCeny) > majatek; // co to majatek
    }
}
