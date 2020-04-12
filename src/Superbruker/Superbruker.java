package Superbruker;

import Avvikshåndtering.Avvik;
import Avvikshåndtering.TableViewAvvik;
import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Superbruker implements Initializable {

    @FXML
    private TableView tabell3;

    @FXML
    private TableColumn<Komponent, String> navnC3;

    @FXML
    private TableColumn<Komponent, String> komponentC3;

    @FXML
    private TableColumn<Komponent, Integer> prisC3;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField innNavn;

    @FXML
    private TextField innPris;

    @FXML
    private TextField txtFiltrer;

    @FXML
    private Label lblNyttKomponent;

    @FXML
    void lagreEndringer(ActionEvent event) {

    }

    @FXML
    void leggTilKomponent(ActionEvent event) {
        Komponent nyttKomponent= null;
        try {
            nyttKomponent = opprettKomponent();
        }
        catch (NumberFormatException e){
            lblNyttKomponent.setText("Velg type komponent, skriv inn navn og gyldig pris!");
        }
        if (nyttKomponent != null){
            kColl3.leggTilElement(nyttKomponent);
            resetTextFields();
        }
    }

    @FXML
    public void byttScene(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../Sample/sample.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }

    @FXML
    public void fjernKomponent(ActionEvent event){
        Komponent valgtKomponent= (Komponent) tabell3.getSelectionModel().getSelectedItem();
        kColl3.fjernElement(valgtKomponent);
    }

    KomponentCollection kColl3= new KomponentCollection();

    ArrayList<Komponent> dataListe= new ArrayList<>();

    ObservableList<String> tilgjengeligeValg= FXCollections.observableArrayList("Prosessor", "Skjermkort", "Minne", "Harddisk", "Tastatur", "Mus", "Skjerm");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kColl3.kobleTilTableView(tabell3);
        kColl3.sorterTableView(tabell3, txtFiltrer);

        choiceBox.setItems(tilgjengeligeValg);

        navnC3.setCellFactory(TextFieldTableCell.forTableColumn());
        komponentC3.setCellFactory(TextFieldTableCell.forTableColumn());
        prisC3.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tabell3.setEditable(true);
    }

    private Komponent opprettKomponent(){
        String navn= innNavn.getText();
        String komponent= choiceBox.getSelectionModel().getSelectedItem();
        int pris= Integer.parseInt(innPris.getText());

        boolean testNavn= Avvik.navnHaandtering(innNavn.getText());
        boolean testKomponent= Avvik.komponentHaandtering(choiceBox);
        boolean opprettKomponent;

        try {
            boolean testPris= Avvik.prisHaandtering(Integer.parseInt(innPris.getText()));
            opprettKomponent= testNavn && testKomponent && testPris;
        }catch (NumberFormatException e){
            throw new NumberFormatException("Feil input tall/bokstav");
        }

        Komponent nyttKomponent= new Komponent(navn, komponent, pris);

        if (!opprettKomponent){
            lblNyttKomponent.setText(Avvik.avviksMelding);
            nyttKomponent= null;
        }
        else {
            dataListe.add(nyttKomponent);
            lblNyttKomponent.setText("Komponentet ble registrert");
        }
        return nyttKomponent;
    }

    private void resetTextFields(){
        innNavn.setText("");
        innPris.setText("");
        choiceBox.getSelectionModel().clearSelection();
    }

    private TableViewAvvik nyVerdi= new TableViewAvvik();

    Alert advarsel= new Alert(Alert.AlertType.WARNING);

    @FXML
    public void txtNavnEdited(TableColumn.CellEditEvent<Komponent, String> event){
        if (!nyVerdi.navnTVHaandtering(event.getNewValue())){
            advarsel.setTitle("Advarsel!");
            advarsel.setHeaderText("Feil ved redigering av navn! Du har tastet inn et ugyldig navn.");
            advarsel.showAndWait();
            tabell3.refresh();
        }else {
            event.getRowValue().setNavn(event.getNewValue());
        }
    }

    @FXML
    public void txtKomponentEdited(TableColumn.CellEditEvent<Komponent, String> event){
        if (!nyVerdi.komponentTVHaandtering(event.getNewValue())){
            advarsel.setTitle("Advarsel!");
            advarsel.setHeaderText("Feil ved redigering av type komponent! Du har tastet inn et ugyldig komponent.");
            advarsel.showAndWait();
            tabell3.refresh();
        }else {
            event.getRowValue().setKomponent(event.getNewValue());
        }
    }

    @FXML
    public void intPrisEdited(TableColumn.CellEditEvent<Komponent, Integer> event){
        if (!nyVerdi.prisTVHaandtering(event.getNewValue())){
            advarsel.setTitle("Advarsel!");
            advarsel.setHeaderText("Feil ved redigering av pris! Du har skrevet inn en ugyldig pris.");
            advarsel.showAndWait();
            tabell3.refresh();
        }else {
            event.getRowValue().setPris(event.getNewValue());
        }
    }
}