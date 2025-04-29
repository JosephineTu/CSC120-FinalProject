public class Partner extends Person {
    //this is a child class of person, write method for the partner of the player

    //attributes
    private boolean isInrelationship;
    private boolean isMarried;

    /**
     * Consturctor
     * @param age
     * @param name
     * @param relationshipValue
     * @param isAlive
     */
    public Partner(int age, String name, int relationshipValue, boolean isAlive) {
        super(age, name, relationshipValue, isAlive);  // Call to the parent class constructor
        this.isInrelationship = true;
        this.isMarried = false;
    }


    /**
     * get the marital status between the partner and the player
     * @param player the person the partner wants to get married with
     * @return whether the person is married as boolean
     */
    public boolean getmarried(Player player){
        this.isMarried = true;
        System.out.println(Player.getname(player)+" and "+ getname(this)+ " get married!");
        return this.isMarried;
        
    }

    /**
     * end the relationship between the player and their partner
     * @param n the partner you want to end relationship
     * @return whether player and their partner are in relationship as boolean
     */
    public boolean endRelationship(Partner n){
        this.isInrelationship = false;
        System.out.println("You are no longer partner with "+n+" .");
        return this.isInrelationship;
    }










}

