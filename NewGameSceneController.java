import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class NewGameSceneController {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

     // video background
    @FXML
    private MediaView mediaview;

    @FXML
    private Button DoneButton;

    @FXML
    private TextField TextNameArea;
    
    @FXML
    private Label NameLabel;

    String name;

    public void initialize() {
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


//=================================================

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

    
    public void Submit(ActionEvent event) throws IOException {
        name = TextNameArea.getText().trim(); // Trim 3shan a remove el white spaces
    
        if (name.isEmpty()) { // 3awz alert hna yzhr y2olo d5l name el awl mysbsh el field fady  <====================== Ferooo

            NameLabel.setText("Please enter a name.");

        } else if (PersonManagment.GetPlayingPerson() == null) {
            NameLabel.setText("Welcome, " + name); // b set el label bta3y b esm eld5lo el user
            Person person = new Person(name); // b create l object mn no3 person b esm eld5lto
            PersonManagment.GetAllPersons().add(person); // b add el person dh ll array bta3 el persons f person managment
            PersonManagment.SetplayingPerson(person); // b set b2a el playing person el3ndy blna lsa md5lo dh 

            root = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
