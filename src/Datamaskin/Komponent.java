package Datamaskin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Komponent {

    private SimpleStringProperty navn;

    private SimpleStringProperty komponent;

    private SimpleIntegerProperty pris;

    public Komponent(String navn, String komponent, int pris){
        this.navn = new SimpleStringProperty(navn);
        this.pris= new SimpleIntegerProperty(pris);
        this.komponent= new SimpleStringProperty(komponent);
    }

    public String getNavn() {
        return navn.getValue();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public int getPris(){
        return pris.getValue();
    }

    public void setPris(int pris){
        this.pris.set(pris);
    }

    public String getKomponent(){
        return komponent.getValue();
    }

    public void setKomponent(String komponent){
        this.komponent.set(komponent);
    }

    private void skrivObjekt(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(navn.getValue());
        s.writeUTF(komponent.getValue());
        s.writeUTF(String.valueOf(pris.getValue()));
    }
}

