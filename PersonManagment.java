import java.util.ArrayList;

public class PersonManagment {
    
    private static ArrayList<Person> PersonArray = new ArrayList<>();

    
    public static int addPerson(String name){
        GetAllPersons().add(new Person(name));
        return 1;
    } 

    public static Person SearchPerson(String name){
        for (int i = 0 ; i<GetAllPersons().size();i++){
            if(GetAllPersons().get(i).GetPersonName()==name)
                // hnzod Currenrtperson = GetAllPerson.get(i)
                return GetAllPersons().get(i);
        }
        return null;
    }  

    public static void CalculateScore(){} // void -> int lsa msh 3aref hn3mlha ezay


    public static ArrayList<Person> GetAllPersons()
    {
        return PersonArray;
    }

}
