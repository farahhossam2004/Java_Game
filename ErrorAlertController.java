import java.util.function.Consumer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ErrorAlertController {
    
    private Stage stage;
    private Consumer<ActionEvent> closeAlertFunction;

    public void setStage(Stage stagee)
    {
        this.stage = stagee;
    }

    public void setcloseAlert(Consumer<ActionEvent> event){
        this.closeAlertFunction = event;
    }

    @FXML
    private void closeAlert()
    {
        stage.close();
    }
}
