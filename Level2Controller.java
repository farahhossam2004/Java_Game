import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level2Controller implements Initializable {

    @FXML
    private ImageView FruitImage;

    private Stage stage ;
    private Scene scene;
    private Parent root;
    
    @FXML
    void back(ActionEvent e)throws IOException {
        root = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    Random random = new Random();

    int x;
    // Array of fruits of level 2
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

    @FXML
    void Mouseclicked(MouseEvent event) {
    
        FruitImage.setImage(SlicedFruitimages[x]);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Select a random image from the fruit images array for initial display
        int index = random.nextInt(fruitimages.length);
        x =index;
        FruitImage.setImage(fruitimages[index]);

        RotateTransition rotate = new RotateTransition();
        TranslateTransition transition = new TranslateTransition();
        rotate.setNode(FruitImage);
        transition.setNode(FruitImage);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setByX(250);
        transition.setByY(-300);
        transition.setAutoReverse(true);

        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();
        transition.play();
    }


    

}

