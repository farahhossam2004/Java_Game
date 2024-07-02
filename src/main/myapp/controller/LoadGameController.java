package src.main.myapp.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.main.myapp.model.Person;
import src.main.myapp.model.PersonManagment;


public class LoadGameController implements Initializable{
    
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


    //====================================================

    // Select a person from the table 
    public void SelectPerson(ActionEvent e) throws IOException {
        Person selectedPlayer = tableview.getSelectionModel().getSelectedItem();

        if(selectedPlayer != null)
        {
            PersonManagment.SetplayingPerson(selectedPlayer);
            System.out.println("Selected player: " + selectedPlayer.GetPersonName());
            
            HelpersController.SwitchToLevelScene(e);
        }
        else {
            System.out.println("No player selected");
        }
    }

    //=========================================


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Home Page Button
        back.setOnAction(e -> {
            try {
                HelpersController.SwitchToHomeScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
//=================================================================

        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
    
        tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);;

        ObservableList<Person> persons = FXCollections.observableArrayList(PersonManagment.GetAllPersons());

        tableview.setItems(persons);
    }


}
