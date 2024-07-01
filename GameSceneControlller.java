

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameSceneControlller {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

        
    //========================================================
private static MediaPlayer MediaPlayer;

    // Method to receive MediaPlayer from SceneController
    public static void initData(MediaPlayer mediaPlayer) {
        MediaPlayer = mediaPlayer;
        // Now you can use mediaPlayer as needed
    }


    // Example method to pause the music
    public void pauseMusic() {
        
    }

    // Example method to resume the music
    public void resumeMusic() {
        
    }
    //=======================================================
    //Back to home Scene Button 
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//============================================================

    // New Game Scene 

    public void SwitchtoNewGameScene(ActionEvent e)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./NewGameScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        MediaPlayer.pause();
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
}
