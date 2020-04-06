package Sluttbruker;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Sluttbruker implements Initializable {

        KomponentCollection kColl= new KomponentCollection();

        KomponentCollection kColl2= new KomponentCollection();

        Komponent test= new Komponent("Test1", "Skjermkort", "2099kr");
        Komponent test2= new Komponent("Test2", "Prosessor", "2299kr");
        Komponent test3= new Komponent("Test3", "Minne", "1499kr");
        Komponent test4= new Komponent("Test4", "Tastatur", "1399kr");
        Komponent test5= new Komponent("Test5", "Mus", "999kr");
        Komponent test6= new Komponent("Test6", "Skjerm", "2499kr");

        @FXML
        private TextField innFornavn;

        @FXML
        private TextField innEtternavn;

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
        private TableColumn<Komponent, String> prisC;

        @FXML
        private TableColumn<Komponent, String> navnC2;

        @FXML
        private TableColumn<Komponent, String> komponentC2;

        @FXML
        private TableColumn<Komponent, String> prisC2;

        @FXML
        void leggTilHandlekurv(ActionEvent event) {

        }

        @FXML
        void seHandlekurv(ActionEvent event) {

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                kColl.kobleTilTableView(tabell1);
                kColl2.kobleTilTableView(tabell2);

                navnC.setCellFactory(TextFieldTableCell.forTableColumn());
                komponentC.setCellFactory(TextFieldTableCell.forTableColumn());
                prisC.setCellFactory(TextFieldTableCell.forTableColumn());
                navnC2.setCellFactory(TextFieldTableCell.forTableColumn());
                komponentC2.setCellFactory(TextFieldTableCell.forTableColumn());
                prisC2.setCellFactory(TextFieldTableCell.forTableColumn());

                kColl2.leggTilElement(test);
                kColl2.leggTilElement(test2);
                kColl2.leggTilElement(test3);
                kColl2.leggTilElement(test4);
                kColl2.leggTilElement(test5);
                kColl2.leggTilElement(test6);

                kColl2.sorterTableView(tabell2, txtFiltrer);
        }
}
