public class Level {
    
    private final int id ;

    private static int LevelsCounter = 0 ; 

    int LevelTime;

    int LevelScore;

    Person CurrentPerson;


    Level(int lvltime,int lvlscore){
        this.id=++LevelsCounter;
        this.LevelScore=lvlscore;
        this.LevelTime=lvltime;
    }

    public int GetLevelID(){
        return this.id;
    }
    
    public int GetLevelScore(){
        return this.LevelScore;
    }

    public int GetLevelTime(){
        return this.LevelTime;
    }

    public Person GetCurrPerson(){
        return this.CurrentPerson;
    }
    
    public void SetCurrentPerson(Person Person){
        this.CurrentPerson=Person;
    }

}
