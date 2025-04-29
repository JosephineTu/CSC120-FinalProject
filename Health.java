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
    public void doExercise(){
        this.healthIndex+=5;
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
    public void impactHealth(){
        switch(this.diseaseType){
            case DISEASE.Diarrhea:
            this.healthIndex-=10;
            break;
            case DISEASE.Commoncold:
            this.healthIndex-=10;
            break;
            case DISEASE.Cancer:
            this.healthIndex-=30;
            break;
            case DISEASE.Flu:
            this.healthIndex-=15;
            break;
            case DISEASE.Pneumonia:
            this.healthIndex-=20;
            break;
            default:
            break;
        }
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
    public boolean findDoctor(Scanner input){
        if(this.isSick){
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
            }
            if (answer==true){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
    public void cureDisease(boolean yes){
        if(yes){
            switch(this.diseaseType){
                case DISEASE.Diarrhea:
                this.diseaseType=null;
                break;
                case DISEASE.Commoncold:
                this.diseaseType=null;
                break;
                case DISEASE.Flu:
                Random rand1=new Random();
                int odd=rand1.nextInt(0,100);
                if(odd!=99){
                    this.diseaseType=null;
                    break;
                } else{
                    this.healthIndex=0;
                    break;
                }
                case DISEASE.Pneumonia:
                Random rand2=new Random();
                int odd2=rand2.nextInt(0,8);
                if(odd2!=7){
                    this.diseaseType=null;
                } 
                break;
                case DISEASE.Cancer:
                Random rand3=new Random();
                int odd3=rand3.nextInt(0,5);
                if(odd3!=4){
                    this.diseaseType=null;
                }
                break;
                default:
                break;
            }
        }
    }

}