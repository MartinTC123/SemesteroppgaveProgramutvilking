package Filbehandling;

import Datamaskin.Komponent;

public class ParseData {
    public static Komponent ParseData(String str){
        Object[]array= str.split(FormaterDatamaskin.DELIMITER);

        String navn= (String) array[0];
        String komponent= (String) array[1];
        int pris= (int) array[2];

        return new Komponent(navn, komponent, pris);
    }
}
