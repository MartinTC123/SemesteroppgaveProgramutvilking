package Datamaskin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Komponent {

    private SimpleStringProperty navn;

    private SimpleIntegerProperty pris;

    public Komponent(String navn, int pris){
        this.navn = new SimpleStringProperty(navn);
        this.pris= new SimpleIntegerProperty (pris);
    }

    public String getNavn() {
        return navn.getValue();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }
}

