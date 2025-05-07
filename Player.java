import java.util.ArrayList;// import the package we need 
import java.util.Scanner;
public class Player extends Person{
// this is a child class of person, besides all the attributes from the parent class, it has other attributes that we need to use in the game.

    //attributes
    public Health health; // the health of the player
    public Intelligence intelligence; // the interlligence of the player
    public Money money; // the amount of money the player has
    public ArrayList<Person> people; // the list of friend and family member of the player
    public ArrayList<Partner> partners;
    public boolean isMarried;
    /**
     * constructor
     * @param age
     * @param name
     * @param relationshipValue
     * @param isAlive
     * @param health
     * @param intelligence
     * @param money
     * @param people
     */
    public Player(int age, String name, int relationshipValue, String relationshipType, boolean isAlive,Health health,Intelligence intelligence,Money money,ArrayList<Person>people){
        super(age, relationshipType, name, relationshipValue, isAlive);
        this.health = health;
        this.relationshipType="me";
        this.intelligence = intelligence;
        this.money = money;
        this.relationshipValue=100;
        this.people=people;
        this.partners=new ArrayList<>();
        this.isMarried=false;
    }

    /**
     * the intelligence value of the player could be increase if reading books
     */
    public void readBook(){
        if(this.intelligence.value<98){
            this.intelligence.value+=3;
        } else{
            this.intelligence.value=100;
        }
    }
    public void printPeople(int time){
        for(int i=1;i<this.people.size()+1;i++){
            this.people.get(i-1).printManifest(time);
        }
    }
    public void endRelationship(Scanner input, int time){
        System.out.println("Here are the relationships you currently have: ");
        this.printPeople(time);
        System.out.println("Please enter the number corresponding to the relationship you want to end.");
    }
    public void printManifest(int time){
        System.out.println(this.name+" is "+(this.getage()+time)+" years old");
        System.out.println("------Player Statistics------");
        System.out.println("HEALTH: "+this.health.getHealthIndex());
        System.out.println("MONEY: "+this.money.amount);
        System.out.println("INTELLIGENCE: "+this.intelligence.value);
        System.out.println("------------------------------");
    }
}
