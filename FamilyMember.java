public class FamilyMember extends Person {

    private boolean canGiveMoney;

    public FamilyMember(int age, String name, int relationshipValue, boolean isAlive, boolean canGiveMoney){
        super(age, name, relationshipValue, isAlive);
        this.canGiveMoney=canGiveMoney;
    }

    public int AskforMoney(int amt){
        if(this.canGiveMoney==false){
            this.relationshipValue-=10;
            System.out.println("Your "+this.name+" refused to give you money.");
            return 0;
        } else{
            return amt;
        }
    }

}
