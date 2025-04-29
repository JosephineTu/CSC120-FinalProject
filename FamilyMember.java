public class FamilyMember extends Person {
    // attributes
    // decides if this person can give money to the player
    private boolean canGiveMoney;

    public FamilyMember(int age, String name, String relationshipType, int relationshipValue, boolean isAlive, boolean canGiveMoney){
        super(age, relationshipType, name, relationshipValue, isAlive);
        this.canGiveMoney=canGiveMoney;
    }

    /**
     * askForMoney(int amt), adds money to player.money.amount, depends on the attribute of that family member
     * @param amt
     * @return the amount of money the player ask for, or 0 if you can't get money from this Person
     */
    public int askForMoney(int amt){
        if(this.canGiveMoney==false){
            // the relationship with a Person worsens if you ask for money from them
            this.relationshipValue-=10;
            System.out.println("Your "+this.name+" refused to give you money.");
            return 0;
        } else{
            return amt;
        }
    }

}
