package Avvikshåndtering;

import Exceptions.UgyldigNavn;
import Exceptions.UgyldigPris;

public class KomponentValidator {

    public static void gyldigNavn(String test) throws UgyldigNavn{
        boolean gyldig= test.matches("^[a-zA-Z]+(([',. -][a-zA-Z,0-9])?[a-zA-Z, 0-9]*)*$"); // regex hentet fra https://www.regextester.com/
        if (!gyldig){
            throw new UgyldigNavn("Ugyldig navn input");
        }
    }

    public static void gyldigPris(int test) throws UgyldigPris{
        if (test < 0){
            throw new UgyldigPris("Ugyldig pris! Prisen kan ikke være negativ");
        } else if(test > 15000){
            throw new UgyldigPris("Ugyldig pris! Maks grense for pris er 14999kr");
        }
    }
}
