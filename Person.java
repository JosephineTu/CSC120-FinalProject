public class Person {

    //Attributes
    protected int age;
    protected String relationshipType;
    protected String name;
    public int relationshipValue;
    protected boolean isAlive;

    //Constructor
    public Person(int age, String relationshipType,String name, int relationshipValue, boolean  isAlive){
        this.age=age;
        this.name = name;
        this.relationshipType=relationshipType;
        this.relationshipValue = relationshipValue;
        this.isAlive = true;
    }

    /**
     * get the person's age
     * @return this.age as an integer
     */
    public int getage(){
        return this.age;
    }

    /**
     * get the person's name
     * @param person
     * @return the person's name as a string
     */
    public static String getname(Person person){
        return person.name;
    }


    /**
     * check whether the person is alive or not
     * @return whether the person is alive as boolean
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * print out the basic information of the person
     * @param time
     */
    public void printManifest(int time){
        if(this.getIsAlive()){
            int age=this.getage();
            System.out.println("Your "+this.relationshipType+" "+this.name+" is "+(age+time)+" years old, has a "+this.relationshipValue+" relationship with you");
        }
    }

    /**
     * the person can grow a specific years
     * @param years the years you want to grow up
     * @return the age after growing as an integer
     */
    public int grow(int years){
        this.age += years;
        System.out.println("You are "+this.age+" years old now.");
        return this.age;

    }

    /**
     * a person can die
     * @return false as a boolean when the person is dead
     */
    public boolean die(){
        this.isAlive = false;
        return this.isAlive;
    }

    /**
     * the person can end a relationship
     * @param p the person who you want to end relationship with
     */
    public void endRelationship(Player p){
        p.people.remove(this);
        System.out.println("Your"+this.relationshipType+"ended their relationship with you.");
    }

}
    
        
    


