import java.util.ArrayList;
public class Partner extends Person {

    public boolean isInrelationship;
    public boolean isMarried;

    // Constructor
    public Partner(int age, String relationshipType,String name, int relationshipValue, boolean isAlive) {
        super(age,relationshipType,name, relationshipValue, isAlive);  // Call to the parent class constructor
        this.isInrelationship = false;
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
            System.out.println(this.name+" broke up with you...");
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









}

