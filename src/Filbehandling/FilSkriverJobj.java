package Filbehandling;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilSkriverJobj {
    public static void lagre(List<?> liste, Path path) throws IOException {
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(os)){

                for (Object k : liste){
                out.writeObject(k);
                }
        }
    }
}
