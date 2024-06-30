import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LoadGameController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Person, String> NameColumn;

    @FXML
    private Button back;

    @FXML
    private Button levels;

    @FXML
    private TableColumn<Person, Integer> scoreColumn;

    @FXML
    private TableView<Person> tableview;

    //=================================================

    @FXML
    public void initialize()
    {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
    
        tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);;

        ObservableList<Person> persons = FXCollections.observableArrayList(PersonManagment.GetAllPersons());

        tableview.setItems(persons);
    }


    //=================================================

    //Back to home Scene Button 
    public void SwitchToHomeScene(ActionEvent e)throws IOException{
        PersonManagment.SetplayingPerson(null);
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //====================================================

    // Select a person from the table 
    public void SelectPerson(ActionEvent e) throws IOException {
        Person selectedPlayer = tableview.getSelectionModel().getSelectedItem();

        if(selectedPlayer != null)
        {
            PersonManagment.SetplayingPerson(selectedPlayer);
            System.out.println("Selected player: " + selectedPlayer.GetPersonName());
            SwitchToLevelScene(e);
        }
        else {
            System.out.println("No player selected");
        }
    }

    //=========================================

    // Switch to levels Scene
    
    private void SwitchToLevelScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
