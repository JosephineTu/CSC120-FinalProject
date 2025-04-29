public class Friend extends Person{


   //attributes
   private boolean isFriend;

   //constructor
   public Friend(int age, String name, int relationshipValue, String relationshipType, boolean isAlive){
   super(age, relationshipType, name, relationshipValue, isAlive);
   this.isFriend = true;
   }
   /**
    * getisFriends(Player player), get the friendship status with a Friend
    * @param player
    * @return boolean isFriend
    */
   public boolean getisFriends(Player player){
    System.out.println(Player.getname(player)+" and "+ getname(this)+ " are friends");
    return this.isFriend;
   }
   
   /**
    * buyGift(Player p), add a gift house to Player's assets,
    * @param p
    */
   public void buyGift(Player p){
    //test if the relationshipValue is high enough
    if(this.relationshipValue>90){
        p.money.house.add(new House("Gift",200000.0,1));
    }
   }

}
