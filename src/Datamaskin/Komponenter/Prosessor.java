package Datamaskin.Komponenter;

import Datamaskin.Komponent;
import javafx.beans.property.SimpleIntegerProperty;

public class Prosessor extends Komponent {
    private SimpleIntegerProperty AntKjerner;
    private SimpleIntegerProperty KlokkeHastighet;
    public Prosessor(String navn, int pris, int AntKjerner, int KlokkeHastighet){
        super(navn, pris);
        this.AntKjerner = new SimpleIntegerProperty(AntKjerner);
        this.KlokkeHastighet = new SimpleIntegerProperty(KlokkeHastighet);
    }

    public int getAntKjerner() {
        return AntKjerner.getValue();
    }

    public void setAntKjerner(int antKjerner) {
        this.AntKjerner.set(antKjerner);
    }
}
