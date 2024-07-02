import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Button HomePageButton;

    public static boolean CheckBoxStatue = true;

    @FXML
    private CheckBox MusicCheckBox;

    @FXML
    private Label MusicField;

    @FXML
    void ChangeMusic(ActionEvent event) {
        if (MusicCheckBox.isSelected()) {
            MusicField.setText("ON");
            MusicControllerMedia.playMedia();
            CheckBoxStatue = true; 
        } else {
            MusicField.setText("OFF");
            MusicControllerMedia.pauseMedia();
            CheckBoxStatue=false;
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MusicCheckBox.setSelected(CheckBoxStatue); // Set the default state to selected
        if(CheckBoxStatue){
            MusicField.setText("ON");
        }else{
            MusicField.setText("OFF");
        }

        // Back To Home Scene
        HomePageButton.setOnAction(e -> {
            try {
                HelpersController.SwitchToHomeScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    // Method to get the state of the CheckBox
    public static boolean GetCheckBoxStatue() {
        return CheckBoxStatue;
    }
    
}


