package src.main.myapp.model;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    
    
    private static int idcounter=0;

    StringProperty Name;
    
    IntegerProperty Score;
    
    int maxLvl;

    private  ArrayList<Level> PersonLevelsArray = new ArrayList<>();

    public Person(String name){
        this.Name = new SimpleStringProperty(name + (++idcounter));
        this.Score = new SimpleIntegerProperty(0);
    }

 // Getters

    public String GetPersonName(){
        return Name.get();
    }

    public int GetPersonScore(){
        return Score.get();
    }

    public int GetPersonMaxLevel(){
        return this.maxLvl;
    }

    public StringProperty NameProperty(){
        return Name;
    }

    public IntegerProperty ScoreProperty(){
        return Score;
    }

 // Setters

    public void SetPersonScore(int score){
        this.Score.set(score);;
    }

    public void SetPersonMaxLevel(int maxlvl){
        this.maxLvl = maxlvl;
    }

    public ArrayList<Level> GetAllPersonLevels()
    {
        return this.PersonLevelsArray;
    }

}
