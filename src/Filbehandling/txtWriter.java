package Filbehandling;

import Datamaskin.Komponent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class txtWriter {
    public void lagre(ArrayList<Komponent> liste, String input) throws IOException {
        String tekst= FormaterDatamaskin.formaterDatamaskiner(liste);
        Files.write(Paths.get("src/txtFiler/Datamaskin" + input + ".txt"), tekst.getBytes());
    }
}
