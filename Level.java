public class Level {
    
    private final int id ;

    int LevelScore;


    Level(int lvlscore , int id ){
        this.id=id;
        this.LevelScore=lvlscore;
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
