package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    void sluttScene(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../Sluttbruker/Sluttbruker.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }

    @FXML
    void superScene(ActionEvent event) throws IOException {
        Parent scene= FXMLLoader.load(getClass().getResource("../Superbruker/Superbruker.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }
}

