package src.main.myapp.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FDataManager {

    private static final String PlayersDataFilePath = "src/main/resources/data/PlayersData.txt";
    
    private static File datafile = new File(PlayersDataFilePath);
    
    
    public static void ReadFile(){
        try {
            FileReader file = new FileReader(datafile);
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

                    System.out.println(player);
                    String playerData[] = player.split("-");

                    Person person = new Person(playerData[0], Integer.parseInt(playerData[1]));
                    PersonManagment.GetAllPersons().add(person);

                    for(int i = 2; i < playerData.length; i++){
                        Level lvl = new Level(Integer.parseInt(playerData[i]));
                        person.GetAllPersonLevels().add(lvl);
                    }
                }
            }
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        // System.out.println("Cuurent working directory: " + System.getProperty("user.dir"));
        FDataManager.ReadFile();
        for(Person p : PersonManagment.GetAllPersons())
        {
            
            System.out.println("person  " + p.GetPersonName() + "  "+ p.GetPersonScore());
            for(Level lvl : p.GetAllPersonLevels())
            {
                System.out.println(lvl.GetLevelID());
            }
        }

    }
    
}
