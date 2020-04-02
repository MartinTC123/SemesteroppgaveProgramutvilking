package Datamaskin.Komponenter;

import Datamaskin.Komponent;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Hovedkort extends Komponent {
    private SimpleStringProperty Type;
    public Hovedkort(String navn, int pris, String Type){
        super(navn, pris);
        this.Type = new SimpleStringProperty(Type);
    }

    public String getType() {
        return Type.getValue();
    }

    public void setType(String type) {
        this.Type.set(type);
    }
}
