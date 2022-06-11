package com.company;

public class Para {
    private int pierwsze;
    private double drugie;

    public Para(int pierwsze, double drugie) {
        this.pierwsze = pierwsze;
        this.drugie = drugie;
    }

    public int daj1() {
        return pierwsze;
    }

    public double daj2() {
        return drugie;
    }

    public void odejmij2(double ile) {
        drugie -= ile;
    }
}
