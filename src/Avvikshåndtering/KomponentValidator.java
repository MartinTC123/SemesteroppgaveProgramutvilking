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
        if (test < 0){
            throw new UgyldigPris("Ugyldig pris! Prisen kan ikke være negativ");
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
        boolean gyldig;
        gyldig= test.matches("\bProsessor\b");
        gyldig= test.matches("\bMinne\b");
        gyldig= test.matches("\bSkjerm\b");
        gyldig= test.matches("\bSkjermkort\b");
        gyldig= test.matches("\bHarddisk\b");
        gyldig= test.matches("\bMus\b");
        gyldig= test.matches("\bTastatur\b");
        if (!gyldig){
            throw new UgyldigKomponent("Ugyldig redigering av komponent!");
        }
    }
}
