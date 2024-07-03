package src.main.myapp.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import src.main.myapp.model.Fruit;
import src.main.myapp.model.Level;
import src.main.myapp.model.PersonManagment;
import src.main.myapp.model.Time;

public class Level3Controller implements Initializable {
    
    Time time = new Time(0,30);
    
    int levelScore = 80;
    int UserScore = 0 ; 
    
//===========================================================
// Fxml Components
    @FXML
    private Text score;

    @FXML
    private Text timer;

    @FXML
    private AnchorPane imageContainer;

    @FXML
    private Text Level3Score;

    @FXML
    private Button BackToLevels;

    @FXML
    private Text LevelNumber;

    @FXML
    private ImageView Clockimage;


//===============================================================
    // Load the sound effect
    AudioClip sound = new AudioClip(getClass().getResource("../../resources/Sound/SwordSound.mp3").toString());
    AudioClip BombSound = new AudioClip(getClass().getResource("../../resources/Sound/Bomb.mp3").toString());
//=================================================================
    // List of fruit only without bomb 
    private List<ImageView> FruitImages = new ArrayList<>();

    //==================================================================================
    // back button 

    private static Stage stage;
    private Scene scene;
    private Parent root;

    public static void setStage(Stage stagee) {
        stage = stagee;
    }
    

    //====================================================================================
    // random class to generate fruit in random places 
    Random random = new Random();

    // array of the fruits image
    Image[] fruitimages = {
        new Image(getClass().getResourceAsStream("../../resources/Images/fruits/watermelon.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/fruits/banana.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/fruits/kiwi.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/fruits/orange.png")),
    };

    // Array of sliced fruits of level 2 
    Image[] SlicedFruitimages = {
        new Image(getClass().getResourceAsStream("../../resources/Images/sliced_fruit/watermelon.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/sliced_fruit/banana.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/sliced_fruit/kiwi.png")),
        new Image(getClass().getResourceAsStream("../../resources/Images/sliced_fruit/orange.png")),
    };

    // Array of image of bomb 
    Image[] Bombimages = {
        new Image(getClass().getResourceAsStream("../../resources/Images/fruits/bomb.png")),
    };

    // Array of sliced Bomb Image 
    Image[] SlicedBombimages = {
        new Image(getClass().getResourceAsStream("../../resources/Images/sliced_fruit/bomb.png")),
    };

    //=================================================================================
    // initialize method
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), LevelNumber);
            scaleTransition.setFromX(1.0);
            scaleTransition.setFromY(1.0);
            scaleTransition.setToX(1.6);
            scaleTransition.setToY(1.4);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);

            ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(2000), Clockimage);
            scaleTransition2.setFromX(1.0);
            scaleTransition2.setFromY(1.0);
            scaleTransition2.setToX(1.2);
            scaleTransition2.setToY(1.2);
            scaleTransition2.setCycleCount(ScaleTransition.INDEFINITE);
            scaleTransition2.setAutoReverse(true);

            scaleTransition2.playFromStart();
            scaleTransition.playFromStart();

        BackToLevels.setOnAction(e -> {
            try {
                HelpersController.back(e);
                timeline.stop();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        MusicControllerMedia.pauseMedia();
        timer.setText(time.getLevelTime());
        timeline.setCycleCount((time.getMin() * 60) + time.getSec());
        timeline.play();
        
        Level3Score.setText(String.valueOf(levelScore));
        generateFruitImages(20); // =====================================================> btt3dl  
        generateBombImages(6); // deh elzodtha
    }
//=======================================================================================

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
            imageView.setX(random.nextInt(572) + 94); // Generate x position from 94 to 665
            imageView.setY(447); // Adjust for image height
//=========================
            // Add a custom property to track if the image has been clicked
            BooleanProperty isClicked = new SimpleBooleanProperty(false);

            // to change the image of fruit into sliced one and fade in case of mouse clicking 
            imageView.setOnMouseExited(event -> {
                if (!isClicked.get()) {
                    sound.play();
                    isClicked.set(true);

                imageView.setImage(SlicedFruitimages[index]);
                FadeTransition fade = new FadeTransition();
                fade.setNode(imageView);
                fade.setDuration(Duration.millis(500));
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setOnFinished(fadeFinishedEvent -> {
                    imageContainer.getChildren().remove(imageView);

                    FruitImages.remove(imageView); // to remove the fruit from the array of fruit 
                    
                    if(FruitImages.isEmpty()){ // if the array empty and no fruit image left
                        if(UserScore>=levelScore)
                            LevelPassed(); //================================> alrtat hnaaa
                        else
                            LevelFailed(); // ===================================> alertat hnnaaaa
                    
                    timeline.stop();
                    }
                });
                fade.play(); //fade the clicked image
//==========================
                // to calculate your score and from sliced image index will calculate it WaterMelon 0 banana 1  kiwi 2 orange 3
                // index based on the array of images to get the score u need from the fruit class
                switch (index) {
                    case 0:
                        UserScore = UserScore+Fruit.GetWaterMelonScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 1:
                        UserScore = UserScore+Fruit.GetbananaScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 2:
                        UserScore = UserScore+Fruit.GetKiwiScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    case 3 : 
                        UserScore = UserScore + Fruit.GetOrangeScore();
                        score.setText(String.valueOf(UserScore));
                        break;
                    default:
                        break;
                }
            }
            });
//============================
            //add the image to the anchor pane and the list of images
            imageContainer.getChildren().add(imageView);
            FruitImages.add(imageView); //==> to add the fruit to an array 
//=========================== 
            // Apply transitions
            applyTransitions(imageView, i * 1000); // Adding a delay based on the index
        }
    }

