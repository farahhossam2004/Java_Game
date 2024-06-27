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

    public static void CalculateScore(){} // void -> int lsa msh 3aref hn3mlha ezay

    public static ArrayList<Person> GetAllPersons() {
        return PersonArray;
    }
}

