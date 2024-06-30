
import java.io.IOException;
import java.util.Random;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneController {

    @FXML
    private Label TitleField;
    @FXML
    private Label Ztitle;
    @FXML
    private Label FTitle;
    
   
    @FXML
    private AnchorPane homeback;
    
    private Stage stage ;
    private Scene scene;
    private Parent root;


    Random random = new Random();

    // array of the fruits image
    Image[] fruitimages = {
        new Image(getClass().getResourceAsStream("images/fruits/apple.png")),
        new Image(getClass().getResourceAsStream("images/fruits/banana.png")),
        new Image(getClass().getResourceAsStream("images/fruits/bomb.png")),
        new Image(getClass().getResourceAsStream("images/fruits/kiwi.png")),
        new Image(getClass().getResourceAsStream("images/fruits/orange.png")),
        new Image(getClass().getResourceAsStream("images/fruits/redGrapes.png")),
    };


//========================================================== 
    
    // Load Game Scene
    
    public void SwitchTGameScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
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

    public void initialize() {
        
        

        try {

            generateFruitImages(10); // to generate 8 fruit image 
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), TitleField);
            scaleTransition.setFromX(1.0);
            scaleTransition.setFromY(1.0);
            scaleTransition.setToX(1.4);
            scaleTransition.setToY(1.4);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);

            //For F Letter
            // Create the TranslateTransition
            TranslateTransition ftranslateTransition = new TranslateTransition(Duration.millis(1600), FTitle);
            ftranslateTransition.setFromX(-100); // Starting from 100 pixels to the left
            ftranslateTransition.setToX(0); // Moving to the original position
            // Start the animation when the Label is clicked

            //For Z Letter
            TranslateTransition ZTranslateTransition = new TranslateTransition(Duration.millis(1700),Ztitle);
            ZTranslateTransition.setFromY(-100);
            ZTranslateTransition.setToY(0);

            scaleTransition.playFromStart();
            ftranslateTransition.playFromStart();
            ZTranslateTransition.playFromStart();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
