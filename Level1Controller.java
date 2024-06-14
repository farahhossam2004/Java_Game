import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Level1Controller implements Initializable {

    Time time = new Time(2,00);

    @FXML
    private Text timer;

    Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1),
            e -> {
                if(time.getLevelTime().equals("0:0")){
                    System.out.println("Level End!");
                }
                time.oneSecondPassed();
                timer.setText(time.getLevelTime());
            } 
    ));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        timer.setText(time.getLevelTime());

        timeline.setCycleCount((time.getMin() * 60) + time.getSec());
        timeline.play();
    }

}