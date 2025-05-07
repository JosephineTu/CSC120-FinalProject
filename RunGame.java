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
    "sell","SELL","next","NEXT","ask","ASK","drop","DROP",
    "lottery","LOTTERY","house","HOUSE","other","OTHER","help","HELP"));
    public ArrayList<Job> jobs=new ArrayList<>();
    public ArrayList<Partner> availablePartners=new ArrayList<>();
    public ArrayList<House> availableHouses=new ArrayList<>();
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
        Partner abigail = new Partner(-1, "girlfriend", "Abigail", 80, true);
        Partner sebastian = new Partner(1, "boyfriend", "Sebastian", 50, true);
        Partner sam = new Partner(1, "boyfriend", "Sam", 60, true);
        Partner elliot = new Partner(2, "boyfriend", "Elliot", 70, true);
        Partner emily = new Partner(1, "girlfriend", "Emily", 90, true);
        availablePartners.add(abigail);
        availablePartners.add(sebastian);
        availablePartners.add(sam);
        availablePartners.add(elliot);
        availablePartners.add(emily);
        House h1 = new House("MapleVilla", 250000, 1);
        House h2 = new House("CedarCottage", 180000, 2);
        House h3 = new House("BirchEstate", 300000, 3);
        House h4 = new House("WillowHeights", 450000, 1);
        House h5 = new House("OakHouse", 220000, 2);
        House h6 = new House("PineRetreat", 270000, 3);
        House h7 = new House("ElmResidence", 350000, 1);
        House h8 = new House("AshLodge", 200000, 2);
        House h9 = new House("SpruceManor", 600000, 3);
        House h10 = new House("ChestnutHaven", 320000, 1);
        availableHouses.add(h1);
        availableHouses.add(h2);
        availableHouses.add(h3);
        availableHouses.add(h4);
        availableHouses.add(h5);
        availableHouses.add(h6);
        availableHouses.add(h7);
        availableHouses.add(h8);
        availableHouses.add(h9);
        availableHouses.add(h10);
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
        return "OTHER";
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
            p.health.findDoctor(input, p);
        }
        event1(time.getTime(), p);
        event2(time.getTime(), p);
        event3(input,p,time.getTime());
        event4(p,input,time.getTime());
        event5(p,input,time.getTime());
        event6(p,input,gameTime.getTime());
        event7(p);
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
                case "LOTTERY":
                    p.money.buyLottery();
                case "HOUSE":
                    boolean end=false;
                    do{
                        System.out.println("Here are a list of available houses. Please enter the number corrsponding to the house you want to buy.");
                        for(int i=0;i<this.availableHouses.size();i++){
                            System.out.print((i+1)+": ");
                            this.availableHouses.get(i).printManifest();
                        }
                        int ans2=input.nextInt();
                        input.nextLine();
                        if(ans2<=this.availableHouses.size()){
                            if(p.money.amount>=this.availableHouses.get(ans2-1).price){
                                House sold=this.availableHouses.get(ans2-1);
                                sold.timeBought=time.getTime();
                                p.money.house.add(sold);
                                p.money.amount-=sold.price;
                                this.availableHouses.remove(sold);
                                System.out.println("You just bought a house!");
                                end=true;
                            } else{
                                System.out.println("Sorry, you can't afford this house.");
                                end=true;
                            }
                        } else{
                            System.out.println("Your current selection is not available. Try again? (y/n)");
                            GetYN yn=new GetYN();
                            String answer=input.nextLine();
                            boolean yesorNo=yn.yesOrNo(answer);
                            if(yesorNo==true){
                                end=false;
                            } else{
                                end=true;
                            }
                        } 
                    } while(!end);
                    counter++;
                    break;
            
                case "SELL":
                    end=false;
                    do{
                    if(p.money.house.isEmpty()){
                        System.out.println("You do not currently own a house.");
                        end=true;
                    } else{
                        System.out.println("Which house do you want to sell? Please enter the corresponding number.");
                        for (int i=0;i<p.money.house.size();i++){
                            p.money.house.get(i).printManifest();
                        }
                        int ans3=input.nextInt();
                        input.nextLine();
                        if(ans3<=p.money.house.size()){
                            House selected=p.money.house.get(ans3-1);
                            p.money.sellHouse(selected,time.getTime());
                            p.money.house.remove(selected);
                            end=true;
                        } else{
                            System.out.println("Your current selection is not available. Try again? (y/n)");
                            GetYN yn=new GetYN();
                            String answer=input.nextLine();
                            boolean yesorNo=yn.yesOrNo(answer);
                            if(yesorNo==true){
                                end=false;
                            } else{
                                end=true;
                            }
                        }}} while(end==false);
                        counter++;
                        break;
                case "OTHER":
                    System.out.println("Invalid action. Please try again.");
                    break;
                case "HELP":
                    System.out.println("Here are a list of valid commands:");
                    System.out.println("(do) exercise\n" + //
                                                "read (books)\n" + //
                                                "ask (for money)\n" + //
                                                "sell (house)\n" + //
                                                "drop (out)\n" + //
                                                "next (year)\n" + //
                                                "(buy) house\n" + //
                                                "(buy) lottery\n" + //
                                                "yes/no");
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
            if(this.player.health.getHealthIndex()<=0||this.gameTime.getTime()>70){
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
    public void event4(Player p,Scanner input,int time){
        Random rand=new Random();
        int odd=rand.nextInt(7);
        if(odd==6 && time>3){
            p.health.fallSick();
            p.health.findDoctor(input,p);
        }
    }
    public void event5(Player p, Scanner input, int time){
        Random odd=new Random();
        int puppylove=odd.nextInt(3);
        if(time>15 && time<25 && puppylove==2){
            Random rand=new Random();
            int random=rand.nextInt(this.availablePartners.size());
            Partner selectedPartner=availablePartners.get(random);
            System.out.println("You met "+selectedPartner.name+", their age is"+(selectedPartner.age+time)+", do you want to date them? (y/n)");
            String ans=input.nextLine();
            GetYN answer=new GetYN();
            boolean yn=answer.yesOrNo(ans);
            if(yn==true){
                selectedPartner.isInrelationship=true;
                availablePartners.remove(selectedPartner);
                p.partners.add(selectedPartner);
                System.out.println("Now you are dating "+selectedPartner.name+"!");
            }
        }
    }
    public void event6(Player p, Scanner input, int time){
        if(time>20 && !p.partners.isEmpty() && !p.partners.get(0).isMarried){
            System.out.println(p.partners.get(0).name+" proposed to you. Do you want to get married? (y/n)");
            GetYN yn=new GetYN();
            String ans=input.nextLine();
            boolean answer=yn.yesOrNo(ans);
            if(answer==true){
                p.partners.get(0).getMarried(p);
                p.isMarried=true;
            } else{
                Partner selected=p.partners.get(0);
                selected.breakUp();
                p.partners.remove(selected);
            }
        }
        
    }
    public void event7(Player p){
        if(p.isMarried==true && p.partners.size()>1){
            Random rand=new Random();
            int odd=rand.nextInt(3);
            if(odd==2){
                System.out.println(p.partners.get(0)+" found out about your other dates and want a divorce.");
                p.partners.get(0).divorce(p);
                p.partners.get(0).isInrelationship=false;
                p.partners.remove(p.partners.get(0));
            }
        }
    }
    public FamilyMember[] generateParents() {
        Random rand = new Random();
        String[] parentNames={"Alex", "Taylor", "Jordan", "Morgan", "Casey", "Riley", "Jamie", "Chris"};
        // Generate Mom
        int momAge = rand.nextInt(15) + 20; 
        String momName = parentNames[rand.nextInt(parentNames.length)];
        int momRelationshipValue = rand.nextInt(51) + 50; 
        boolean momIsAlive = true;
        boolean momCanGiveMoney = rand.nextBoolean(); 

        FamilyMember mom = new FamilyMember(
            momAge,
            momName,
            "Mom",
            momRelationshipValue,
            momIsAlive,
            momCanGiveMoney
        );
        int dadAge = rand.nextInt(15) + 20;
        String dadName = parentNames[rand.nextInt(parentNames.length)];
        int dadRelationshipValue = rand.nextInt(51) + 50;
        boolean dadIsAlive = true;
        boolean dadCanGiveMoney = rand.nextBoolean();

        FamilyMember dad = new FamilyMember(
            dadAge,
            dadName,
            "Dad",
            dadRelationshipValue,
            dadIsAlive,
            dadCanGiveMoney
        );

        return new FamilyMember[]{mom, dad};
    }

    public static void main (String[] args){
        Player me=new Player(0,"Josephine",100,"me",true,new Health(95),new Intelligence(85),new Money(0),new ArrayList<>());
        Time gt=new Time();
        RunGame game=new RunGame(me);
        Scanner input=new Scanner(System.in);
        FamilyMember[] parents=game.generateParents();
        me.people.add(parents[0]);
        me.people.add(parents[1]);
        game.mainLoop(input);
        input.close();
    }
}