package Filbehandling;

import Datamaskin.Komponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilLeserTxt {
    public static ArrayList<Komponent> les(Path path) throws IOException{
        ArrayList<Komponent> kListe = new ArrayList<>();
        try(BufferedReader leser = Files.newBufferedReader(path)){
            String linje;
            while ((linje = leser.readLine()) != null){
                Komponent k = ParseKomponent.ParseKomponent(linje);
                kListe.add(k);
            }
        }
        return kListe;
    }
}
