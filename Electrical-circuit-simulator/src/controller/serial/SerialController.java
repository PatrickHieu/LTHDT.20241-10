package controller.serial;

import controller.CircuitController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class SerialController extends CircuitController {

    public void handleSubmit() {
        try {
            super.handleSubmit();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/serial/SerialResult.fxml"));
            Parent newRoot = loader.load();
            Scene currentScene = getBtnSubmit().getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void changeCircuitScene(MouseEvent event) throws Exception {
        super.changeCircuitScene(event, "/fxml/serial/Serial.fxml");
    }
}
