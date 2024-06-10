public class Person {
    
    String Name;
    
    int Score;
    
    int maxLvl;

    Person(String name){
        this.Name=name;
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

}
