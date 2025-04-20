public class Player extends Person{


    private Health health;
    private Intelligence intelligence;
    private Money money;

    public Player(int age, String name, int relationshipValue, boolean isAlive  ){
        super(age, name, relationshipValue, isAlive);
        this.health = health;
        this.intelligence = intelligence;
        this.money = money;
    }

}
