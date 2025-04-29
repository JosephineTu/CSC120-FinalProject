import java.util.ArrayList;
public class Player extends Person{
    public Health health;
    public Intelligence intelligence;
    public Money money;
    public ArrayList<Person> people;
    public Player(int age, String name, int relationshipValue, boolean isAlive,Health health,Intelligence intelligence,Money money,ArrayList<Person>people){
        super(age, name, relationshipValue, isAlive);
        this.health = health;
        this.intelligence = intelligence;
        this.money = money;
        this.people=people;
    }
    public void readBook(){
        if(this.intelligence.value<98){
            this.intelligence.value+=3;
        } else{
            this.intelligence.value=100;
        }
    }

}
