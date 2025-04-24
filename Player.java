import java.util.ArrayList;
public class Player extends Person{
    private Health health;
    private Intelligence intelligence;
    public Money money;
    public ArrayList<Person> people;
    public Player(int age, String name, int relationshipValue, boolean isAlive,Health health,Intelligence intelligence,Money money,ArrayList<Person>people){
        super(age, name, relationshipValue, isAlive);
        this.health = health;
        this.intelligence = intelligence;
        this.money = money;
        this.people=people;
    }

}
