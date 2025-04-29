import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class RunGame{
    public Time gameTime;
    public Player player;
    public boolean gamecontinues;
    public final HashMap<String,String> commands=
    new HashMap<>(Map.of("exercise","EXERCISE","read","READ",
    "sell","SELL","next","NEXT","ask","ASK"));
    public RunGame(Player player){
        this.gameTime=new Time();
        this.player=player;
    }
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
    public void everyYear(Player p,int year,Scanner input,Time time){
        int counter=0;
        boolean termLoop=false;
        while(counter<5 && termLoop==false){
            String ans=searchInput(input);
            switch(ans){
                case "EXERCISE":
                p.health.doExercise();
                case "READ":
                p.intelligence.readBook();
                case "SELL":
                
            }
        }
        time.timeGo();
    }
    public void mainLoop(){
        do{

        } while(this.gamecontinues==true);
    }
}