import java.io.IOException;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HowToPlayController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView apple;

    @FXML
    private ImageView banana;

    @FXML
    private ImageView bomb;

    @FXML
    private ImageView greeng;

    @FXML
    private ImageView kiwi;

    @FXML
    private ImageView orange;

    @FXML
    private ImageView redgrappes;

    @FXML
    private ImageView wm;
    
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        PersonManagment.SetplayingPerson(null);
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        applyTransitions(apple);
        applyTransitions(banana);
        applyTransitions(bomb);
        applyTransitions(greeng);
        applyTransitions(kiwi);
        applyTransitions(orange);
        applyTransitions(redgrappes);
        applyTransitions(wm);
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
}
