package SceneForDatamaskiner;

import Datamaskin.Komponent;
import Datamaskin.KomponentCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import java.io.IOException;
import java.net.URL;
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

    KomponentCollection kColl = new KomponentCollection();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kColl.kobleTilTableView(tabell);

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
