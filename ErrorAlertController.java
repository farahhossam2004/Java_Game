import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ErrorAlertController {
    
    private Stage stage;

    public void setStage(Stage stagee)
    {
        this.stage = stagee;
    }

    @FXML
    private void closeAlert()
    {
        stage.close();
    }
}
