package src.main.myapp.model;
import java.util.ArrayList;

public class LevelManagment {
    
    private static ArrayList<Level> LevelsArray = new ArrayList<>();

    public static int AddLevel(int id , int score){
        GetAllLevels().add(new Level(score,id));
        return 1;
    }

    public static Level SearchLevel(int id){
        for (Level level : GetAllLevels()) {
            if(level.GetLevelID() == id){
                return level;
        }
    }
                return null;
    }

    
    public static ArrayList<Level> GetAllLevels()
    {
        return LevelsArray;
    }
}
