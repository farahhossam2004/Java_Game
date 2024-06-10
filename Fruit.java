public abstract class Fruit {
    
    String Fruitname;
    
    int FruitScore;

    Fruit(String name){
        this.Fruitname = name ;
    }

    public String GetFruitname(){
        return this.Fruitname;
    }

    public int GetFruitScore(){
        return this.FruitScore;
    }

    public void SetFruitScore(int score){
        this.FruitScore=score;
    }
}
