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
    public static KomponentCollection les (Path path) {
        KomponentCollection kListe = new KomponentCollection();
        Komponent k = null;
        Object o = null;

        try (InputStream fil =  Files.newInputStream(path);
            ObjectInputStream innStream = new ObjectInputStream(fil);)
        {
             k = (Komponent) innStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
        String s = k.getNavn();

        System.out.println(s);
        return kListe;
   }



}

