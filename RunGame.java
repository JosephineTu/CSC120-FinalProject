// import java packages
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
/*
 * RunGame class that serve as the main panel for player to play the game.
 * Keep all the main methods and attributes that runs the game.
 * @version: April 29, 2025
 */
public class RunGame{
    //Attributes
    public Time gameTime;
    public Player player;
    public boolean gamecontinues;
    public final HashMap<String,String> commands=
    new HashMap<>(Map.of("exercise","EXERCISE","read","READ",
    "sell","SELL","next","NEXT","ask","ASK"));
    /*
     * Constructor
     * @param Player player
     */
    public RunGame(Player player){
        this.gameTime=new Time();
        this.player=player;
    }
    /*
     * take in the commands user input to the class
     * @param Scanner input
     * @return String inputStr or null
     */
    public String searchInput(Scanner input){
        System.out.println("Do you want to do something right now?");
        String ans=input.nextLine();
        String[] tokens=ans.toLowerCase().split(" ");
        for(String word:tokens){
            if(this.commands.containsKey(word)){
                String inputStr=commands.get(word);
                return inputStr;         
            }
        }
        return null;
    }
    /*
     * Ask player to input commands for each year playing the game. 
     * @parm Player p
     * @param int year
     * @param Scanner input
     * @param Time time
     */
    public void everyYear(Player p,int year,Scanner input,Time time){
        int counter=0;
        boolean termLoop=false;
        while(counter<5 && termLoop==false){
            searchInput(input);
        }
        time.timeGo();
    }
    /*
     * the main loop that keeps the game running if boolean gamecontinues is true
     */
    public void mainLoop(){
        do{

        } while(this.gamecontinues==true);
    }
}