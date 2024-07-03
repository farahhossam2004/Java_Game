package src.main.myapp;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.main.myapp.model.DataManager;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        try {
        DataManager.ReadFile();
        Parent root = FXMLLoader.load(getClass().getResource("./view/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("FruitZ");
        stage.setOnCloseRequest(event -> {DataManager.writeFileData();});
        stage.show();

        // styling css
        String css = this.getClass().getResource("../resources/css/Styling.css").toExternalForm();
        scene.getStylesheets().add(css);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
