package Filbehandling;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilLeserJobj implements FilLeser {
    public static ArrayList les (Path path) {
        ArrayList<Komponent> kkListe = new ArrayList<>();
        Komponent k;

        try (InputStream fil =  Files.newInputStream(path);
            ObjectInputStream innStream = new ObjectInputStream(fil);) {
            while (true){
                k = (Komponent) innStream.readObject();
            kkListe.add(k);
        }
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
        return kkListe;
   }



}

