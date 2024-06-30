

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    
    @FXML
    private Label TitleField;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create the ScaleTransition
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), TitleField);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        // Start the animation when the Label is clicked
        TitleField.setOnMouseClicked(event -> scaleTransition.playFromStart());
    }
}
