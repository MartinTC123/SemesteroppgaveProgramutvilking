package Sluttbruker;

import Datamaskin.Komponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Sluttbruker implements Initializable {

        @FXML
        private TextField innFornavn;

        @FXML
        private TextField innEtternavn;

        @FXML
        private TableView<Komponent> table1;

        @FXML
        private TableView<Komponent> table2;

        @FXML
        private TableColumn<Komponent, String> col1Navn;

        @FXML
        private TableColumn<Komponent, String> col1Komponent;

        @FXML
        private TableColumn<Komponent, Integer> col1Pris;

        @FXML
        private TableColumn<Komponent, String> col2Navn;

        @FXML
        private TableColumn<Komponent, String> col2Komponent;

        @FXML
        private TableColumn<Komponent, Integer> col2Pris;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }

        @FXML
        void leggTilHandlekurv(ActionEvent event) {

        }

        @FXML
        void seHandlekurv(ActionEvent event) {

        }

}
