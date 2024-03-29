package Sluttbruker;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import Exceptions.FilEksisterer;
import Exceptions.UgyldigKomponent;
import Exceptions.UgyldigNavn;
import Filbehandling.FilFraMappe;
import Filbehandling.FilLeserJobj;
import Filbehandling.FilSkriverTxt;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
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

        Path path = Paths.get("src/jobjFiler/komponenter.jobj");

        private FilLeserJobj traad;

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
        private Button btnBeregn;

        @FXML
        private Button btnLagre;

        @FXML
        private Button btnFjern;

        @FXML
        public void lagreTilFil(ActionEvent event) {
                boolean prosessor = true;
                boolean skjermkort = true;
                boolean minne = true;
                boolean harddisk = true;

                ObservableList<Komponent> dataListe;
                try {
                        Path path1 = Paths.get(inputLagre.getText()+".txt");
                        Path path2 = Paths.get("src/txtFiler/" + path1);
                        ArrayList<String> filer = FilFraMappe.Filer();
                        dataListe = kColl.getListe();

                        if (dataListe.isEmpty()){
                                throw new UgyldigKomponent("Du kan ikke lagre en tom datamaskin");
                        }

                       if (inputLagre.getText().isEmpty()){
                            throw new UgyldigNavn("Vennligst skriv inn et navn");
                        }

                       for (Komponent k : dataListe){
                         if (k.getKomponent().equals("Prosessor")){
                                 prosessor=false;

                         }
                         if (k.getKomponent().equals("Skjermkort")){
                                 skjermkort=false;
                         }
                         if (k.getKomponent().equals("Minne")){
                                 minne = false;
                         }
                         if (k.getKomponent().equals("Harddisk")){
                                 harddisk=false;
                         }
                       }
                       if (prosessor||skjermkort||minne||harddisk){
                               throw new UgyldigKomponent("Du må ha prosessor, skjermkort, minne og harddisk \ni en datamaskin");
                       }

                        for (String fil: filer) {
                                if (String.valueOf(path1).equals(fil)){
                                        throw new FilEksisterer("Filnavnet eksisterer, prøv et annet navn");
                                }
                        }
                        FilSkriverTxt.lagre(dataListe, path2);
                        lblFilbehandling.setText("Fil ble lagret med følgende navn: " + path1);

                } catch (IOException e) {
                        lblFilbehandling.setText("En feil skjedde ved lagring til fil, prøv på nytt.");
                }
                catch (FilEksisterer | UgyldigNavn|UgyldigKomponent e ){
                        lblFilbehandling.setText(e.getMessage());
                }
                catch (NullPointerException e){
                        lblFilbehandling.setText("En feil skjedde, trykk på Fjern alt og prøv på nytt");
                }


        }

        @FXML
        public void fjernData(ActionEvent event) {
                ObservableList<Komponent> kListe = tabell1.getItems();
                for (Komponent k : kListe){
                        kColl2.leggTilElement(k);
                }
                tabell1.getItems().clear();
                lblTotalpris.setText(null);
        }

        @FXML
        public void byttScene(ActionEvent event) throws IOException {
                Parent scene= FXMLLoader.load(getClass().getResource("../Sample/sample.fxml"));
                Scene scene1= new Scene(scene);
                Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
                vindu.setScene(scene1);
                vindu.show();
                vindu.setTitle("Datamaskin");
        }

        @FXML
        public void opprettedeDatamaskiner(ActionEvent event) throws IOException {
                Parent scene= FXMLLoader.load(getClass().getResource("../SceneForDatamaskiner/opprettedeDatamaskiner.fxml"));
                Scene scene1= new Scene(scene);
                Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
                vindu.setScene(scene1);
                vindu.show();
                vindu.setTitle("Opprettede datamaskiner");
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

                traad = new FilLeserJobj(path);
                traad.setOnSucceeded(this::traadFerdig);
                traad.setOnFailed(this::traadFeilet);
                Thread th = new Thread(traad);
                th.setDaemon(true);
                tabell1.setDisable(true);
                tabell2.setDisable(true);
                inputLagre.setDisable(true);
                txtFiltrer.setDisable(true);
                btnBeregn.setDisable(true);
                btnFjern.setDisable(true);
                btnLagre.setDisable(true);
                lblTotalpris.setStyle("-fx-text-fill:#ff4d05");
                lblTotalpris.setText("Laster inn... Vennligst vent...");
                th.start();

                kColl2.sorterTableView(tabell2, txtFiltrer);
                tabell2.setOnMouseClicked(event -> {
                        Komponent valgtKomponent= tabell2.getSelectionModel().getSelectedItem();
                        try{
                        if(!valgtKomponent.getKomponent().isEmpty()) {
                                kColl.leggTilElement(valgtKomponent);
                                kColl2.fjernElement(valgtKomponent);
                                lblTotalpris.setText(null);
                        }
                        } catch (NullPointerException e) {
                                e.getMessage();
                        }
                });
                tabell1.setOnMouseClicked(event -> {
                        Komponent valgtKomponent= tabell1.getSelectionModel().getSelectedItem();
                        try{
                        if(!valgtKomponent.getKomponent().isEmpty()){
                        kColl.fjernElement(valgtKomponent);
                        kColl2.leggTilElement(valgtKomponent);
                        lblTotalpris.setText(null);
                        }
                        }
                        catch (NullPointerException e){
                                e.getMessage();
                        }
                });
        }

        private void traadFeilet(WorkerStateEvent event){
                Throwable e = event.getSource().getException();
                lblTotalpris.setText(e.getMessage());
                tabell1.setDisable(false);
                tabell2.setDisable(false);
                inputLagre.setDisable(false);
                txtFiltrer.setDisable(false);
                btnBeregn.setDisable(false);
                btnFjern.setDisable(false);
                btnLagre.setDisable(false);
        }

        private void traadFerdig(WorkerStateEvent e){
                ArrayList<Komponent> kListe = traad.getValue();
                for (Komponent k : kListe){
                        kColl2.leggTilElement(k);
                }
                lblTotalpris.setStyle(null);
                lblTotalpris.setText(null);
                tabell1.setDisable(false);
                tabell2.setDisable(false);
                inputLagre.setDisable(false);
                txtFiltrer.setDisable(false);
                btnBeregn.setDisable(false);
                btnFjern.setDisable(false);
                btnLagre.setDisable(false);
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


