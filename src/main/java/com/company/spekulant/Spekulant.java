package com.company.spekulant;

import com.company.Agent;
import com.company.gielda.Gielda;

public abstract class Spekulant extends Agent {

    public abstract void wystawSprzedaz(Gielda gielda);

    public abstract void wystawKupno(Gielda gielda);
}