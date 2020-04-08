package Filbehandling;

import Datamaskin.Komponent;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FilSkriver {
    void lagre (ArrayList<Komponent> liste, Path path) throws IOException;
}
