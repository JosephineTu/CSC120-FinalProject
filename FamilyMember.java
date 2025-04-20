public class FamilyMember extends Person {

    private int money;

    public FamilyMember(int age, String name, int relationshipValue, boolean isAlive, int money){
        super(age, name, relationshipValue, isAlive);
        this.money = money;
    
    }

    public int AskforMoney(int amt){
        
        return this.money;
    }

}
