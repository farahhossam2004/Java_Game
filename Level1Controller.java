import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level1Controller implements Initializable {

    Time time = new Time(0,5);
    
    Level level = new Level(1, 0);

    int UserScore = 0 ; 

    @FXML
    private Text score;

    @FXML
    private Text timer;

    @FXML
    private AnchorPane imageContainer;

    
    
    //==================================================================================
    // back button 

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    void back(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //====================================================================================
    // random class to generate fruit in random places 
    Random random = new Random();

    // array of the fruits image
    Image[] fruitimages = {
        new Image(getClass().getResourceAsStream("images/fruits/apple.png")),
        new Image(getClass().getResourceAsStream("images/fruits/banana.png")),
        new Image(getClass().getResourceAsStream("images/fruits/bomb.png")),
        new Image(getClass().getResourceAsStream("images/fruits/kiwi.png")),
    };

    // Array of sliced fruits of level 2 
    Image[] SlicedFruitimages = {
        new Image(getClass().getResourceAsStream("images/sliced_fruit/apple.png")),
        new Image(getClass().getResourceAsStream("images/sliced_fruit/banana.png")),
        new Image(getClass().getResourceAsStream("images/sliced_fruit/bomb.png")),
        new Image(getClass().getResourceAsStream("images/sliced_fruit/kiwi.png")),
    };

    //=================================================================================
    // initialize method
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timer.setText(time.getLevelTime());
        timeline.setCycleCount((time.getMin() * 60) + time.getSec());
        timeline.play();
        
        generateFruitImages(10); // to generate 10 image 
        
    }
    //=======================================================================================
    // generate method to generate random images of fruits 
    private void generateFruitImages(int numberOfImages) {
        for (int i = 0; i < numberOfImages; i++) {

            ImageView imageView = new ImageView();
            int index = random.nextInt(fruitimages.length);
            imageView.setImage(fruitimages[index]);

            // Set smaller size for each image
            imageView.setFitWidth(80); // Set width to 50 pixels
            imageView.setFitHeight(80); // Set height to 50 pixels

            // Set random position for each image
            imageView.setX(random.nextInt(600) - 37); // Adjust for image width
            imageView.setY(447); // Adjust for image height

            
            // to change the image of fruit into sliced one and fade in case of mouse clicking 
            imageView.setOnMouseClicked(event -> {
                
                imageView.setImage(SlicedFruitimages[index]);
                FadeTransition fade = new FadeTransition();
                fade.setNode(imageView);
                fade.setDuration(Duration.millis(500));
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setOnFinished(fadeFinishedEvent -> {
                    imageContainer.getChildren().remove(imageView);
                });
                fade.play();
        

                // to calculate your score and from sliced image index will calculate it apple 0 banana 1 bomb 2 kiwi 3
                // index based on the array of images to get the score u need from the fruit class 

                switch (index) {
                    case 0:
                        UserScore = UserScore+Fruit.GetAppleScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 1:
                        UserScore = UserScore+Fruit.GetbananaScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 2:
                        UserScore = UserScore+Fruit.GetBombScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 3:
                        UserScore = UserScore+Fruit.GetKiwiScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    default:
                        break;
                }

            });

            imageContainer.getChildren().add(imageView);

            // Apply transitions
            applyTransitions(imageView, i * 500); // Adding a delay based on the index
        }
    }

    private void applyTransitions(ImageView imageView, int delay) {
        RotateTransition rotate = new RotateTransition();
        TranslateTransition transition = new TranslateTransition();
        
        // Adjusting transition settings based on AnchorPane dimensions
        int maxWidth = (int) imageContainer.getPrefWidth();
        int maxHeight = (int) imageContainer.getPrefHeight();

        rotate.setNode(imageView);
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(3000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setByX(random.nextInt(maxWidth + 2 * (maxWidth / 3)) - maxWidth / 3);
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

    Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1),
            e -> {
                time.oneSecondPassed();
                timer.setText(time.getLevelTime());
                if(time.getLevelTime().equals("0:0")){
                    System.out.println("Level End!"); 
                }
            } 
    ));

}