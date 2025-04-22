import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Money {
    
    public double amount;
    public ArrayList<House> house;

    public Money(double amount){
        this.amount = amount;
        ArrayList<House> house=new ArrayList<>();
    }

    public void buyLottery(){
        this.amount -=10;
        // random number generator decide if win
        Random rand=new Random();
        int randInt=rand.nextInt(0,10);
        if(randInt==10){
            // random number generator decide win how much
            int prize=rand.nextInt(10,10000);
            this.amount+=prize;
        } else{
            System.out.println("You did not win a prize, try again next time!");
        }

    }

    public void buyHouse(){
        House newHouse=new House("Downtown Studio",2000000,1);
        Scanner s = new Scanner(System.in);
        System.out.println("There is an available new house:"+newHouse.toString()+", buy it? (y/n)");
        String ans = s.nextLine();
        GetYN yesorNo=new GetYN();
        boolean yn=yesorNo.yesOrNo(ans);
        s.close();
        if(yn==true){
            this.amount-=newHouse.getPrice(0);
        }
    }

    public void sellHouse(House h){
        if(this.house.contains(h)){
            this.house.remove(h);
            this.amount+=h.getPrice(0);
        }
    }

}
