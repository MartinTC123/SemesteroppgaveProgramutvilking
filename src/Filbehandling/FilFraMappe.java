package Filbehandling;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FilFraMappe {
    public static ArrayList<String> Filer (){
        ArrayList<String> filer = new ArrayList<>();
        File mappePath = new File("src/txtFiler");
        for (File fil : Objects.requireNonNull(mappePath.listFiles())){
            filer.add(fil.getName());
        }
        return filer;
    }
}
