package Datamaskin.Komponenter;

import Datamaskin.Komponent;

import javafx.beans.property.SimpleIntegerProperty;

public class Minne extends Komponent {

    private SimpleIntegerProperty RAM;

    public Minne(String navn, int pris, int RAM){
        super(navn, pris);
        this.RAM= new SimpleIntegerProperty(RAM);
    }
}
