package src.main.myapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import src.main.myapp.model.Person;
import src.main.myapp.model.PersonManagment;

public class NewGameSceneController implements Initializable {
    
    private Stage stage ;
    

    @FXML
    private Button HomePageButton;

    @FXML
    private Button DoneButton;

    @FXML
    private TextField TextNameArea;
    
    @FXML
    private Label NameLabel;

    String name;


    

    //============================================================

    
    public void Submit(ActionEvent event) throws IOException {
        name = TextNameArea.getText().trim(); // Trim 3shan a remove el white spaces
    
        if (name.isEmpty()) { // 3awz alert hna yzhr y2olo d5l name el awl mysbsh el field fady  <====================== Ferooo

            // NameLabel.setText("Please enter a name.");
            NameEmptyAlert();

        } else if (PersonManagment.GetPlayingPerson() == null) {
            NameLabel.setText("Welcome, " + name); // b set el label bta3y b esm eld5lo el user
            Person person = new Person(name); // b create l object mn no3 person b esm eld5lto
            PersonManagment.GetAllPersons().add(person); // b add el person dh ll array bta3 el persons f person managment
            PersonManagment.SetplayingPerson(person); // b set b2a el playing person el3ndy blna lsa md5lo dh 

            HelpersController.SwitchToLevelScene(event); // to switch to levelScene
        }
    }

    //=====================================================
    // Alert if the name field is empty

    private void NameEmptyAlert()
    {
        try {
            
            FXMLLoader loaderr = new FXMLLoader(getClass().getResource("../view/ErrorAlert.fxml"));
            Parent roott = loaderr.load();

            ErrorAlertController alertController = loaderr.getController();

            Stage stagee = new Stage();
            stagee.initModality(Modality.APPLICATION_MODAL);
            stagee.initStyle(StageStyle.UNDECORATED);
            alertController.setStage(stagee);

            stagee.setScene(new Scene(roott));
            stagee.setResizable(false);
            stagee.setX(stage.getX() + (790/4d));
            stagee.setY(stage.getY() + (450/4d));

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.5);
            stage.getScene().getRoot().setEffect(colorAdjust);

            stagee.setOnHidden(e -> stage.getScene().getRoot().setEffect(null));

            stagee.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //============================================
    public void setStage(Stage stagee)
    {
        this.stage = stagee;
    }

    //=================================================================
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HomePageButton.setOnAction(e -> {
            try {
                HelpersController.SwitchToHomeScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
            TextNameArea.setPromptText("Enter Your Name Here ");
    }
}
