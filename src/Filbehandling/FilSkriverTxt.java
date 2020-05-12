package Filbehandling;

import Datamaskin.Komponent;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilSkriverTxt {
    public static void lagre(ObservableList<Komponent> liste, Path path) throws IOException,NullPointerException {
        String tekst= FormaterDatamaskin.formaterDatamaskiner(liste);
        Files.write(path, tekst.getBytes());
    }
}
