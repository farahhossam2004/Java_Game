import java.util.ArrayList;

public class PersonManagment {
    
    private static ArrayList<Person> PersonArray = new ArrayList<>();

    static Person playingPerson;

    public static Person GetPlayingPerson(){
        return playingPerson;
    }

    public static void SetplayingPerson(Person person){
        playingPerson = person;
    }

    public static int addPerson(String name){
        GetAllPersons().add(new Person(name));
        System.out.println("\nadded !");
        return 1;
    } 

    //============================================================================
    public static int addormodifyLevel(Person person , Level level){
        
        for(int i = 0 ; i < person.GetAllPersonLevels().size();i++){ // B LOOP 3 el array bta3 lvls bta3 kol person 
            if(person.GetAllPersonLevels().get(i).GetLevelID()==level.GetLevelID()){ // lw l2et en elperson dh la3b el lvl dh 2bl kda 
                if(person.GetAllPersonLevels().get(i).GetLevelScore()>level.GetLevelScore()){ // lw el score el kan gybo 2bl kda a3la msh b3ml 7aga
                    return 1;
                }else{ // lw el score el gded a3la mn el score elkan gybo 2bl kda b3ml set llscore elflarray 
                    person.GetAllPersonLevels().get(i).setLevelScore(level.GetLevelScore());
                    return 1;
                }
            }
        } // lw el person dh ml3bsh asla b def el lvl ll array of levels bta3o 
        person.GetAllPersonLevels().add(level);
        return 1 ; 
    }
//==============================================================
    public static void CalculateScore(Person person){
        int score = 0;
        for(int i = 0 ; i < person.GetAllPersonLevels().size();i++){ // mgrd loop 3larray w b add el score elgaybo fkol lvl lltany w b set elperson score fla5r b kda
            score += person.GetAllPersonLevels().get(i).GetLevelScore();
        }
        person.SetPersonScore(score);;
    } 
//===============================================================
    public static ArrayList<Person> GetAllPersons() {
        return PersonArray;
    }
}

