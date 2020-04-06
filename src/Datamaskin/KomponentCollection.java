package Datamaskin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class KomponentCollection {

    private ObservableList<Komponent> liste= FXCollections.observableArrayList();

    public void kobleTilTableView(TableView t){
        t.setItems(liste);
    }

    public void leggTilElement(Komponent o){
        liste.add(o);
    }

    public void fjernElement(Komponent o){
        liste.remove(o);
    }

    public void sorterTableView(TableView<Komponent> t, TextField t1){
        FilteredList<Komponent> filtrertListe = new FilteredList<>(liste, b -> true);

        t1.textProperty().addListener(((observable, oldValue, newValue) -> {
            filtrertListe.setPredicate(komponent -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lCaseFilter= newValue.toLowerCase();

                if (komponent.getNavn().toLowerCase().contains(lCaseFilter)){
                    return true;
                }
                else if (komponent.getKomponent().contains(lCaseFilter)){
                    return true;
                }
                else if (komponent.getPris().contains(lCaseFilter)){
                    return true;
                }
                return false;
            });
        }));

        SortedList<Komponent> sortertListe= new SortedList<>(filtrertListe);
        sortertListe.comparatorProperty().bind(t.comparatorProperty());
        t.setItems(sortertListe);
    }
}
