package Avvikshåndtering;

import Exceptions.UgyldigKomponent;
import Exceptions.UgyldigNavn;
import Exceptions.UgyldigPris;
import javafx.scene.control.ChoiceBox;

public class KomponentValidator {

    int test;

    public static void gyldigNavn(String test) throws UgyldigNavn{
        boolean gyldig= test.matches("^[a-zA-Z]+(([',. -][a-zA-Z,0-9])?[a-zA-Z, 0-9]*)*$"); // regex hentet fra https://www.regextester.com/
        if (!gyldig){
            throw new UgyldigNavn("Ugyldig navn input");
        }
    }

    public static void gyldigPris(int test) throws UgyldigPris{
        if (test < 1){
            throw new UgyldigPris("Ugyldig pris! Prisen kan ikke være 0 eller negativ");
        } else if(test > 15000){
            throw new UgyldigPris("Ugyldig pris! Maks grense for pris er 14999kr");
        }
    }

    public static void gyldigKomponent(ChoiceBox test) throws UgyldigKomponent{
        if (test.getSelectionModel().isEmpty()){
            throw new UgyldigKomponent("Du må velge type komponent!") {
            };
        }
    }

    public static void gyldigTableKomponent(String test) throws UgyldigKomponent{
        boolean gyldig= test.matches("^Prosessor$");
        boolean gyldig1= test.matches("^Minne$");
        boolean gyldig2= test.matches("^Skjerm$");
        boolean gyldig3= test.matches("^Skjermkort$");
        boolean gyldig4= test.matches("^Harddisk$");
        boolean gyldig5= test.matches("^Mus$");
        boolean gyldig6= test.matches("^Tastatur$");
        if (!gyldig && !gyldig1 && !gyldig2 && !gyldig3 && !gyldig4 && !gyldig5 && !gyldig6){
            throw new UgyldigKomponent("Ugyldig redigering av komponent! Du må taste inn et type komponent som er gyldig");
        }
    }
}
