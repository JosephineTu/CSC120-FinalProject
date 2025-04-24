import java.util.Scanner;
public class RunGame{
    public Time gameTime;
    public Player player;
    public boolean gamecontinues;
    public UserInput ui;
    public RunGame(Player player){
        this.gameTime=new Time();
        this.player=player;
    }
    public void everyYear(Player p,int year, Scanner input){
        int counter=0;
        boolean termLoop=false;
        while(counter<5 && termLoop==false){
            System.out.println("Do you want to do something right now?");
            String ans=input.nextLine();
            int choice=ui.interpretToken(ans);
            switch(choice){
                case 0:
                System.out.println("We don't understand this.");
                case 1:
                if(year>4){
                    p.readBook();
                }else{
                    System.out.println("You don't know how to read yet.");
                }
            }
        }
    }
    public void mainLoop(){
        do{

        } while(this.gamecontinues==true);
    }
}