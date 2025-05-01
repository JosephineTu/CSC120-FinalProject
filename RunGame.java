// import java packages
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    "sell","SELL","next","NEXT","ask","ASK","drop","DROP","other","OTHER"));
    public ArrayList<Job> jobs=new ArrayList<>();

    /*
     * Constructor
     * @param Player player
     */
    public RunGame(Player player){
        this.gameTime=new Time();
        this.player=player;
        this.gamecontinues=true;
        jobs.add(new Job("Retail Worker", DEGREE.HighSchool, 30000));
        jobs.add(new Job("Construction Worker", DEGREE.HighSchool, 35000));
        jobs.add(new Job("Customer Service Representative", DEGREE.HighSchool, 40000));
        jobs.add(new Job("Software Engineer", DEGREE.Bachelor, 100000));
        jobs.add(new Job("Data Analyst", DEGREE.Bachelor    , 70000));
        jobs.add(new Job("Research Assistant", DEGREE.Bachelor, 50000));
        jobs.add(new Job("University Lecturer", DEGREE.Master, 65000));
        jobs.add(new Job("Physician", DEGREE.PhD, 150000));
        jobs.add(new Job("NIH Scientist", DEGREE.PhD, 120000));
        jobs.add(new Job("AI Researcher", DEGREE.PhD, 130000));
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
        return "other";
    }
    /**
     * Ask player to input commands for each year playing the game. 
     * @parm Player p
     * @param Scanner input
     * @param Time time
     */
    public void everyYear(Player p, Scanner input, Time time) {
        if(p.health.diseaseType!=null){
            p.health.impactHealth();
        }
        event1(time.getTime(), p);
        event2(time.getTime(), p);
        event3(input,p,time.getTime());
        event4(p,input);
        p.money.amount+=p.money.annualIncome;
        int counter = 0;
        boolean termLoop = false;
        p.printManifest(time.getTime());
        while (counter < 3 && !termLoop) {
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
                case "DROP":
                    p.intelligence.dropOut();
                case "OTHER":
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
            everyYear(this.player,input,this.gameTime);
            if(this.player.health.getHealthIndex()<=0||this.gameTime.getTime()>50){
                this.gamecontinues=false;
                System.out.println("You died. Rest in peace!");
            }
        } while(this.gamecontinues==true);
    }
    public void event1(int time,Player p){
        if(time==6){
            p.intelligence.goToSchool();
        }
        if(time==28&&p.intelligence.getinSchool()==true){
            p.intelligence.dropOut();
        }
    }
    public void event2(int time,Player p){
        if((time==12||time==15||time==18||time==22||time==24)&&p.intelligence.getinSchool()==true){
            p.intelligence.takeExam();
        }
    }
    public void event3(Scanner input,Player p,int time){
        if(time>18 && p.money.isEmployed==false && p.intelligence.getinSchool()==false){
            System.out.println("Try to find a job? (y/n)");
            GetYN yn=new GetYN();
            String ans=input.nextLine();
            boolean answer=yn.yesOrNo(ans);
            if(answer==true){
                matchJob(p);
            }
        }
    }
    public void matchJob(Player p){
        ArrayList<Job> availableJobs=new ArrayList<>();
        for(Job b:this.jobs){
            if(p.intelligence.getDegree().ordinal()>=b.leastDegreeRequired.ordinal()){
                availableJobs.add(b);
            }
        }
        Random rand=new Random();
        int choice=rand.nextInt(availableJobs.size());
        p.money.currentJob=availableJobs.get(choice);
        p.money.annualIncome+=p.money.currentJob.annualIncome;
        System.out.println("You are now employed as a "+p.money.currentJob.name+"!");
        p.money.isEmployed=true;
    }
    public void event4(Player p,Scanner input){
        Random rand=new Random();
        int odd=rand.nextInt(7);
        if(odd==6){
            p.health.fallSick();
            p.health.findDoctor(input,p);
        }
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