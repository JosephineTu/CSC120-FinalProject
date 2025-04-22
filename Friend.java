public class Friend extends Person{


    //attributes
   private boolean isFriend;

   //constructor
   public Friend(int age, String name, int relationshipValue, boolean isAlive){
    super(age, name, relationshipValue, isAlive);
    this.isFriend = true;
   }

   public boolean getisFriends(Player player){
    System.out.println(Player.getname(player)+" and "+ getname(this)+ " are friends");
    return this.isFriend;
   }

   public boolean breakupwfriends(Player player){
    System.out.println(Player.getname(player)+" and "+ getname(this)+ " are not friends anymore.");
    return this.isFriend == false;
   }

   public void buyGift(Player p){
    p.money.house.add(new House("Gift",200.0,1));
   }



}
