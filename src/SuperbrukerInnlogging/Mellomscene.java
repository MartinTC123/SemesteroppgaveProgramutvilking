package SuperbrukerInnlogging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Mellomscene {

    @FXML
    private TextField txtBrukernavn;

    @FXML
    private PasswordField txtPassord;

    @FXML
    private Label lblUt;

    private String brukernavn= "Admin";
    private String passord= "shaggy123";

    @FXML
    void loggInn(ActionEvent event) throws IOException {
        if (txtBrukernavn.getText().equals(brukernavn) && txtPassord.getText().equals(passord)){
            Parent scene= FXMLLoader.load(getClass().getResource("../Superbruker/Superbruker.fxml"));
            Scene scene1= new Scene(scene);
            Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
            vindu.setScene(scene1);
            vindu.show();
        }else {
            lblUt.setText("Feil brukernavn eller passord!");
        }
    }

    @FXML
    void gåTilbake(ActionEvent event) throws IOException{
        Parent scene= FXMLLoader.load(getClass().getResource("../Sample/sample.fxml"));
        Scene scene1= new Scene(scene);
        Stage vindu= (Stage) ((Node)event.getSource()).getScene().getWindow();
        vindu.setScene(scene1);
        vindu.show();
    }
}

