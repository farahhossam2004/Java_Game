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

public class SceneController {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;


//========================================================== 
    
    // Load Game Scene
    
    public void SwitchTGameScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // // New Game Scene 

    // public void SwitchtoNewGameScene(ActionEvent e)throws IOException{
    //     root = FXMLLoader.load(getClass().getResource("NewGameScene.fxml"));
    //     stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    //     scene= new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    // //Load A Game Scene 

    // public void SwitchtoLoadGameScene(ActionEvent e)throws IOException{
    //     root = FXMLLoader.load(getClass().getResource(""));
    //     stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    //     scene= new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();
    // }

//===========================================================================

    // Go To Level Scene
    public void SwitchtoLevelScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//=================================================

    //Switch to Score Scene ====> Score button

    public void SwitchtoScoreScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource(""));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//==================================================

    //Switch to Settings Scene ====> Setting button 

    public void SwitchtoSettingsScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource(""));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//===================================================

    //Switch to Credit Scene ====> Credit Button

    public void SwitchtoCreditScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource(""));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    // video background
    @FXML
    private MediaView mediaview;

    public void initialize() {

        try {
            String videoPath = "./Images/first.mp4";
            String videoPath2 = "./Images/last.mp4";

            Media media = new Media(new File(videoPath).toURI().toString());
            Media media2 = new Media(new File(videoPath2).toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);

            mediaPlayer.setCycleCount(1);
            mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
            
            mediaPlayer.setOnEndOfMedia(() -> 
            {
                mediaPlayer.dispose();
                mediaview.setMediaPlayer(mediaPlayer2);
                mediaPlayer2.play();

            });
            
            mediaview.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
