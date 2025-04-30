// import java packages
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
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
        this.gamecontinues=true;
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
    /**
     * Ask player to input commands for each year playing the game. 
     * @parm Player p
     * @param Scanner input
     * @param Time time
     */
    public void everyYear(Player p, Scanner input, Time time) {
        int counter = 0;
        boolean termLoop = false;
        p.printManifest();
    
        while (counter < 3 && !termLoop) {
            System.out.println("What do you want to do? (exercise, read, sell, ask, next)");
            String ans = searchInput(input).toUpperCase();
    
            switch (ans) {
                case "EXERCISE":
                    p.health.doExercise();
                    counter++;
                    break;
    
                case "READ":
                    p.intelligence.readBook();
                    counter++;
                    break;
    
                case "SELL":
                    p.money.sellHouse(input, time.counter);
                    counter++;
                    break;
    
                case "NEXT":
                    termLoop = true;
                    break;
    
                case "ASK":
                    ArrayList<FamilyMember> availablePpl = new ArrayList<>();
                    for (Person familyMember : p.people) {
                        if (familyMember instanceof FamilyMember) {
                            availablePpl.add((FamilyMember) familyMember);
                        }
                    }
    
                    if (availablePpl.isEmpty()) {
                        System.out.println("There are no family members to ask.");
                        break;
                    }
    
                    for (int i = 0; i < availablePpl.size(); i++) {
                        System.out.println((i + 1) + ":");
                        availablePpl.get(i).printManifest(time.getTime());
                    }
    
                    System.out.println("Who do you want the money from? Please enter the corresponding number.");
                    int ans1 = input.nextInt();
                    input.nextLine(); // consume newline
                    if (ans1 < 1 || ans1 > availablePpl.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }
    
                    System.out.println("How much do you want?");
                    int amt = input.nextInt();
                    input.nextLine(); // consume newline
                    int actualAmt=availablePpl.get(ans1 - 1).askForMoney(amt);
                    p.money.amount+=(double)actualAmt;
                    counter++;
                    break;
    
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    
        time.timeGo();
    }
    /*
     * the main loop that keeps the game running if boolean gamecontinues is true
     */
    public void mainLoop(Scanner input){
        do{
            everyYear(this.player,input,gameTime);
            if(this.player.health.getHealthIndex()<=0){
                this.gamecontinues=false;
            }
        } while(this.gamecontinues==true);
    }
    public static void main (String[] args){
        Player me=new Player(0,"Josephine",100,"me",true,new Health(95),new Intelligence(85),new Money(0),new ArrayList<>());
        Time gt=new Time();
        RunGame game=new RunGame(me);
        Scanner input=new Scanner(System.in);
        FamilyMember arkintu=new FamilyMember(31, "ArkinTu", "father", 100, true, true);
        me.people.add(arkintu);
        game.mainLoop(input);
    }
}