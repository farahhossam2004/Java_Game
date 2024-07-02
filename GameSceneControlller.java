
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameSceneControlller implements Initializable {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

    @FXML
    private Button HomePageButton;


//============================================================

    // New Game Scene 

    public void SwitchtoNewGameScene(ActionEvent e)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./NewGameScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        NewGameSceneController controller = loader.getController();
        controller.setStage(stage);
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Load A Game Scene 

    public void SwitchtoLoadGameScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("./LoadGame.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HomePageButton.setOnAction(e -> {
            try {
                HelpersController.SwitchToHomeScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
