package Superbruker;

import javafx.scene.control.Alert;

public class IntegerStringOmgjøring extends javafx.util.converter.IntegerStringConverter {
    public static boolean omgjøring= true;

    @Override
    public Integer fromString(String s) {
        try {
            Integer result = super.fromString(s);
            omgjøring = true;
            return result;
        } catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setHeaderText("Ugyldig data!");
            alert.setContentText("Du må taste inn en gyldig pris!");
            alert.showAndWait();

            omgjøring = false;
            return 0;
        }
    }
}
