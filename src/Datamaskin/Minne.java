package Datamaskin;

public class Minne extends Komponent {

    private int RAM;

    public Minne(String navn, int pris, int RAM){
        super(navn, pris);
        this.RAM= RAM;
    }
}