package Filbehandling;

import Datamaskin.Komponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilSkriverTxt implements FilSkriver {
    public void lagre(ArrayList<Komponent> liste, Path path) throws IOException {
        String tekst= FormaterDatamaskin.formaterDatamaskiner(liste);
        Files.write(path, tekst.getBytes());
    }
}
