package Datamaskin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Komponent implements Serializable {

    private transient SimpleStringProperty navn;

    private transient SimpleStringProperty komponent;

    private transient SimpleIntegerProperty pris;

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

    private void writeObject (ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(navn.getValue());
        s.writeUTF(komponent.getValue());
        s.writeInt(pris.getValue());
    }

    private void readObject (ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        String navn= s.readUTF();
        String komponent = s.readUTF();
        int pris = s.readInt();

        this.navn= new SimpleStringProperty(navn);
        this.komponent = new SimpleStringProperty(komponent);
        this.pris = new SimpleIntegerProperty(pris);

    }
}

