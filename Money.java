import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Money {
    
    public double amount;
    public ArrayList<House> house;
    public boolean isEmployed;
    public Job currentJob;
    public double annualIncome;

    public Money(double amount){
        this.amount = amount;
        this.house=new ArrayList<>();
        this.isEmployed=false;
        this.currentJob=null;
        this.annualIncome=0;
    }
    public void buyLottery(){
        this.amount -=10;
        // random number generator decide if win
        Random rand=new Random();
        int randInt=rand.nextInt(0,11);
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
    public void printManifest(){
        for(int i=1;i<this.house.size()+1;i++){
            System.out.println(i+": "+house.get(i-1));
        }
    }
    public double removeHouse(House h,int currentTime){
        double price=h.getPrice(currentTime);
        if(!this.house.remove(h)){
            throw new RuntimeException("Error: You do not own this house.");
        }
        return price;
    }
    public void sellHouse(House m, int time){
        this.amount+=m.getPrice(time);
        
    }

}
