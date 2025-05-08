public class Partner extends Person {

    //attributes
    public boolean isInrelationship;
    public boolean isMarried;

    // Constructor
    public Partner(int age, String relationshipType,String name, int relationshipValue, boolean isAlive) {
        super(age,relationshipType,name, relationshipValue, isAlive);  // Call to the parent class constructor
        this.isInrelationship = false;
        this.isMarried = false;
    }

    /**
     * player can get married with the partner and a messgae will be printed
     * @param player the person you want to get married with
     * @return this.isMarried will be true when they get married
     */
    public boolean getMarried(Player player){
        this.isMarried = true;
        System.out.println(Player.getname(player)+" and "+ getname(this)+ " get married!");
        return this.isMarried;
        
    }

    /**
     * the partner could decide to break up with the player
     */
    public void breakUp(){
        if(this.isInrelationship==true){
            this.isInrelationship=false;
            System.out.println(this.name+" broke up with you...");
        }
    }

    /**
     * The partner could get divorce with the player
     * @param p the person you want to divorce with
     * @return true if they got divorced
     */
    public boolean divorce(Player p){
        if(this.isMarried==true){
            this.isMarried=false;
            p.money.amount=p.money.amount/2;
            System.out.println(this.name+" left you and took away half of your money.");
        }
        return true;
    }









}

