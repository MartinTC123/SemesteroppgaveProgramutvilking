package Sluttbruker;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import Exceptions.UgyldigTall;
import Filbehandling.FilLeser;
import Filbehandling.FilLeserJobj;
import Filbehandling.FilSkriverTxt;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Sluttbruker implements Initializable {

        KomponentCollection kColl= new KomponentCollection();

        KomponentCollection kColl2= new KomponentCollection();

        ArrayList<Komponent> dataListe= new ArrayList<>();

        Path path = Paths.get("komponenter.jobj");

        @FXML
        private TextField inputLagre;

        @FXML
        private TextField txtFiltrer;

        @FXML
        private TableView<Komponent> tabell1;

        @FXML
        private TableView<Komponent> tabell2;

        @FXML
        private TableColumn<Komponent, String> navnC;

        @FXML
        private TableColumn<Komponent, String> komponentC;

        @FXML
        private TableColumn<Komponent, Integer> prisC;

        @FXML
        private TableColumn<Komponent, String> navnC2;

        @FXML
        private TableColumn<Komponent, String> komponentC2;

        @FXML
        private TableColumn<Komponent, Integer> prisC2;

        @FXML
        private Label lblTotalpris;

        @FXML
        private Label lblFilbehandling;


        @FXML
        public void lagreTilFil(ActionEvent event) {
                int versjonsNummer =0;
                try {
                        versjonsNummer = Integer.parseInt(inputLagre.getText());
                } catch (UgyldigTall e) {
                        lblFilbehandling.setText("Skriv inn versjonsnummer som heltall");
                }

                Path path = Paths.get("src/txtFiler/Datamaskin" + versjonsNummer + ".txt");


                try {
                        FilSkriverTxt.lagre(dataListe, path );
                        lblFilbehandling.setText("Fil ble lagret med følgende versjon: " + versjonsNummer);
                } catch (IOException e) {
                        lblFilbehandling.setText("Noe gikk feil ved lagring til fil!");
                }
        }

        @FXML
        public void eksempelData(ActionEvent event) {
               // fyll inn mot slutten
        }

        @FXML
        public void fjernData(ActionEvent event) {
                tabell1.getItems().clear();
        }

        @FXML
        public void byttScene(ActionEvent event) throws IOException {
                Parent scene= FXMLLoader.load(getClass().getResource("../Sample/sample.fxml"));
                Scene scene1= new Scene(scene);
                Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
                vindu.setScene(scene1);
                vindu.show();
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
                kColl.kobleTilTableView(tabell1);
                kColl2.kobleTilTableView(tabell2);

                navnC.setCellFactory(TextFieldTableCell.forTableColumn());
                komponentC.setCellFactory(TextFieldTableCell.forTableColumn());
                prisC.setCellFactory(TextFieldTableCell.<Komponent,Integer>forTableColumn(new IntegerStringConverter()));
                navnC2.setCellFactory(TextFieldTableCell.forTableColumn());
                komponentC2.setCellFactory(TextFieldTableCell.forTableColumn());
                prisC2.setCellFactory(TextFieldTableCell.<Komponent,Integer>forTableColumn(new IntegerStringConverter()));

                ArrayList<Komponent> kListe = FilLeserJobj.les(path);

                for (Komponent k : kListe){
                        kColl2.leggTilElement(k);
                }


                kColl2.sorterTableView(tabell2, txtFiltrer);
                tabell2.setOnMouseClicked(event -> {
                        Komponent valgtKomponent= tabell2.getSelectionModel().getSelectedItem();
                        kColl.leggTilElement(valgtKomponent);
                        dataListe.add(valgtKomponent);
                        kColl2.fjernElement(valgtKomponent);
                });
                tabell1.setOnMouseClicked(event -> {
                        Komponent valgtKomponent= tabell1.getSelectionModel().getSelectedItem();
                        kColl.fjernElement(valgtKomponent);
                        dataListe.remove(valgtKomponent);
                        kColl2.leggTilElement(valgtKomponent);
                });
        }

        public void beregnTotPris(ActionEvent event) {
                TableColumn<Komponent, Integer> rad= prisC;
                List<Integer> data= new ArrayList<>();
                for (Komponent p : tabell1.getItems()) {
                        data.add(rad.getCellObservableValue(p).getValue());
                        lblTotalpris.setText("Totalpris: " + String.valueOf(data.stream().mapToInt(i -> i).sum()) + "kr");
                }
        }
}


