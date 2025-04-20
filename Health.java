import java.util.Random;
import java.util.Scanner;
public class Health {
    private int healthIndex;
    public boolean isSick;
    private DISEASE diseaseType;
    public Health(int healthIndex){
        this.healthIndex=healthIndex;
        this.isSick=false;
        this.diseaseType=null;
    }
    public int getHealthIndex(){
        return this.healthIndex;
    }
    public DISEASE fallSick(){
        DISEASE[] diseases=DISEASE.values();
        int index=new Random().nextInt(0,4);
        DISEASE myDisease=diseases[index];
        this.isSick=true;
        this.diseaseType=myDisease;
        System.out.println("You got "+myDisease+"!");
        return myDisease;
    }
    public int getMedicalCharge(){
        int charge=0;
        if(this.diseaseType==DISEASE.Cancer){
            charge=10000;
        }
        if(this.diseaseType==DISEASE.Commoncold){
            charge=25;
        }
        if(this.diseaseType==DISEASE.Diarrhea){
            charge=100;
        }
        if(this.diseaseType==DISEASE.Flu){
            charge=100;
        }
        if(this.diseaseType==DISEASE.Pneumonia){
            charge=2000;
        }
        return charge;

    }
    public boolean findDoctor(){
        if(this.isSick){
            Scanner input=new Scanner(System.in);
            GetYN yn=new GetYN();
            int charge=this.getMedicalCharge();
            System.out.println("There is a doctor who can cure your "+this.diseaseType+" The charge is "+charge+". Go to the doctor (y/n)?");
            String in=input.nextLine();
            boolean answer;
            try{
                answer=yn.yesOrNo(in);
            } catch(RuntimeException e){
                System.out.println("You entered something we cannot understand. Taken as a yes.");
                answer=true;
            input.close();
            }
            if (answer==true){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }


}