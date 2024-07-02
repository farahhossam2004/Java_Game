import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HowToPlayController implements Initializable {

    @FXML
    private Button HomePageButton;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        applyTransitions(apple);
        applyTransitions(banana);
        applyTransitions(bomb);
        applyTransitions(greeng);
        applyTransitions(kiwi);
        applyTransitions(orange);
        applyTransitions(redgrappes);
        applyTransitions(wm);


        //Switch to homebutton
        HomePageButton.setOnAction(e -> {
            try {
                HelpersController.SwitchToHomeScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
}
