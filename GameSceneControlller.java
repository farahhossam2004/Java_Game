import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class GameSceneControlller {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

     // video background
    @FXML
    private MediaView ChooseGameMedia;

    public void initialize() {

        try {
            String videoPath = "./Images/withouttext.mp4";

            Media media = new Media(new File(videoPath).toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            
            ChooseGameMedia.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //========================================================

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
