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


    public int getage(){
        return this.age;
    }

    public static String getname(Person person){
        return person.name;
    }



    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void printManifest(int time){
        if(this.getIsAlive()){
            int age=this.getage();
            System.out.println("Your "+this.relationshipType+" "+this.name+" is "+(age+time)+" years old, has a "+this.relationshipValue+" relationship with you");
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
    
        
    


