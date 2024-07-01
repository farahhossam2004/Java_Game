
import java.io.IOException;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreditsController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private VBox creditsContainer;

    @FXML
    private ImageView ch1;

    @FXML
    private ImageView ch2;

    @FXML
    public void initialize() {
        // Set up scrolling animation
        TranslateTransition transition = new TranslateTransition(Duration.seconds(20), creditsContainer);
        transition.setFromY(400); // Start from below the scene
        transition.setToY(-450); // Move up to above the scene
        transition.setCycleCount(TranslateTransition.INDEFINITE); // Repeat indefinitely
        transition.playFromStart();

        applyTransitions(ch1);
        applyTransitions(ch2);
    }

    private void applyTransitions(ImageView img)
    {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), img);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        scaleTransition.playFromStart();
    }

    //Back to home Scene Button 
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
