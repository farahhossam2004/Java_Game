import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class LevelSceneController {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

     // video background
    @FXML
    private MediaView mediaview;

    @FXML
    private Label NameLabel;

    @FXML
    private Label score;


    public void initialize() {
        
        NameLabel.setText(PersonManagment.GetPlayingPerson().GetPersonName()); // b set el label bta3y b esm el playng player
        score.setText(String.valueOf(PersonManagment.GetPlayingPerson().GetPersonScore()));
        try {
            String videoPath = "./Images/withouttext.mp4";

            Media media = new Media(new File(videoPath).toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            
            mediaview.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //========================================================

    //Back to home Scene Button 
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        PersonManagment.SetplayingPerson(null);
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //============================================================
    // button to level 1 scene

    public void SwitchToLevel1Scene(ActionEvent e)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Level1.fxml"));
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Level1Controller controller = loader.getController();
        controller.setStage(stage);
        
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //=====================================================
    // button to level 2 scene 
    public void SwitchToLevel2Scene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Level2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Level2Controller.setStage(stage);
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //===========================================================
    // button to level 3 scene 
    public void SwitchToLevel3Scene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Level3.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Level3Controller.setStage(stage);
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //===========================================================
    // button to level 4 scene 
    public void SwitchToLevel4Scene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Level4.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Level4Controller.setStage(stage);
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //===========================================================
    // button to level 5 scene 
    public void SwitchToLevel5Scene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Level5.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
