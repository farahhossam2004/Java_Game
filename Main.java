import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); // test
        Scene scene = new Scene(root);
        
        // styling css
        String css = this.getClass().getResource("Styling.css").toExternalForm();

        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
