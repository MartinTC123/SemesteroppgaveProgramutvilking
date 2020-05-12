package SceneForDatamaskiner;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import Filbehandling.FilFraMappe;
import Filbehandling.FilLeserTxt;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class OpprettedeDatamaskiner implements Initializable {

    @FXML
    private TableView<Komponent> tabell;

    @FXML
    private TableColumn<Komponent, String> navnC;

    @FXML
    private TableColumn<Komponent, String> komponentC;

    @FXML
    private TableColumn<Komponent, Integer> prisC;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label lblUt;

    KomponentCollection kColl = new KomponentCollection();

    ArrayList<String> filer= FilFraMappe.Filer();

    public List<String> getList(){
        return filer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kColl.kobleTilTableView(tabell);

        choiceBox.setItems(FXCollections.observableArrayList(getList()));
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, gammelVerdi, nyVerdi) -> {
            Path path = Paths.get("src/txtFiler/"+ filer.get(nyVerdi.intValue()));
            tabell.getItems().clear();
            lblUt.setText(null);
            try {
                ArrayList<Komponent> kListe = FilLeserTxt.les(path);
                for (Komponent k : kListe){
                    kColl.leggTilElement(k);
                    TableColumn<Komponent, Integer> rad= prisC;
                    List<Integer> data= new ArrayList<>();
                    for (Komponent k2 : tabell.getItems()){
                        data.add(rad.getCellObservableValue(k2).getValue());
                        lblUt.setText("Totalpris: " + String.valueOf(data.stream().mapToInt(i -> i).sum()) + "kr");
                    }
                }
            } catch (IOException e) {
                lblUt.setText(e.getMessage());
            }
        });

        navnC.setCellFactory(TextFieldTableCell.forTableColumn());
        komponentC.setCellFactory(TextFieldTableCell.forTableColumn());
        prisC.setCellFactory(TextFieldTableCell.<Komponent,Integer>forTableColumn(new IntegerStringConverter()));
    }

    @FXML
    void gåTilbake(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../Sluttbruker/Sluttbruker.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }
}
