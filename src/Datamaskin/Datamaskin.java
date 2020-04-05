package Datamaskin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Datamaskin {
    private ObservableList<Komponent> Datamaskin = FXCollections.observableArrayList();

    public void FestTableView(TableView tv) {
        tv.setItems(Datamaskin);
    }
}
