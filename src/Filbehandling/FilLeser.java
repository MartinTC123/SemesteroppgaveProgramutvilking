package Filbehandling;

import Datamaskin.Komponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilLeser {
    public static List<Komponent> les(Path path) throws IOException {
        ArrayList<Komponent> liste= new ArrayList<>();
        try (BufferedReader reader= Files.newBufferedReader(path)){
            String linje;
            while ((linje= reader.readLine()) != null){
                Komponent k= ParseData.ParseData(linje);
                liste.add(k);
            }
        }
        return liste;
    }
}
