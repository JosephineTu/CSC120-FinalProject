/*
 * Time class that keep track of the time in the game, is called by other classes as well. 
 * @version: April 29,2025. 
 */
public class Time {
    // Attributes
    public int counter;
    /*
     * Constructor
     */
    public Time(){
        this.counter=0;
    }
    /*
     * add counter every year in RunGame class
     */
    public void timeGo(){
        this.counter++;
    }
    /*
     * accessor for int counter 
     */
    public int getTime(){
        return this.counter;
    }
}
