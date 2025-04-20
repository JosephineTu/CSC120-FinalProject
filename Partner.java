public class Partner extends Person {

    private boolean isInrelationship;
    private boolean isMarried;

    // Constructor
    public Partner(int age, String name, int relationshipValue, boolean isAlive) {
        super(age, name, relationshipValue, isAlive);  // Call to the parent class constructor
        this.isInrelationship = true;
        this.isMarried = false;
    }

    public boolean getmarried(Player player){
        this.isMarried = true;
        System.out.println(Player.getname(player)+" and "+ getname(this)+ " get married!");
        return this.isMarried;
        
    }

    public boolean endRelationship(Partner n){
        this.isInrelationship = false;
        System.out.println("You are no longer partner with "+n+" .");
        return this.isInrelationship;
    }

    public static void main(String[] args) {
        Partner Alice = new Partner(30, "Alive", 20, true);
        Player Alex = new Player(30, "Alex", 10,true,new Health(100),new Intelligence(100),new Money(0));
        Alice.getmarried(Alex);
    }

    private String getname() {
        throw new UnsupportedOperationException("Not supported yet.");

    }






}

