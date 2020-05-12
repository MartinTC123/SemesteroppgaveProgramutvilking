package Filbehandling;

import Datamaskin.Komponent;
import java.util.List;

public class FormaterDatamaskin {
    public static String DELIMITER= ",";

    public static String formaterDatamaskin(Komponent k){
        return k.getNavn() + DELIMITER + k.getKomponent() + DELIMITER + k.getPris();
    }

    public static String formaterDatamaskiner(List<Komponent> komponents){
        StringBuffer str= new StringBuffer();
        for (Komponent k : komponents){
            str.append(formaterDatamaskin(k) + "\n");
        }
        return str.toString();
    }
}
