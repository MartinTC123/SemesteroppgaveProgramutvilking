package Avvikshåndtering;

import Exceptions.UgyldigKomponent;
import Exceptions.UgyldigNavn;
import Exceptions.UgyldigPris;
import javafx.scene.control.ChoiceBox;

public class Avvik {

    public static String avviksMelding;

    int test;

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

    public static boolean komponentHaandtering(ChoiceBox kompTest){
        boolean sjekkKomponent= true;
        try {
            KomponentValidator.gyldigKomponent(kompTest);
        }catch (UgyldigKomponent e){
            avviksMelding= e.getMessage();
            sjekkKomponent= false;
        }
        return sjekkKomponent;
    }

    public static boolean TableKomponentHaandtering(String nyVerdi){
        boolean sjekkNyttKomponent= true;
        try {
            KomponentValidator.gyldigTableKomponent(nyVerdi);
        }catch (UgyldigKomponent e){
            avviksMelding= e.getMessage();
            sjekkNyttKomponent= false;
        }
        return sjekkNyttKomponent;
    }
}
