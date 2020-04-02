package Datamaskin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DatamaskinCollection {

    private ObservableList<Datamaskin> liste= FXCollections.observableArrayList();

    public void kobleTilTableView(TableView t){
        t.setItems(liste);
    }

    public void leggTilElement(Datamaskin o){
        liste.add(o);
    }
}
