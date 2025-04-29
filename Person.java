public class Person {

    //Attributes
    protected int age;
    protected String relationshipType;
    protected String name;
    public int relationshipValue;
    protected boolean isAlive;

    //Constructor
    public Person(int age, String relationshipType,String name, int relationshipValue, boolean  isAlive){
        this.age = 0;
        this.name = name;
        this.relationshipType=relationshipType;
        this.relationshipValue = relationshipValue;
        this.isAlive = true;
    }


    public int getage(){
        System.out.println("You are "+this.age+" years old");
        return this.age;
    }

    public static String getname(Person person){
        return person.name;
    }



    public boolean getIsAlive() {
        if (this.isAlive == true) {
            System.out.println("You are alive");
            return this.isAlive;
        } else {
            System.out.println("You passed away");
            return this.isAlive;
        }
    }

    public void printManifest(){
        if(this.getIsAlive()){
            System.out.println(this.name+" is "+this.getage()+" years old, has "+this.relationshipValue+" relationships, alive.");
        }else{
            System.out.println(this.name+" i s"+this.getage()+" years old, has "+this.relationshipValue+" relationships,dead.");
        }
    }

    public int grow(int years){
        this.age += years;
        System.out.println("You are "+this.age+" years old now.");
        return this.age;

    }

    public boolean die(){
        this.isAlive = false;
        return this.isAlive;
    }
    public void endRelationship(Player p){
        p.people.remove(this);
        System.out.println("Your"+this.relationshipType+"ended their relationship with you.");
    }

}
    
        
    


