package Datamaskin.Komponenter;

import Datamaskin.Komponent;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lagring extends Komponent {

    private SimpleIntegerProperty lagringsplass;
    private SimpleStringProperty Type;

    public Lagring(String navn, int pris, int lagringsplass, String Type){
        super(navn,pris);
        this.lagringsplass= new SimpleIntegerProperty(lagringsplass);
        this.Type = new SimpleStringProperty(Type);
    }
}
