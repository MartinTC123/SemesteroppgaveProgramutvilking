package Superbruker;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Superbruker implements Initializable {

    KomponentCollection kColl3= new KomponentCollection();

    ArrayList<Komponent> dataListe= new ArrayList<>();

    Komponent test= new Komponent("Test", "Minne", 1000);

    @FXML
    private TableView tabell3;

    @FXML
    private TableColumn<Komponent, String> navnC3;

    @FXML
    private TableColumn<Komponent, String> komponentC3;

    @FXML
    private TableColumn<Komponent, Integer> prisC3;

    @FXML
    private TextField innKomponent;

    @FXML
    private TextField innNavn;

    @FXML
    private TextField innPris;

    @FXML
    void lagreEndringer(ActionEvent event) {

    }

    @FXML
    void leggTilKomponent(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kColl3.kobleTilTableView(tabell3);

        navnC3.setCellFactory(TextFieldTableCell.forTableColumn());
        komponentC3.setCellFactory(TextFieldTableCell.forTableColumn());
        prisC3.setCellFactory(TextFieldTableCell.<Komponent,Integer>forTableColumn(new IntegerStringConverter()));

        kColl3.leggTilElement(test);

        tabell3.setEditable(true);
    }

    @FXML
    public void txtNavnEdited(TableColumn.CellEditEvent<Komponent, String> event){
        event.getRowValue().setNavn(event.getNewValue());
    }

    @FXML
    public void txtKomponentEdited(TableColumn.CellEditEvent<Komponent, String> event){
        event.getRowValue().setKomponent(event.getNewValue());
    }

    @FXML
    public void intPrisEdited(TableColumn.CellEditEvent<Komponent, Integer> event){
        if (IntegerStringOmgjøring.omgjøring){
            event.getRowValue().setPris(event.getNewValue());
        }
        tabell3.refresh();
    }
}