package Filbehandling;

import Datamaskin.Komponent;
import javafx.concurrent.Task;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilLeserJobj extends Task<ArrayList> {
    private final Path path;

    public FilLeserJobj(Path path) {
        this.path = path;
    }

    @Override
    protected ArrayList<Komponent> call() throws Exception {
        ArrayList<Komponent> kListe = new ArrayList<>();
        Komponent k;
        try (InputStream fil =  Files.newInputStream(path);
             ObjectInputStream innStream = new ObjectInputStream(fil);) {
            Thread.sleep(3000);
            while (true){
                k = (Komponent) innStream.readObject();
                kListe.add(k);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
        return kListe;
    }
}

