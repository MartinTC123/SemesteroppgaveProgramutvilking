package Datamaskin.Komponenter;

import Datamaskin.Komponent;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

public class Skjerm extends Komponent {
    private SimpleIntegerProperty Hz;
    private SimpleIntegerProperty Tommer;
    public Skjerm(String navn, int pris, int Hz, int Tommer){
        super(navn, pris);
        this.Hz = new SimpleIntegerProperty(Hz);
        this.Tommer = new SimpleIntegerProperty (Tommer);
    }

    public int getHz() {
        return Hz.getValue();
    }

    public void setHz(int hz) {
        this.Hz.set(hz);
    }
}
