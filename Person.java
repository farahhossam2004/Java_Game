import java.util.ArrayList;

public class Person {
    
    
    private static int idcounter=0;

    String Name;
    
    int Score = 0 ;
    
    int maxLvl;

    private  ArrayList<Level> PersonLevelsArray = new ArrayList<>();

    Person(String name){
        this.Name=name+(++idcounter);
    }

 // Getters

    public String GetPersonName(){
        return this.Name;
    }

    public int GetPersonScore(){
        return this.Score;
    }

    public int GetPersonMaxLevel(){
        return this.maxLvl;
    }

    

 // Setters

    public void SetPersonScore(int score){
        this.Score=score;
    }

    public void SetPersonMaxLevel(int maxlvl){
        this.maxLvl = maxlvl;
    }

    public ArrayList<Level> GetAllPersonLevels()
    {
        return this.PersonLevelsArray;
    }

}
