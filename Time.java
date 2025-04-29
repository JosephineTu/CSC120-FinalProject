public class Time {
    public int counter;
    public Time(){
        this.counter=0;
    }
    public void timeGo(){
        this.counter++;
    }
    public int getTime(){
        return this.counter;
    }
}
