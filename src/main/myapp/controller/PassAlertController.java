package src.main.myapp.controller;
import java.io.IOException;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class PassAlertController {

    private Stage stage;
    private Consumer<ActionEvent> sceneSwitchFunction;
    private Consumer<ActionEvent> sceneBackFunction;

    // Load the sound effect
    AudioClip sound = new AudioClip(getClass().getResource("../../resources/Sound/LevelPassed.mp3").toString());

    public void setStage(Stage stage) {
        this.stage = stage;
        sound.play();
    }

    public void setButtonAction(Consumer<ActionEvent> action) {
        this.sceneSwitchFunction = action;
    }

    public void setBackAction(Consumer<ActionEvent> action) {
        this.sceneBackFunction = action;
    }

    @FXML
    private Button nextBtn;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button shiny;

    @FXML
    private void handleActionButton(ActionEvent event) {

        if (sceneSwitchFunction != null) {
            sceneSwitchFunction.accept(event);

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
