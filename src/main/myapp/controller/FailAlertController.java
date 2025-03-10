package src.main.myapp.controller;
import java.io.IOException;
import java.util.function.Consumer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class FailAlertController {
    
    
    private Stage stage;
    private Consumer<ActionEvent> TryAgainFunction;
    private Consumer<ActionEvent> sceneBackFunction;

    // Load the sound effect
    AudioClip sound = new AudioClip(getClass().getResource("../../resources/Sound/Failed.mp3").toString());

    public void setStage(Stage stage) {
        this.stage = stage;
        sound.play();
    }

    public void setTryAgainAction(Consumer<ActionEvent> action) {
        this.TryAgainFunction = action;
    }

    public void setBackAction(Consumer<ActionEvent> action) {
        this.sceneBackFunction = action;
    }

    @FXML
    private AnchorPane rootPane2;

    @FXML
    private Button shiny;

    @FXML
    private void TryAgainAButton(ActionEvent event) {

        if (TryAgainFunction != null) {
            TryAgainFunction.accept(event);
            
            if(stage != null)
            stage.close(); 

            sound.stop();
        }
    }

    @FXML
    void backButton(ActionEvent e) throws IOException {

        if (sceneBackFunction != null) {
            sceneBackFunction.accept(e);
            
            if(stage != null)
            stage.close(); 

            sound.stop();
        }
    }
}
