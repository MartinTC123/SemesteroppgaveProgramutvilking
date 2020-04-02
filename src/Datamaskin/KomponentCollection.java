package Datamaskin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class KomponentCollection {

    private ObservableList<Komponent> liste= FXCollections.observableArrayList();

    public void kobleTilTableView(TableView t){
        t.setItems(liste);
    }

    public void leggTilElement(Komponent o){
        liste.add(o);
    }
}
