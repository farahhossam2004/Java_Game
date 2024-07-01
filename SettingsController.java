import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {


    private Stage stage ;
    private Scene scene;
    private Parent root;

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

    //Back to home Scene Button 
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        PersonManagment.SetplayingPerson(null);
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MusicCheckBox.setSelected(CheckBoxStatue); // Set the default state to selected
        if(CheckBoxStatue){
            MusicField.setText("ON");
        }else{
            MusicField.setText("OFF");
        }
    }

    // Method to get the state of the CheckBox
    public static boolean GetCheckBoxStatue() {
        return CheckBoxStatue;
    }
}