//=====================================================================================================

// function to generate number of bombs 
// generate method to generate random images of fruits 
private void generateBombImages(int numberOfImages) {
    for (int i = 0; i < numberOfImages; i++) {
//=======================
        ImageView imageView = new ImageView(); //create new imagevie object anf set it randomlly
        imageView.setImage(Bombimages[0]);
//=======================
        // Set smaller size for each image
        imageView.setFitWidth(80); // Set width to 50 pixels
        imageView.setFitHeight(80); // Set height to 50 pixels
//========================
        // Set random position for each image
        imageView.setX(random.nextInt(572) + 94); // Generate x position from 94 to 665
        imageView.setY(447); // Adjust for image height
//=========================
         // Add a custom property to track if the image has been clicked
            BooleanProperty isClicked = new SimpleBooleanProperty(false);

        // to change the image of fruit into sliced one and fade in case of mouse clicking 
        imageView.setOnMouseExited(event -> {
            if(!isClicked.get()){
            BombSound.play();
            isClicked.set(true);
            imageView.setImage(SlicedBombimages[0]);
            FadeTransition fade = new FadeTransition();
            fade.setNode(imageView);
            fade.setDuration(Duration.millis(500));
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.setOnFinished(fadeFinishedEvent -> {
                imageContainer.getChildren().remove(imageView);
            });
            fade.play(); //fade the clicked image
//==========================
            // to calculate your score and from sliced image index will calculate it apple 0 banana 1  kiwi 2 orange 3
            // index based on the array of images to get the score u need from the fruit class
            UserScore =UserScore+Fruit.GetBombScore();
            if(UserScore<0) // to check if the result is negative 
                UserScore=0; // retart the score
            score.setText(String.valueOf(UserScore));
        }
        });
//============================
        //add the image to the anchor pane and the list of images
        imageContainer.getChildren().add(imageView);
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
        int maxWidth = (int) imageContainer.getPrefWidth();
        int maxHeight = (int) imageContainer.getPrefHeight();

        rotate.setNode(imageView);
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(2800));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        
        // Check the x position and set the direction of movement
        if (imageView.getX() > 364) {
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

//=================================================================================
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1),
            e -> {
                time.oneSecondPassed();
                timer.setText(time.getLevelTime());
                if(time.getLevelTime().equals("0:0")){
                    // if user passed the level
                    if(UserScore >= levelScore)
                    {
                        LevelPassed();
                    }
                    // else failed
                    else{
                        LevelFailed();
                    }
                }
            } 
    ));

    //=========================================
    
    // Level Passed Alert 

    public void LevelPassedAlert(Consumer<ActionEvent> action, Consumer <ActionEvent> action2)
    {
        try {
            FXMLLoader loaderr = new FXMLLoader(getClass().getResource("../view/PassAlert.fxml"));
            Parent roott = loaderr.load();
            

            PassAlertController alertController = loaderr.getController();
            alertController.setButtonAction(action); //set next level butoon action as it differs from class to class
            alertController.setBackAction(action2);  // set back button action
            
            Stage stagee = new Stage();  // new stage for the alert 
            stagee.initModality(Modality.APPLICATION_MODAL); // deh 3shan akhly lma l alert yzhr l user my2drsh ydos 3la ay scene tany 8er lma l alert y2fl 
            // 3shan agbro ydos 3l yama next level yama back 
            stagee.initStyle(StageStyle.UNDECORATED); // hide the title bar
            alertController.setStage(stagee); // b3ml set ll stage 3shan fl class l hnak 2a2dr a2olo y2fl l alert lma ndos 3l button

            stagee.setScene(new Scene(roott));
            stagee.setResizable(false);
            stagee.setX(500);
            stagee.setY(250);

            // 3shan lma yzhr l alert akhly l scene bta3t l level l warah tb2a faded keda y3ne l brightness bta3taha watya 
            ColorAdjust colorAdjust = new ColorAdjust(); 
            colorAdjust.setBrightness(-0.5);
            stage.getScene().getRoot().setEffect(colorAdjust);

            // lma l alert y2fl l brightness bta3t l level scene trg3 zy ma kant
            stagee.setOnHidden(e -> stage.getScene().getRoot().setEffect(null));

            stagee.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //==========================================

    // Level Passed Function 

    private void LevelPassed()
    {
        Level level = new Level(UserScore, 3);

        //========================
        PersonManagment.addormodifyLevel(PersonManagment.GetPlayingPerson(), level);
        PersonManagment.CalculateScore(PersonManagment.GetPlayingPerson());
        //========================
        
        LevelPassedAlert(t -> {
            try {
                SwitchToLevel4Scene(t);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }, t -> {try {
            HelpersController.back(t);
        } catch (IOException e1) {
            e1.printStackTrace();
        }});
    }

    //==========================================
    

    // Level Failed 

    private void LevelFailed(){
        LevelFailedAlert(t -> {
            try {
                TryAgainLevel3(t);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }, t -> {
            try {
                HelpersController.back(t);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        });
    }
    
    // Level Failed Alert 
    
    public void LevelFailedAlert(Consumer<ActionEvent> action, Consumer<ActionEvent> action2)
    {
        try {
            FXMLLoader loaderr = new FXMLLoader(getClass().getResource("../view/FailAlert.fxml"));
            Parent roott = loaderr.load();
            
            FailAlertController failAlert = loaderr.getController();
            failAlert.setTryAgainAction(action);  // set Try again button action bec it differs from class to class 
            failAlert.setBackAction(action2);  // set back button action
            
            Stage stagee = new Stage();
            stagee.initModality(Modality.APPLICATION_MODAL);
            stagee.initStyle(StageStyle.UNDECORATED);
            failAlert.setStage(stagee);
            
            stagee.setScene(new Scene(roott));
            stagee.setResizable(false);
            stagee.setX(500);
            stagee.setY(250);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.5);
            stage.getScene().getRoot().setEffect(colorAdjust);

            stagee.setOnHidden(e -> stage.getScene().getRoot().setEffect(null));

            stagee.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //==================================================

    // Switch to Level 4

    public void SwitchToLevel4Scene(ActionEvent e)throws IOException{

        Level4Controller.setStage(stage);
        root = FXMLLoader.load(getClass().getResource("../view/Level4.fxml"));
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //=====================================================

    // Try Again Level 3

    public void TryAgainLevel3(ActionEvent e)throws IOException{

        root = FXMLLoader.load(getClass().getResource("../view/Level3.fxml"));
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
