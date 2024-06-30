
import java.io.IOException;
import java.util.Random;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LevelSceneController {
    
    private Stage stage ;
    private Scene scene;
    private Parent root;

    Random random = new Random();

    Image[] fruitimages = {
        new Image(getClass().getResourceAsStream("images/fruits/apple.png")),
        new Image(getClass().getResourceAsStream("images/fruits/banana.png")),
        new Image(getClass().getResourceAsStream("images/fruits/kiwi.png")),
        new Image(getClass().getResourceAsStream("images/fruits/orange.png")),
        new Image(getClass().getResourceAsStream("images/fruits/greenGrapes.png")),
    };


    @FXML
    private AnchorPane homeback;

    @FXML
    private Label NameLabel;

    @FXML
    private Label score;

    @FXML
    private ProgressBar LevelsProgressbar;

    @FXML
    private Label Percentage;


    double personProgrss = PersonManagment.PersonProgress(PersonManagment.GetPlayingPerson(),5);

    public void initialize() {

        try {
            generateFruitImages(9);

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

        Level1Controller.setStage(stage);
        
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
        Level5Controller.setStage(stage);
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

     // generate method to generate random images of fruits 
    private void generateFruitImages(int numberOfImages) {
        for (int i = 0; i < numberOfImages; i++) {
//=======================
            ImageView imageView = new ImageView(); //create new imagevie object anf set it randomlly
            int index = random.nextInt(fruitimages.length);
            imageView.setImage(fruitimages[index]);
//=======================
            // Set smaller size for each image
            imageView.setFitWidth(80); // Set width to 50 pixels
            imageView.setFitHeight(80); // Set height to 50 pixels
//========================
            // Set random position for each image
            imageView.setX(random.nextInt(362) + 132); // Adjust for image width
            imageView.setY(447); // Adjust for image height
            //============================
            //add the image to the anchor pane and the list of images
            homeback.getChildren().add(1, imageView);

//=========================== 
            // Apply transitions
            applyTransitions(imageView, i * 1000); // Adding a delay based on the index
        }
    }

    //==========================================================================
    private void applyTransitions(ImageView imageView, int delay) {
        RotateTransition rotate = new RotateTransition();
        TranslateTransition transition = new TranslateTransition();
        
        // Adjusting transition settings based on AnchorPane dimensions
        int maxWidth = (int) homeback.getPrefWidth();
        int maxHeight = (int) homeback.getPrefHeight();

        rotate.setNode(imageView);
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(3000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        
        // Check the x position and set the direction of movement
        if (imageView.getX() > 323) {
            // Move to the left side
            transition.setByX(-random.nextInt(maxWidth / 2) - maxWidth / 3);
        } else {
            // Move to the right side
            transition.setByX(random.nextInt(maxWidth / 2) + maxWidth / 3);
        }
        
        transition.setByY(-random.nextInt(maxHeight / 2) - maxHeight);
        transition.setAutoReverse(true);
        transition.setDelay(Duration.millis(delay));

        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setDelay(Duration.millis(delay));
        
        rotate.play();
        transition.play();

    }
}
