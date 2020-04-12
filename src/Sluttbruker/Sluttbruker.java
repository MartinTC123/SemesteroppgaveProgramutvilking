package Sluttbruker;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
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

        Komponent test= new Komponent("Test1", "Skjermkort", 2100);
        Komponent test2= new Komponent("Test2", "Prosessor", 2300);
        Komponent test3= new Komponent("Test3", "Minne", 1500);
        Komponent test4= new Komponent("Test4", "Tastatur", 1400);
        Komponent test5= new Komponent("Test5", "Mus", 1000);
        Komponent test6= new Komponent("Test6", "Skjerm", 2500);
        Komponent test7= new Komponent("Test7", "Harddisk", 1600);

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
                FilSkriverTxt skrivTxt= new FilSkriverTxt();
                Path path = Paths.get("src/txtFiler/Datamaskin" + inputLagre.getText() + ".txt");
                try {
                        FilSkriverTxt.lagre(dataListe, path );
                        lblFilbehandling.setText("Fil ble lagret med følgende versjon: " + inputLagre.getText());
                } catch (IOException e) {
                        lblFilbehandling.setText("Noe gikk feil ved lagring til fil!");
                }
        }

        @FXML
        public void eksempelData(ActionEvent event) {
                kColl.leggTilElement(test);
                kColl.leggTilElement(test2);
                kColl.leggTilElement(test3);
                kColl.leggTilElement(test4);
                kColl.leggTilElement(test5);
                kColl.leggTilElement(test6);
                kColl.leggTilElement(test7);
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

                kColl2.leggTilElement(test);
                kColl2.leggTilElement(test2);
                kColl2.leggTilElement(test3);
                kColl2.leggTilElement(test4);
                kColl2.leggTilElement(test5);
                kColl2.leggTilElement(test6);
                kColl2.leggTilElement(test7);

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
                for (Komponent p : tabell1.getItems()){
                        data.add(rad.getCellObservableValue(p).getValue());
                        lblTotalpris.setText("Totalpris: " + String.valueOf(data.stream().mapToInt(i -> i).sum()) + "kr");
                }
        }
}


