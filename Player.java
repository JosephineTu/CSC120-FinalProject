import java.util.ArrayList;// import the package we need 

public class Player extends Person{
// this is a child class of person, besides all the attributes from the parent class, it has other attributes that we need to use in the game.

    //attributes
    public Health health; // the health of the player
    public Intelligence intelligence; // the interlligence of the player
    public Money money; // the amount of money the player has
    public ArrayList<Person> people; // the list of friend and family member of the player

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
    public Player(int age, String name, int relationshipValue, boolean isAlive,Health health,Intelligence intelligence,Money money,ArrayList<Person>people){
        super(age, name, relationshipValue, isAlive);
        this.health = health;
        this.intelligence = intelligence;
        this.money = money;
        this.people=people;
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

}
