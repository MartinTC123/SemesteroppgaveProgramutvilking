package Avvikshåndtering;

import Exceptions.UgyldigNavn;
import Exceptions.UgyldigPris;

public class Avvik {

    public static String avviksMelding;

    public static boolean navnHaandtering(String navnTest){
        boolean sjekkNavn= true;
        try {
            KomponentValidator.gyldigNavn(navnTest);
        }catch (UgyldigNavn e){
            sjekkNavn = false;
            avviksMelding= e.getMessage();
        }
        return sjekkNavn;
    }

    public static boolean prisHaandtering(int prisTest){
        boolean sjekkPris= true;
        try {
            KomponentValidator.gyldigPris(prisTest);
        }catch (UgyldigPris e){
            avviksMelding= e.getMessage();
            sjekkPris= false;
        }
        return sjekkPris;
    }
}
