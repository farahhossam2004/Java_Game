package src.main.myapp.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.main.myapp.model.PersonManagment;

public class HelpersController {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    //=======================================================
    //Back to home Scene Button 
    public static void SwitchToHomeScene(ActionEvent e) throws IOException {
        PersonManagment.SetplayingPerson(null);
        root = FXMLLoader.load(HelpersController.class.getResource("../view/Main.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void SwitchToLevelScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(HelpersController.class.getResource("../view/LevelScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void back(ActionEvent e) throws IOException {
        
        if(SettingsController.GetCheckBoxStatue()) //====> For Music
            MusicControllerMedia.playMedia();
            
        root = FXMLLoader.load(HelpersController.class.getResource("../view/LevelScene.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

