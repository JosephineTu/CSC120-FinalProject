import java.util.ArrayList;
public class Partner extends Person {

    private boolean isInrelationship;
    private boolean isMarried;

    // Constructor
    public Partner(int age, String relationshipType,String name, int relationshipValue, boolean isAlive) {
        super(age,relationshipType,name, relationshipValue, isAlive);  // Call to the parent class constructor
        this.isInrelationship = true;
        this.isMarried = false;
    }

    public boolean getMarried(Player player){
        this.isMarried = true;
        System.out.println(Player.getname(player)+" and "+ getname(this)+ " get married!");
        return this.isMarried;
        
    }
    public void breakUp(){
        if(this.isInrelationship==true){
            this.isInrelationship=false;
        }
    }
    public boolean divorce(Player p){
        if(this.isMarried==true){
            this.isMarried=false;
            p.money.amount=p.money.amount/2;
            System.out.println(this.name+" left you and took away half of your money.");
        }
        return true;
    }

    // public boolean endRelationship(Partner n){
    //     this.isInrelationship = false;
    //     System.out.println("You are no longer partner with "+n+" .");
    //     return this.isInrelationship;
    // }

    //public static void main(String[] args) {
        //Partner Alice = new Partner(30, "Alive", 20, true);
    //     Player Alex = new Player(30, "Alex", 10,true,new Health(100),new Intelligence(100),new Money(0));
    //     Alice.getmarried(Alex);
    // }







}

