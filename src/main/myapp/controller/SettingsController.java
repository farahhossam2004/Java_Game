package src.main.myapp.controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ImageView MusicImage;

    @FXML
    private Slider SliderVolumeBar;

    public static double LastSliderNumber=100;

    //===================================================================================================
    Image imageOn = new Image(getClass().getResourceAsStream("../../resources/Images/Music1.png"));
    Image imageOff = new Image(getClass().getResourceAsStream("../../resources/Images/Muted.png"));
    //===================================================================================================


    @FXML
    void ChangeMusic(ActionEvent event) {
        if (MusicCheckBox.isSelected()) {
            MusicImage.setImage(imageOn);
            MusicControllerMedia.playMedia();
            CheckBoxStatue = true;
            SliderVolumeBar.setValue(100); 
            LastSliderNumber=100;
        } else {
            MusicImage.setImage(imageOff);
            MusicControllerMedia.pauseMedia();
            CheckBoxStatue=false;
            SliderVolumeBar.setValue(0);
            LastSliderNumber=0;
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MusicCheckBox.setSelected(CheckBoxStatue); // Set the default state to selected
        SliderVolumeBar.setValue(LastSliderNumber);
        if(CheckBoxStatue){
            MusicImage.setImage(imageOn);
        }else{
            MusicImage.setImage(imageOff);
        }

        SliderVolumeBar.valueProperty().addListener(new ChangeListener<Number>() {
            double slidervalue;
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                slidervalue = SliderVolumeBar.getValue();
                LastSliderNumber = slidervalue;
                MusicControllerMedia.playMediaVolume((int)slidervalue);
                if(slidervalue == 0){
                    MusicImage.setImage(imageOff);
                    CheckBoxStatue = false;
                    MusicCheckBox.setSelected(CheckBoxStatue);
                }else{
                    MusicImage.setImage(imageOn);
                    CheckBoxStatue = true;
                    MusicCheckBox.setSelected(CheckBoxStatue);
                    MusicControllerMedia.playMedia();
                }
            }
            
        });

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


