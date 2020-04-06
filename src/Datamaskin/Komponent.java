package Datamaskin;

import javafx.beans.property.SimpleStringProperty;

public class Komponent {

    private SimpleStringProperty navn;

    private SimpleStringProperty komponent;

    private SimpleStringProperty pris;

    public Komponent(String navn, String komponent, String pris){
        this.navn = new SimpleStringProperty(navn);
        this.pris= new SimpleStringProperty(pris);
        this.komponent= new SimpleStringProperty(komponent);
    }

    public String getNavn() {
        return navn.getValue();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getPris(){
        return pris.getValue();
    }

    public void setPris(String pris){
        this.pris.set(pris);
    }

    public String getKomponent(){
        return komponent.getValue();
    }

    public void setKomponent(String komponent){
        this.komponent.set(komponent);
    }
}

