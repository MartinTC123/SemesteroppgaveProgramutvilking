package Datamaskin;

public class Harddisk extends Komponent {

    private int lagringsplass;

    public Harddisk(String navn, int pris, int lagringsplass){
        super(navn, pris);
        this.lagringsplass= lagringsplass;
    }
}
