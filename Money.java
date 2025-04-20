import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
public class Money {
    
    private int amount;

    public Money(int amount){
        this.amount = amount;
        Hashtable<String, Integer> house = new Hashtable<>();
    }

    public void buyLottery(int lotteryPrice){
        this.amount -= lotteryPrice;
        // random number generator decide if win
        // random number generator decide win how much
        this.amount += winPrize;
    }

    public void buyHouse(){
        Scanner s = new Scanner(System.in);
        System.out.println("Which house do you want to buy?");
        String name = s.nextLine();
        this.house.add(name);
        // random number generator?
        this.amount-=300;
        s.close();
    }

    public void sellHouse(){
        Scanner s = new Scanner(System.in);
        System.out.println("Which house do you want to sell?");
        String name = s.nextLine();
        this.house.remove(name);
        this.amount += 300;
        s.close();
    }

}
