package Filbehandling;

import Datamaskin.Komponent;
import java.io.IOException;

public class ParseKomponent {
    public static Komponent ParseKomponent(String str) throws IOException{
        String [] array= str.split(FormaterDatamaskin.DELIMITER);

        if(array.length!= 3){
            throw new IOException("Kunne ikke lese fra fil!");
        }

        String navn= array[0];
        String komponent= array[1];
        int pris;

        try{
            pris = Integer.parseInt(array[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }


        return new Komponent(navn, komponent, pris);
    }
}
