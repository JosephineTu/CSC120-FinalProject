public class Person {
// This is a Parent class, it has child class including Player, Partner, Friend, and FamilyMember.
// This is class can get some basic information of a person including age, name, number of relationships(relationshipValue), and whether the person is alive(isAlive).

    //Attributes
    protected int age; // the age of a person
    protected String name; // the name of a person
    protected int relationshipValue; //the number of relationships a person has
    protected boolean isAlive; // whether the person is alive

    /**
     * Consturctor
     * @param age
     * @param name
     * @param relationshipValue
     * @param isAlive
     */
    public Person(int age, String name, int relationshipValue, boolean  isAlive){
        this.age = 0;
        this.name = name;
        this.relationshipValue = relationshipValue;
        this.isAlive = true;
    }

    /**
     * get the age of the person
     * @return the age of the person as integer
     */
    public int  getage(){
        System.out.println("You are "+this.age+" years old");
        return this.age;
    }

    /**
     * get the name of the person
     * @param person
     * @return the name of the person as string
     */
    public static String getname(Person person){
        return person.name;
    }

    /**
     * get the number of relationships of a person
     * @return the number of relationships of the person
     */
    public int getrelationshipValue(){
        System.out.println("You have "+this.relationshipValue+"relationships");
        return this.relationshipValue;
    }

    /**
     * get one person whether is alive or not
     * @return true if the person is alive , false if the perso is dead as boolean
     */
    public boolean getIsAlive() {
        if (this.isAlive == true) {
            System.out.println("You are alive");
            return this.isAlive;
        } else {
            System.out.println("You passed away");
            return this.isAlive;
        }
    }

    /**
     * print out the basic information of one person, including age, name, and number of relationships
     */
    public void printManifest(){
        if(this.isAlive == true){
            System.out.println(this.name+" is "+this.age+" years old, has "+this.relationshipValue+" relationships, alive.");
        }else{
            System.out.println(this.name+" is"+this.age+" years old, has "+this.relationshipValue+" relationships, dead.");
        }
    }

    /**
     * a person's age can increase by the years the player want
     * @param years the number of years you want to grow older
     * @return the age after you growing years
     */
    public int grow(int years){
        this.age += years;
        System.out.println("You are "+this.age+" years old now.");
        return this.age;

    }

    /**
     * a person can pass away 
     * @return false when the person die
     */
    public boolean die(){
        this.isAlive = false;
        System.out.println("You passed away.");
        return this.isAlive;
    }



}
    
        
    


