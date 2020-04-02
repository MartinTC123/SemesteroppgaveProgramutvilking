package Datamaskin.Komponenter;

import Datamaskin.Komponent;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Skjermkort extends Komponent {
    private SimpleStringProperty Teknologi;
    private SimpleIntegerProperty Klokkehastighet;
    public Skjermkort(String navn, int pris, String Teknologi, int Klokkehastighet){
        super(navn, pris);
        this.Teknologi= new SimpleStringProperty(Teknologi);
        this.Klokkehastighet = new SimpleIntegerProperty(Klokkehastighet);
    }
}
