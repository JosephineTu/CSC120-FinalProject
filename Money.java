import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Money {
    
    private int amount;
    private ArrayList<House> house;

    public Money(int amount){
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
