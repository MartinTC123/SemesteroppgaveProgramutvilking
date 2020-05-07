package sample;

import Filbehandling.FilLeserJobj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class Controller {

    @FXML
    void sluttScene(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../Sluttbruker/Sluttbruker.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
        FilLeserJobj.les(Paths.get("komponenter.jobj"));
    }

    @FXML
    void superScene(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../SuperbrukerInnlogging/Mellomscene.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }
}

