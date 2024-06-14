public class Time {
    
    private int min;
    private int sec;

    public Time(int min, int sec)
    {
        this.min = min;
        this.sec = sec;
    }

    public String getLevelTime()
    {
        return min + ":" + sec;
    }

    public int getMin()
    {
        return this.min;
    }

    public int getSec()
    {
        return this.sec;
    }

    public void oneSecondPassed(){
        if(sec == 0)
        {
            min--;
            sec = 60;
        }
        sec--;
    }
}
