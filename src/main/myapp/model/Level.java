package src.main.myapp.model;
public class Level {
    
    private final int id ;

    int LevelScore;


    public Level(int lvlscore , int id ){
        this.id=id;
        this.LevelScore=lvlscore;
    }

    public Level(int id ){
        this.id = id;
    }

    public int GetLevelID(){
        return this.id;
    }
    
    public int GetLevelScore(){
        return this.LevelScore;
    }


    public void setLevelScore(int score){
        this.LevelScore = score;
    }

}
