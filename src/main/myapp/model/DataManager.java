package src.main.myapp.model;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {
    
    private static final String PlayersDataFilePath = "src/main/resources/data/PlayersData.txt";
    private static final File FILE = new File(PlayersDataFilePath);


    //===========================================================================
    public static void writeFileData() {
        
        emptyFile(); // to empty the file first 

        for(int i = 0 ; i < PersonManagment.GetAllPersons().size() ; i ++){
            String Data = PersonManagment.GetAllPersons().get(i).GetPersonName() + "-" + PersonManagment.GetAllPersons().get(i).GetPersonScore();
            
            int counter = PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().size(); // counter of the number of element of levels

            for(int j =0 ; j<PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().size();j++ , counter--){
                    if(counter != 1 )
                        Data += "-" + String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelID())+"-"+ String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelScore());
                    else if(counter == 1)
                        Data += "-"+String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelID())+"-"+ String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelScore());
                    else 
                    Data += String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelID())+"-"+ String.valueOf(PersonManagment.GetAllPersons().get(i).GetAllPersonLevels().get(j).GetLevelScore());;
            }

            writeToFile(Data); // write the data 
        }

    }


    //====================================================================

    //===============================================
    // function to empty the file before write again
    public static void emptyFile(){
        try (FileWriter fileWriter = new FileWriter(FILE)) {
            fileWriter.write("");
        } 
        catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    //============================================
    // Function to write the content with the file
    public static String writeToFile(String content) {
        try (FileWriter fileWriter = new FileWriter(FILE, true)) {
            fileWriter.append(content).append("\n");
            return " Done :0 ";
        } catch (IOException e) {
            return "Exception: " + e.getMessage();
        }
    }
//===================================================================================

    // Read the File
    public static void ReadFile(){
        try {
            FileReader file = new FileReader(FILE);
            String x = "";
            int data = file.read();

            while(data != -1){
                x += (char)data;
                data = file.read();
            }
            file.close();
        
            //===================================
            String players[] = x.split("\n");

            for(String player : players){

                player = player.trim();
                if(player.matches("^[a-zA-Z]+\\d+(-\\d+)+$")){

                    String playerData[] = player.split("-");

                    Person person = new Person(playerData[0], Integer.parseInt(playerData[1]));
                    PersonManagment.GetAllPersons().add(person);

                    for(int i = 2; i <= playerData.length/2; i++){
                        Level lvl = new Level(Integer.parseInt(playerData[i+1]), Integer.parseInt(playerData[i]));
                        person.GetAllPersonLevels().add(lvl);
                        i++;
                    }
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
