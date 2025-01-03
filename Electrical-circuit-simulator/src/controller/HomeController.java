package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private HBox hboxParallel;

    @FXML
    private HBox hboxSerial;

    @FXML
    private void handleHBoxClick(MouseEvent event) throws Exception {
        FXMLLoader loader;
        if (event.getSource() == hboxParallel) {
            loader = new FXMLLoader(getClass().getResource("/views/parallel/Parallel.fxml"));
        } else if (event.getSource() == hboxSerial) {
            loader = new FXMLLoader(getClass().getResource("/views/serial/Serial.fxml"));
        } else {
            return;
        }

        Parent newRoot = loader.load();

        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newRoot);
        stage.setScene(newScene);
        stage.show();
    }
}
