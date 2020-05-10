package Filbehandling;

import Datamaskin.Komponent;

public class ParseKomponent {
    public static Komponent ParseKomponent(String str){
        Object[]array= str.split(FormaterDatamaskin.DELIMITER);

        String navn= (String) array[0];
        String komponent= (String) array[1];
        int pris= (int) array[2];

        return new Komponent(navn, komponent, pris);
    }
}
